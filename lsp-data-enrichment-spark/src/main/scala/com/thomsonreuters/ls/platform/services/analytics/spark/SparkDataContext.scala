package com.thomsonreuters.ls.platform.services.analytics.spark

import org.apache.spark.{sql, SparkConf, SparkContext}
import org.apache.spark.sql.{SchemaRDD, SQLContext}
import org.apache.spark.sql.cassandra.CassandraSQLContext
import org.apache.spark.broadcast.Broadcast

/**
 * Created by U0171827 on 01/07/2015.
 */
case class EnrichmentBaseEntry(listId: Int, id:Int, tId:Int, noName:String, regName:String)
case class EnrichmentBaseRR(listId: Int, id:Int, countRR:Long)
case class EnrichmentBaseNN(listId: Int, countNN:Long)

case class Network(rdd_enrichmentEntryBC:Broadcast[Array[EnrichmentBaseEntry]],
                   rdd_countRRBC:Broadcast[Map[Integer, Integer]],
                   rdd_countNNBC:Broadcast[Int])

class SparkDataContext {

  val conf = new SparkConf().setAppName("Simple Application").setMaster("local[6]").set("spark.cassandra.connection.host", "cg-mr-ins-06.emea1.cis.trcloud")
  val sc = new SparkContext(conf)
  val cc = new CassandraSQLContext(sc)

  cc.setKeyspace("analytics")

  def generateAllNetworks:Map[Int,Network] = {
    import org.apache.spark.SparkContext._

    val networksIds = List(-900,-901,-902,-903,-904,-905)
    val rdd_enrichmentEntry = cc.cassandraSql("SELECT listid, id, tid, blockname, regulationobjectname FROM enrichmentbase").collect()
    //val networkMap=scala.collection.mutable.Map[String,Network]()

    networksIds.map(nId => {
      val enrichmentEntryMap = sc.parallelize(rdd_enrichmentEntry).filter( f => f.getInt(0) == nId)
        .map(r => EnrichmentBaseEntry(r.getInt(0), r.getInt(1), r.getInt(2), r.getString(3), r.getString(4))).collect()
      val countRR = sc.parallelize(enrichmentEntryMap).map(row => (Integer.valueOf(row.id), Integer.valueOf(1)))
        .reduceByKey(_ + _).collect().toMap[Integer, Integer]
      val countNN = sc.parallelize(enrichmentEntryMap).map(row => (Integer.valueOf(row.tId), 1))
        .reduceByKey(_ + _).collect().size
      (nId -> new Network(sc.broadcast(enrichmentEntryMap),sc.broadcast(countRR),sc.broadcast(countNN)))
    }).toMap[Int, Network]
    /*
    networksIds.foreach(nId => {
      val enrichmentEntryMap = sc.parallelize(rdd_enrichmentEntry).filter( f => f.getInt(0) == nId)
      .map(r => EnrichmentBaseEntry(r.getInt(0), r.getInt(1), r.getInt(2), r.getString(3), r.getString(4))).collect()

      val countRR = sc.parallelize(enrichmentEntryMap).map(row => (Integer.valueOf(row.id), Integer.valueOf(1)))
        .reduceByKey(_ + _).collect().toMap[Integer, Integer]
      val countNN = sc.parallelize(enrichmentEntryMap).map(row => (Integer.valueOf(row.tId), 1))
        .reduceByKey(_ + _).collect().size

      networkMap.+=(nId.toString -> new Network(sc.broadcast(enrichmentEntryMap),sc.broadcast(countRR),sc.broadcast(countNN)))
    })*/
    //networkMap
  }

  val allNetworks = generateAllNetworks

  def getDataContext:SparkContext = {
    sc
  }

  def getDataCassandraContext:CassandraSQLContext = {
    cc
  }

  def getAllNetworksObject:Map[Int,Network] = {
    allNetworks
  }
}