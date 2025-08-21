-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: p19_socialissuedb
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `area_id` int NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) NOT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Pune','411001'),(2,'Mumbai','400001'),(3,'Solapur','411004'),(5,'Bmt','411001');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizen`
--

DROP TABLE IF EXISTS `citizen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizen` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `area_id` int DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `aadhar_no` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `uid` (`uid`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `citizen_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `citizen_ibfk_2` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizen`
--

LOCK TABLES `citizen` WRITE;
/*!40000 ALTER TABLE `citizen` DISABLE KEYS */;
INSERT INTO `citizen` VALUES (1,2,'John','Doe','123 MG Road, Pune',1,'Male','1998-05-15','123456789012'),(5,3,'Priya','Shah','Bandra, Mumbai',2,'Female','1997-09-10',NULL),(6,8,NULL,NULL,NULL,2,NULL,NULL,NULL),(7,9,NULL,NULL,NULL,3,NULL,NULL,NULL),(8,12,NULL,NULL,NULL,3,NULL,NULL,NULL),(9,13,NULL,NULL,NULL,1,NULL,NULL,NULL),(10,14,NULL,NULL,NULL,2,NULL,NULL,NULL),(11,15,NULL,NULL,NULL,2,NULL,NULL,NULL),(12,16,NULL,NULL,NULL,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `citizen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizen_complaint`
--

DROP TABLE IF EXISTS `citizen_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizen_complaint` (
  `complaint_id` int NOT NULL AUTO_INCREMENT,
  `cid` int DEFAULT NULL,
  `issue_id` int DEFAULT NULL,
  `area_id` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `submitted_at` datetime DEFAULT NULL,
  `action_status` int DEFAULT '0',
  PRIMARY KEY (`complaint_id`),
  KEY `cid` (`cid`),
  KEY `issue_id` (`issue_id`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `citizen_complaint_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `citizen` (`cid`),
  CONSTRAINT `citizen_complaint_ibfk_2` FOREIGN KEY (`issue_id`) REFERENCES `issue_category` (`issue_id`),
  CONSTRAINT `citizen_complaint_ibfk_3` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizen_complaint`
--

LOCK TABLES `citizen_complaint` WRITE;
/*!40000 ALTER TABLE `citizen_complaint` DISABLE KEYS */;
INSERT INTO `citizen_complaint` VALUES (1,1,1,1,'Garbage not collected for the past 3 days in the locality.','2025-07-26 09:49:40',0),(2,1,2,1,'XXXXXXXXXXXXXXXXXXXXXXXX','2025-08-01 07:08:33',2),(3,1,2,1,'XXXXXXXXXXXXXXXXXXXXXXXX','2025-08-04 04:50:27',0),(4,1,2,1,'abcd','2025-08-04 12:16:30',0),(5,1,2,1,'hello world','2025-08-04 12:21:41',0),(6,6,2,2,'water problem','2025-08-04 12:32:38',2),(7,6,3,2,'Ligths are poor','2025-08-04 14:11:55',1),(8,6,3,2,'jjjjjj','2025-08-04 15:02:38',3),(9,6,1,2,'tfg','2025-08-04 15:05:00',0),(10,7,2,3,'water leakage in my area','2025-08-05 06:34:55',0),(11,7,1,3,'garbage not collected in my area','2025-08-05 07:18:18',0),(14,6,3,2,'jksacjhas','2025-08-06 12:19:25',0),(15,6,3,2,'not light','2025-08-08 05:42:11',0),(16,6,3,2,'not light','2025-08-08 05:42:24',1),(17,12,3,2,'polluted air in area','2025-08-09 09:54:39',2),(18,12,8,2,'road not good','2025-08-09 12:17:42',3);
/*!40000 ALTER TABLE `citizen_complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizencomplaint`
--

DROP TABLE IF EXISTS `citizencomplaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizencomplaint` (
  `complaintId` int NOT NULL AUTO_INCREMENT,
  `actionStatus` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `submittedAt` datetime(6) DEFAULT NULL,
  `area_id` int DEFAULT NULL,
  `citizen_id` int DEFAULT NULL,
  `issue_category_id` int DEFAULT NULL,
  PRIMARY KEY (`complaintId`),
  KEY `FKowp9t5k4errxcrbmdhjcdp6it` (`area_id`),
  KEY `FK7h27o81re4f4l49vr8590nn5h` (`citizen_id`),
  KEY `FKp7vaw0dtnxor2diltpljk36fq` (`issue_category_id`),
  CONSTRAINT `FK7h27o81re4f4l49vr8590nn5h` FOREIGN KEY (`citizen_id`) REFERENCES `citizen` (`cid`),
  CONSTRAINT `FKowp9t5k4errxcrbmdhjcdp6it` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`),
  CONSTRAINT `FKp7vaw0dtnxor2diltpljk36fq` FOREIGN KEY (`issue_category_id`) REFERENCES `issue_category` (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizencomplaint`
--

LOCK TABLES `citizencomplaint` WRITE;
/*!40000 ALTER TABLE `citizencomplaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `citizencomplaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint_status`
--

DROP TABLE IF EXISTS `complaint_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint_status` (
  `complaint_id` int NOT NULL,
  `status` enum('SUBMITTED','IN_PROGRESS','RESOLVED','REJECTED') DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `handled_by` int DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`),
  KEY `handled_by` (`handled_by`),
  CONSTRAINT `complaint_status_ibfk_1` FOREIGN KEY (`complaint_id`) REFERENCES `citizen_complaint` (`complaint_id`),
  CONSTRAINT `complaint_status_ibfk_2` FOREIGN KEY (`handled_by`) REFERENCES `zone_operator` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint_status`
--

LOCK TABLES `complaint_status` WRITE;
/*!40000 ALTER TABLE `complaint_status` DISABLE KEYS */;
INSERT INTO `complaint_status` VALUES (1,'IN_PROGRESS','2025-08-06 10:16:42',1,'Investigation started'),(2,'IN_PROGRESS','2025-08-06 11:28:29',1,'Investigation started');
/*!40000 ALTER TABLE `complaint_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_category`
--

DROP TABLE IF EXISTS `issue_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue_category` (
  `issue_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_category`
--

LOCK TABLES `issue_category` WRITE;
/*!40000 ALTER TABLE `issue_category` DISABLE KEYS */;
INSERT INTO `issue_category` VALUES (1,'Garbage Collection Issue'),(2,'Water Supply Leakage'),(3,'Light Issue'),(7,'Air Pollution'),(8,'potholes');
/*!40000 ALTER TABLE `issue_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Citizen'),(2,'Zone Operator'),(3,'Adminr');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rid` int DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` enum('Active','Inactive') DEFAULT 'Active',
  PRIMARY KEY (`uid`),
  KEY `rid` (`rid`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'JohnDoe','john123',1,'9123456780','john@example.com','Active'),(3,'OperatorUser','operator123',3,'9988776655','operator@example.com','Active'),(5,'john123','johnpass',2,'9876543210','john@example.com','Active'),(6,'deep','deep123',1,'1357924680','deep@gmail.com','Active'),(7,'ram','ram123',1,'9876543210','ram@gmail.com','Active'),(8,'kshitij_more','Kshitij123',1,'8326278181','kshitij@gmail.com','Active'),(9,'harsh_dhole','harsh123',2,'123123132123','harsh@example.com','Active'),(10,'ram123','rampass',1,'9876543210','ram@example.com','Active'),(12,'parag','parag123',1,'121212343456','parag@gmail.com','Active'),(13,'shyam','shyam123',1,'1234567899','shyam@gmail.com','Active'),(14,'rohit','rohit',1,'98787665','rohit@gmail.com','Active'),(15,'rohit','rohit',1,'98787665','rohit@gmail.com','Active'),(16,'sumit','sumit123',1,'1122331122','sumit@gmail.com','Active');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zone_operator`
--

DROP TABLE IF EXISTS `zone_operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zone_operator` (
  `operator_id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `area_id` int DEFAULT NULL,
  `joined_date` date DEFAULT NULL,
  PRIMARY KEY (`operator_id`),
  KEY `uid` (`uid`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `zone_operator_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `zone_operator_ibfk_2` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zone_operator`
--

LOCK TABLES `zone_operator` WRITE;
/*!40000 ALTER TABLE `zone_operator` DISABLE KEYS */;
INSERT INTO `zone_operator` VALUES (1,9,'Senior Operator',1,'2020-01-15'),(2,5,'Senior Operator',2,'2020-01-15');
/*!40000 ALTER TABLE `zone_operator` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-09 18:12:31
