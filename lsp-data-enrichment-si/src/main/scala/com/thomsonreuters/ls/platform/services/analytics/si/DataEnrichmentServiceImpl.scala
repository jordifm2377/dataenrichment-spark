package com.thomsonreuters.ls.platform.services.analytics.si

import java.util

import com.google.gson.Gson
import com.thomsonreuters.ls.platform.services.analytics.ct._
import colossus.protocols.http._
import colossus.service.Callback
import UrlParsing._
import HttpMethod._
import Callback.Implicits._
import com.thomsonreuters.ls.platform.services.analytics.si.utils.{PValueCalculator, EnrichmentPValueComparator}
import com.thomsonreuters.ls.platform.services.analytics.spark.dto.DistributionTypesDto
import com.thomsonreuters.ls.platform.services.analytics.spark.{SparkDataConnector, SparkDataContext}
import java.util.Collections

import scala.collection.mutable.ListBuffer


class DataEnrichmentServiceImpl(sdcx:SparkDataContext) {

  import scala.collection.JavaConverters._

  val enrichmentPValueComparator:EnrichmentPValueComparator = new EnrichmentPValueComparator()
  val pValueCalculator:PValueCalculator = new PValueCalculator

  val handler: PartialFunction[HttpRequest, Callback[HttpResponse]] = {
    case request@Get on Root / "ping" => request.ok("pong")
    case request@Post on Root / "dataEnrichment" / "rest" / "dataenrichment" / "enrichments" => {
      val enrichmentInput = new Gson().fromJson(request.entity.get.utf8String, classOf[EnrichmentInput])
      val token:String = "el token!!!"
      val enrichmentsIn:EnrichmentsIn = new EnrichmentsIn
      enrichmentsIn.setType("intersection")
      val setMode:String = "intersection"
      val tokenN:Integer = 1
      val analysisType = enrichmentInput.getEnrichments.get(0).getType
      val sdcn:SparkDataConnector = new SparkDataConnector(sdcx, analysisType.toInt)
      val distributionTypesDto:DistributionTypesDto = sdcn.work(enrichmentInput.getLists.get(0).getToken)
      val entries:List[EnrichmentEntry]  = getEntryByNWObjIDs(token, distributionTypesDto)
      var enrichmentOut:EnrichmentOut = null
      enrichmentOut = getEnrichmentOut(enrichmentsIn, setMode, enrichmentOut, tokenN, entries)
      val enrichmentList:java.util.List[EnrichmentOut] = new util.ArrayList()
      enrichmentList.add(enrichmentOut)
      val enrichments = new Enrichments()
      enrichments.setToken("el token22222!!!")
      enrichments.setEnrichmentOuts(enrichmentList)
      val output = new EnrichmentsByTokenOutput
      output.setEnrichments(enrichments)
      val out:String = new Gson().toJson(output)
      request.ok(out)
    }
    case request@Get on Root => request.error("Not valid request", List("404" -> "Not Found"))
  }

  def getEntryByNWObjIDs(token:String, distr:DistributionTypesDto ):List[EnrichmentEntry] = {
    if (distr == null || distr.getR() == null || distr.getR().size <= 0)
      return null

    var entries:ListBuffer[EnrichmentEntry] = ListBuffer.empty
    if (distr != null && distr.getR() != null && distr.getR().size > 0) {
      distr.getR().foreach(row => { val key = row._1
        val pval = pValueCalculator.calculatePValue(distr.getR().get(key).get,distr.getNn(),distr.getN(),distr.getRr().get(key).get)
        val inputList = new InputList(token, pval, distr.getR().get(key).getOrElse(0), distr.getRr().get(key).getOrElse(0))
        entries.+=(new EnrichmentEntry(row._1, distr.getNames().get(key).getOrElse(null), java.util.Arrays.asList(inputList)))
      });
    }
    entries.toList
  }


  def getEnrichmentOut(enrichment:EnrichmentsIn, setMode:String, enrichmentOut:EnrichmentOut, tokenN:Integer, entries:List[EnrichmentEntry]): EnrichmentOut = {
    var enrichmentOutFinal:EnrichmentOut = null
    if (entries != null && entries.size > 0) {
      val entriesJavaList = entries.sortWith(compfn1).asJava
      calculateFDR(entriesJavaList)
      if (enrichmentOut == null) {
        enrichmentOutFinal = new EnrichmentOut(enrichment.getType(), entriesJavaList);
      } else {
        enrichmentOutFinal = enrichmentOut
/*
        enrichmentOut.setEntries(setMode.equals(EnrichmentConsts.INTERSECT) ?
          intersectEntries(enrichmentOut.getEntries(), entries, tokenN) :
          mergeEntries(enrichmentOut.getEntries(), entries));
*/
      }
    }
    return enrichmentOutFinal;
  }

  def compfn1(enrichmentEntry: EnrichmentEntry, enrichmentEntry2: EnrichmentEntry):Boolean = {
    val list1: InputList = enrichmentEntry.getInputLists.get(0)
    val list2: InputList = enrichmentEntry2.getInputLists.get(0)
    val val1: Double = list1.getPvalue.getValue
    val val2: Double = list2.getPvalue.getValue
    return val1.<=(val2)
  }

  def calculateFDR(entries:java.util.List[EnrichmentEntry]):Unit = {
    val Q:Integer = entries.size
    entries.get(Q - 1).getInputLists().get(0).setFDR(entries.get(Q - 1).getInputLists().get(0).getPvalue())
    for(i <-(Q-2) to 0 by -1) {
      entries.get(i).getInputLists().get(0).setFDR(ScientificDouble.wrap(Math.min(entries.get(i + 1).getInputLists().get(0).getFDR().getValue(), entries.get(i).getInputLists().get(0).getPvalue().getValue() * Q / (i + 1))));
    }
  }

  def  mergeEntries(entries:List[EnrichmentEntry], entriesToAdd:List[EnrichmentEntry]):List[EnrichmentEntry] = {
/*
    for (EnrichmentEntry entryToAdd : entriesToAdd) {
      boolean exists = false;
      for (int i = 0; i < entries.size(); i++) {
        if (entries.get(i).getId().equals(entryToAdd.getId())) {
          entries.get(i).getInputLists().addAll(entryToAdd.getInputLists());
          exists = true;
        }
      }
      if (!exists) {
        entries.add(entryToAdd);
      }
    }
    return entries;
*/
    null
  }

}