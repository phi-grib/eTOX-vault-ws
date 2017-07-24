package controllers

import play.api._
import play.api.mvc._
import java.sql.DriverManager
import java.sql.ResultSet
import scala.collection.mutable.ArrayBuffer
import play.api.libs.iteratee.Enumerator
import play.api.libs.json._
import java.util.Properties
import java.io.FileInputStream


object Application extends Controller {
  val defaultProps = readPropertiesFile("conf/etoxvault.properties")
  
  val auth_key = defaultProps.getProperty("auth_key")
  val server_db_url = defaultProps.getProperty("dbURL")
  val user = defaultProps.getProperty("dbUser")
  val password = defaultProps.getProperty("dbPassword")

  var sqlConnection: java.sql.Connection = null
  def readPropertiesFile(file: String) = {
    
    var defaultProps = new Properties()
    var in = new FileInputStream(file)
    defaultProps.load(in)
    in.close()
    defaultProps
  }

  def getJsonForSoftware(idmodel: String): String = {
    val sql = " select distinct software.softwaredescription,software.license " +
      " from model, modelsoftware, software" +
      "  where model.idmodel=modelsoftware.idmodel and modelsoftware.idsoftware= software.idsoftware" +
      " and model.idmodel=" + idmodel
    getQueryJSONBase(sql, false)
  }

  def getRowJson(resultSet: ResultSet, rec: Boolean) = {
    val metadata = resultSet.getMetaData()
    val columnCount = metadata.getColumnCount()
    var jsline = ""

    val row = for (i <- 1 to columnCount) yield ("\""+metadata.getColumnLabel(i)+"\"" -> resultSet.getString(i))
    val mp1 = row.toList.toMap
    println(mp1)
    val mp = if (rec)
      mp1
    else
      mp1
    val js = Json.toJson(mp)
    js.toString
  }

  def getQueryJSONBase(query: String, rec: Boolean) = {

    var resultSet = doQuerySQL(sqlConnection, query)
    var metadata = resultSet.getMetaData()

    var i = 1
    var js = ""
    var lines = ArrayBuffer[String]()

    while (resultSet.next) {
      val columnCount = metadata.getColumnCount()
      var jsline = getRowJson(resultSet, rec)
      jsline = "\n" + jsline
      lines += jsline
    }

    var json: java.lang.StringBuffer = new StringBuffer();

    for (i <- 0 to lines.size - 1) {
      if (i == lines.size - 1)
        json.append(lines(i))
      else
        json.append(lines(i) + ",")
    }

    json.toString()
  }

  def doQuerySQL(sqlConnection: java.sql.Connection, query: String) = {

    Logger.debug("doQuerySQL: \n" + query)
    var statement = sqlConnection.createStatement()
    statement.execute(query)
    statement.getResultSet()

  }

  def allmodels(authkey: String) =
    Action {
      if (authkey == this.auth_key) {

        sqlConnection = DriverManager.getConnection(this.server_db_url, this.user, this.password)
        val stmodel = getQueryJSONBase("SELECT idmodel,  modeltitle, modelid, version , partner,modeltag,verification_status from model ", true)
        if (stmodel == "") {
          Logger.debug("Not found")
          Result(
            header = ResponseHeader(404, Map()),
            body = Enumerator("Not found".getBytes()))
        } else {

          Logger.debug("Response: " + stmodel)
          sqlConnection.close()
          val sr = Result(
            header = ResponseHeader(200, Map(CONTENT_TYPE -> "application/json")),
            body = Enumerator(("[" ++ stmodel ++ "]").getBytes()))
          sr
        }
      } else
        Result(
          header = ResponseHeader(403, Map()),
          body = Enumerator("Not authorised".getBytes()))

    }

  def modelinfo(model_id: Int, authkey: String) = Action {
    if (authkey == this.auth_key) {

      sqlConnection = DriverManager.getConnection(this.server_db_url, this.user, this.password)
      val stmodel = getQueryJSONBase("SELECT idmodel, creationdate, contactname, contactemail, `references`, modeltitle, modelid, version, keywords, relatedmodels, endpointdefinition, dependentvariable, datasource, trainingsize, trainingtype, trainingcuration, endpointpositivesperc, endpointmin, endpointmax, endpointavg, endpointskewed, compoundidentifier, compounddetails, modeltype, modelalgorithm, testselection, descriptorsdefinition, descriptorsselection, ADassessment, ADmethod, goftp, goftn, goffp, goffn, gofr2, gofrmse, inferentialstats, externaldetails, testsize, externaltp, externaltn, externalfp, externalfn, externalq2, externalsdep, externalother, internalq2, internalsdep, mechanisticbasis, mechanisticother, referencesother, supportinginfo, partner, endpointspecies, computationurl, valuetype, valuerange,interpretation,modeltag,verification_status,units " +
        " FROM `etoxvault`.`model` " +
        " where idmodel='" + model_id + "'",
        true)
      if (stmodel == "") {
        Logger.debug("Not found")
        Result(
          header = ResponseHeader(404, Map()),
          body = Enumerator("Not found".getBytes()))
      } else {
        val stsoft = getJsonForSoftware(model_id.toString)
        val stsoft2 = " \"software\" : [ " + stsoft + "]"
        Logger.debug("Response: " + (stmodel.take(stmodel.length - 1) + "," + stsoft2 + "}"))
        sqlConnection.close()
        val sr = Result(
          header = ResponseHeader(200, Map(CONTENT_TYPE -> "application/json")),
          body = Enumerator((stmodel.take(stmodel.length - 1) + "," + stsoft2 + "}").getBytes()))
        sr
      }
    } else
      Result(
        header = ResponseHeader(403, Map()),
        body = Enumerator("Not authorised".getBytes()))

  }

