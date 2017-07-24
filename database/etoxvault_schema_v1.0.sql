-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: lamia.upf.edu    Database: etoxvault
-- ------------------------------------------------------
-- Server version	5.1.42-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `idmodel` int(11) NOT NULL AUTO_INCREMENT,
  `creationdate` datetime NOT NULL,
  `contactname` varchar(255) NOT NULL,
  `contactemail` varchar(255) NOT NULL,
  `references` text,
  `modeltitle` varchar(255) NOT NULL,
  `modelid` varchar(255) NOT NULL,
  `version` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `relatedmodels` varchar(255) DEFAULT NULL,
  `endpointdefinition` text NOT NULL,
  `dependentvariable` varchar(255) NOT NULL,
  `datasource` text,
  `trainingsize` double(9,0) unsigned DEFAULT NULL,
  `trainingtype` text,
  `trainingcuration` text,
  `endpointpositivesperc` float(6,2) unsigned DEFAULT NULL,
  `endpointmin` double(10,4) DEFAULT NULL,
  `endpointmax` double(10,4) DEFAULT NULL,
  `endpointavg` double(10,4) DEFAULT NULL,
  `endpointskewed` varchar(255) DEFAULT NULL,
  `compoundidentifier` varchar(255) DEFAULT NULL,
  `compounddetails` varchar(255) DEFAULT NULL,
  `modeltype` varchar(255) NOT NULL,
  `modelalgorithm` text NOT NULL,
  `testselection` text,
  `descriptorsdefinition` text,
  `descriptorsselection` text,
  `ADassessment` text,
  `ADmethod` text,
  `goftp` int(11) DEFAULT NULL,
  `goftn` int(11) DEFAULT NULL,
  `goffp` int(11) DEFAULT NULL,
  `goffn` int(11) DEFAULT NULL,
  `gofr2` double(6,4) DEFAULT NULL,
  `gofrmse` double(10,4) DEFAULT NULL,
  `inferentialstats` varchar(255) DEFAULT NULL,
  `externaldetails` text NOT NULL,
  `testsize` int(11) NOT NULL,
  `externaltp` int(11) DEFAULT NULL,
  `externaltn` int(11) DEFAULT NULL,
  `externalfp` int(11) DEFAULT NULL,
  `externalfn` int(11) DEFAULT NULL,
  `externalq2` double(6,4) DEFAULT NULL,
  `externalsdep` double(10,4) DEFAULT NULL,
  `externalother` varchar(255) DEFAULT NULL,
  `internalq2` double(6,4) DEFAULT NULL,
  `internalsdep` double(10,4) DEFAULT NULL,
  `mechanisticbasis` text,
  `mechanisticother` text,
  `referencesother` text,
  `supportinginfo` text,
  `partner` varchar(10) NOT NULL,
  `endpointspecies` varchar(255) DEFAULT NULL,
  `computationurl` varchar(255) DEFAULT NULL,
  `valuetype` varchar(30) DEFAULT NULL,
  `valuerange` varchar(100) DEFAULT NULL,
  `interpretation` text,
  `modeltag` varchar(1000) DEFAULT NULL,
  `verification_status` varchar(40) DEFAULT 'Not verified',
  `units` varchar(120) DEFAULT NULL,
  `field61` varchar(40) DEFAULT NULL,
  UNIQUE KEY `id` (`idmodel`),
  KEY `partner` (`partner`),
  KEY `species` (`endpointspecies`)
) ENGINE=MyISAM AUTO_INCREMENT=1519 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `modelsoftware`
--

DROP TABLE IF EXISTS `modelsoftware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelsoftware` (
  `idmodelsoftware` int(11) NOT NULL AUTO_INCREMENT,
  `idmodel` int(11) DEFAULT NULL,
  `idsoftware` int(11) DEFAULT NULL,
  `idsoftwaretype` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmodelsoftware`),
  KEY `modelsoftware1` (`idmodel`),
  KEY `modelsoftware2` (`idsoftware`),
  KEY `modelsoftware3` (`idsoftwaretype`)
) ENGINE=MyISAM AUTO_INCREMENT=622 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `partner`
--

DROP TABLE IF EXISTS `partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partner` (
  `partner` varchar(10) NOT NULL,
  PRIMARY KEY (`partner`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `idsoftware` int(11) NOT NULL AUTO_INCREMENT,
  `softwaredescription` varchar(255) DEFAULT NULL,
  `softwareversion` varchar(255) DEFAULT NULL,
  `softwarevendor` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `license` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idsoftware`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `softwaretype`
--

DROP TABLE IF EXISTS `softwaretype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `softwaretype` (
  `idsoftwaretype` int(11) NOT NULL AUTO_INCREMENT,
  `softwaretypedescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idsoftwaretype`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `species` (
  `endpointspecies` varchar(255) NOT NULL,
  PRIMARY KEY (`endpointspecies`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-24  8:42:11
