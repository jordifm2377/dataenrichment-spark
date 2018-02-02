package com.thomsonreuters.ls.platform.services.analytics.spark.dto;//package com.thomsonreuters.ls.platform.services.analytics.spark.dto;

/**
 * Created by U0171827 on 03/07/2015.
 */

class DistributionTypesDto {

    var nn:Integer = 0
    var n:Integer = 0
    var rr:Map[Integer, Integer] = null
    var r:Map[Integer, Integer] = null
    var names:Map[Integer, String] = null

    def getNn():Integer = {
        return nn;
    }

    def setNn(nn:Integer):Unit = {
        this.nn = nn;
    }

    def getN():Integer = {
        return n;
    }

    def setN(n:Integer):Unit = {
        this.n = n;
    }

    def getRr():Map[Integer, Integer] = {
        return rr;
    }

    def setRr(rr:Map[Integer, Integer]):Unit = {
        this.rr = rr;
    }

    def getR():Map[Integer, Integer] = {
        return r;
    }

    def setR(r:Map[Integer, Integer]):Unit = {
        this.r = r;
    }

    def getNames():Map[Integer, String] = {
        return names;
    }

    def setNames(names:Map[Integer, String]):Unit = {
        this.names = names;
    }

    override def toString():String = {
        "DistributionTypesDto [nn=" + nn + ", n=" + n + ", rr=" + rr + ", r=" + r + ", names=" + names + "]"
    }

}