package com.thomsonreuters.ls.platform.services.analytics.ms

import java.io.IOException
import java.net.ServerSocket

import colossus.IOSystem
import colossus.protocols.http.Http
import colossus.service.Service
import com.thomsonreuters.ls.platform.services.analytics.si.DataEnrichmentServiceImpl
import com.thomsonreuters.ls.platform.services.analytics.spark.SparkDataContext

/**
 * Created by U0171827 on 01/07/2015.
 */

case class EnrichmentBaseEntry(listId: Int, id:Int, tId:Int)

object Starter {

  def port(initialPort:Int):Int = {
    def freePort:Int = {
      val socket:ServerSocket = new ServerSocket(0);
      val port = socket.getLocalPort
      socketClose(socket)
      return port
    }

    def socketClose(socket:ServerSocket):Boolean = {
      try {
        socket.close();
        return true
      }
      catch { case ioe: IOException => return false }
    }
    initialPort match {
      case 0 => freePort
      case _ => initialPort
    }
  }

  def main(args: Array[String]):Unit = {
    implicit val io_system = IOSystem()

    val sdcx:SparkDataContext=new SparkDataContext
    Service.serve[Http]("http-adminServer", port(args(0).toInt)) { context =>
      val routes = new DataEnrichmentServiceImpl(sdcx)
      context.handle { connection =>
        connection.become(routes.handler)
      }
    }
  }

}
