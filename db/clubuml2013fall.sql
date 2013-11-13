CREATE DATABASE  IF NOT EXISTS `clubuml` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clubuml`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: clubuml
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `reportId` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `writenTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `Relationship7` (`userId`),
  KEY `Relationship8` (`reportId`),
  CONSTRAINT `Relationship7` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Relationship8` FOREIGN KEY (`reportId`) REFERENCES `report` (`reportId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagram`
--

DROP TABLE IF EXISTS `diagram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagram` (
  `diagramId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `diagramType` varchar(255) DEFAULT NULL,
  `diagramName` varchar(255) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `fileType` varchar(255) DEFAULT NULL,
  `merged` tinyint(4) DEFAULT NULL,
  `notationFileName` varchar(255) DEFAULT NULL,
  `notationFilePath` varchar(255) DEFAULT NULL,
  `diFlieName` varchar(255) DEFAULT NULL,
  `diFilepath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`diagramId`),
  KEY `diagramHaveOwnerId` (`userId`),
  KEY `diagramHaveProjectType` (`projectId`),
  CONSTRAINT `diagramHaveOwnerId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `diagramHaveProjectType` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(45) NOT NULL,
  `starDate` varchar(45) DEFAULT NULL,
  `desceiption` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `reportId` int(11) NOT NULL AUTO_INCREMENT,
  `diagramA` int(11) NOT NULL,
  `diagramB` int(11) NOT NULL,
  `mergedDiagram` int(11) DEFAULT NULL,
  `type` varchar(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reportFilePath` varchar(45) NOT NULL,
  `reportFileName` varchar(45) NOT NULL,
  PRIMARY KEY (`reportId`),
  KEY `Relationship4` (`diagramA`),
  KEY `Relationship5` (`diagramB`),
  KEY `Relationship6` (`mergedDiagram`),
  CONSTRAINT `Relationship4` FOREIGN KEY (`diagramA`) REFERENCES `diagram` (`diagramId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Relationship5` FOREIGN KEY (`diagramB`) REFERENCES `diagram` (`diagramId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Relationship6` FOREIGN KEY (`mergedDiagram`) REFERENCES `diagram` (`diagramId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `securityQ` varchar(60) DEFAULT NULL,
  `securityA` varchar(60) DEFAULT NULL,
  `userType` char(2) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-09 14:51:57

//Adding initializing data 
insert into project value (1,'clubuml1',now(),'des1');

insert into project value (2,'clubuml2',now(),'des2');

