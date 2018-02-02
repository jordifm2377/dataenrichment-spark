package com.thomsonreuters.ls.platform.services.analytics.spark


import com.thomsonreuters.ls.platform.services.analytics.spark.dto.DistributionTypesDto

/**
 * Created by U0171827 on 01/07/2015.
 */
case class NetworkObject(noId:Int)
case class EnrichmentEntry(id:Int, tId:Int, noName:String, regName:String)

class SparkDataConnector(sdcx:SparkDataContext, noType:Int) {

  import org.apache.spark.SparkContext._

  val sc = sdcx.getDataContext
  val allNet = sdcx.getAllNetworksObject.getOrElse(noType, null)

  def work(noString:String):DistributionTypesDto = {
    val distributionTypesDto = new DistributionTypesDto

    val userNo = sc.parallelize(noString.split(",").map(no => no.toInt)).collect()
    val userEn = sc.parallelize(allNet.rdd_enrichmentEntryBC.value).filter(f => userNo.contains(f.tId))

      .map(row => EnrichmentEntry(row.id, row.tId, row.noName, row.regName)).collect()

    val countR=sc.parallelize(userEn).map(no=>(no.id, 1)).reduceByKey(_ + _).collect()
    val countN=sc.parallelize(userEn).map(no=>(no.tId, 1)).reduceByKey(_ + _).collect()
    val names=sc.parallelize(userEn).map(no=>(no.id, no.noName)).collect().distinct
    distributionTypesDto.setRr(allNet.rdd_countRRBC.value)
    distributionTypesDto.setNn(allNet.rdd_countNNBC.value)

    distributionTypesDto.setR(countR.map(rowR => (Integer.valueOf(rowR._1), Integer.valueOf(rowR._2))).toMap[Integer, Integer])
    distributionTypesDto.setN(countN.size)
    distributionTypesDto.setNames(names.map(rowN => (Integer.valueOf(rowN._1), rowN._2)).toMap[Integer, String])

    distributionTypesDto
  }
}