  def getModelIdForModelTag(modeltag: String) = {
    val resultSet = doQuerySQL(sqlConnection, "select idmodel from model where modeltag='" + modeltag + "' order by version desc limit 1")
    var metadata = resultSet.getMetaData()
    resultSet.next
    resultSet.getInt(1)
  }

  def getModelIdForModelTag_version(modeltag: String, version: String) = {
    val resultSet = doQuerySQL(sqlConnection, "select idmodel from model where modeltag='" + modeltag + "' and version='" + version + "'")
    var metadata = resultSet.getMetaData()
    resultSet.next
    resultSet.getInt(1)
  }

  def modelinfoByTag(modeltag: String, provider: String, authkey: String, version: Option[String]) = Action {
    println("Input:")
    println(provider)
    println(modeltag)
    println(version)
    if (authkey == this.auth_key) {
      sqlConnection = DriverManager.getConnection(this.server_db_url, this.user, this.password)
      val stmodel = version match {
        case None => getQueryJSONBase("SELECT idmodel, creationdate, contactname, contactemail, `references`, modeltitle, modelid, version, keywords, relatedmodels, endpointdefinition, dependentvariable, datasource, trainingsize, trainingtype, trainingcuration, endpointpositivesperc, endpointmin, endpointmax, endpointavg, endpointskewed, compoundidentifier, compounddetails, modeltype, modelalgorithm, testselection, descriptorsdefinition, descriptorsselection, ADassessment, ADmethod, goftp, goftn, goffp, goffn, gofr2, gofrmse, inferentialstats, externaldetails, testsize, externaltp, externaltn, externalfp, externalfn, externalq2, externalsdep, externalother, internalq2, internalsdep, mechanisticbasis, mechanisticother, referencesother, supportinginfo, partner, endpointspecies, computationurl, valuetype, valuerange,interpretation,modeltag,verification_status,units " +
          "FROM `etoxvault`.`model` where modeltag='" + modeltag + "' and partner='" + provider + "' order by version desc limit 1", true)
        case Some(version) => getQueryJSONBase("SELECT idmodel, creationdate, contactname, contactemail, `references`, modeltitle, modelid, version, keywords, relatedmodels, endpointdefinition, dependentvariable, datasource, trainingsize, trainingtype, trainingcuration, endpointpositivesperc, endpointmin, endpointmax, endpointavg, endpointskewed, compoundidentifier, compounddetails, modeltype, modelalgorithm, testselection, descriptorsdefinition, descriptorsselection, ADassessment, ADmethod, goftp, goftn, goffp, goffn, gofr2, gofrmse, inferentialstats, externaldetails, testsize, externaltp, externaltn, externalfp, externalfn, externalq2, externalsdep, externalother, internalq2, internalsdep, mechanisticbasis, mechanisticother, referencesother, supportinginfo, partner, endpointspecies, computationurl, valuetype, valuerange,interpretation,modeltag,verification_status,units " +
          "FROM `etoxvault`.`model` where modeltag='" + modeltag + "' and partner='" + provider + "' and version='" + version + "'", true)
      }
      if (stmodel == "") {
        Logger.debug("Not found")
        Result(
          header = ResponseHeader(404, Map()),
          body = Enumerator("Not found".getBytes()))
      } else {
        //
        val model_id = version match {
          case None          => getModelIdForModelTag(modeltag)
          case Some(version) => getModelIdForModelTag_version(modeltag, version)
        }

        println("Model id:" + model_id)
        //
        val stsoft = getJsonForSoftware(model_id.toString)
        val stsoft2 = " \"software\" : [ " + stsoft + "]"
        Logger.debug("Response: " + (stmodel.take(stmodel.length - 1) + "," + stsoft2 + "}"))
        sqlConnection.close()
        val sr = Result(
          header = ResponseHeader(200, Map(CONTENT_TYPE -> "application/json")),
          body = Enumerator((stmodel.take(stmodel.length - 1) + "," + stsoft2 + "}").getBytes()))

        sr
      }
    } else
      Result(
        header = ResponseHeader(403, Map()),
        body = Enumerator("Not authorised".getBytes()))

  }

}
