CREATE DATABASE  IF NOT EXISTS `car_rental_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `car_rental_system`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: car_rental_system
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `type` enum('root','supervisor','client') NOT NULL,
  `dateCreate` timestamp NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('root','123456789root','root','2020-01-05 11:58:04');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_client_detail`
--

DROP TABLE IF EXISTS `account_client_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_client_detail` (
  `username` varchar(30) NOT NULL,
  `licenseValidity` enum('Valid','Invalid') DEFAULT NULL,
  `discountPoint` int(11) DEFAULT NULL,
  `totalBills` double DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `usernameClient` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_client_detail`
--

LOCK TABLES `account_client_detail` WRITE;
/*!40000 ALTER TABLE `account_client_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_client_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_detail`
--

DROP TABLE IF EXISTS `account_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_detail` (
  `username` varchar(30) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `gender` enum('Male','Female') DEFAULT NULL,
  `age` varchar(26) DEFAULT NULL,
  `telephone` int(15) DEFAULT NULL,
  `email` varchar(62) DEFAULT NULL,
  `address` varchar(120) DEFAULT NULL,
  `status` enum('Online','Offline') DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_detail`
--

LOCK TABLES `account_detail` WRITE;
/*!40000 ALTER TABLE `account_detail` DISABLE KEYS */;
INSERT INTO `account_detail` VALUES ('root',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Offline');
/*!40000 ALTER TABLE `account_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_supervisor_detail`
--

DROP TABLE IF EXISTS `account_supervisor_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_supervisor_detail` (
  `username` varchar(30) NOT NULL,
  `section` varchar(45) DEFAULT NULL,
  `rank` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `usernameSupervisor` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_supervisor_detail`
--

LOCK TABLES `account_supervisor_detail` WRITE;
/*!40000 ALTER TABLE `account_supervisor_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_supervisor_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrative_message`
--

DROP TABLE IF EXISTS `administrative_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrative_message` (
  `idAdministrative_message` int(11) NOT NULL AUTO_INCREMENT,
  `dateCreate` timestamp NULL DEFAULT NULL,
  `massage` varchar(1000) DEFAULT NULL,
  `sender` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idAdministrative_message`),
  KEY `administrative_sender_FKy_idx` (`sender`),
  CONSTRAINT `administrative_sender_FKy` FOREIGN KEY (`sender`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrative_message`
--

LOCK TABLES `administrative_message` WRITE;
/*!40000 ALTER TABLE `administrative_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrative_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `idCar` varchar(30) NOT NULL,
  `dateCreate` timestamp NULL DEFAULT NULL,
  `type` enum('Sedan','Van','Compact') DEFAULT NULL,
  `maker` varchar(25) DEFAULT NULL,
  `model` varchar(40) DEFAULT NULL,
  `modelYear` int(5) DEFAULT NULL,
  `numberOfSeats` int(3) DEFAULT NULL,
  `registrationNumber` varchar(15) DEFAULT NULL,
  `identificationNumber` varchar(25) DEFAULT NULL,
  `lastMeterReading` double DEFAULT NULL,
  `costPerDay` double DEFAULT NULL,
  `status` enum('Available','Unavailable') DEFAULT NULL,
  PRIMARY KEY (`idCar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('1','2020-01-06 10:18:40','Compact','Opel','Victra',1991,1991,'56-546214','ds65f4sdf5655f4',3452726,10,'Unavailable'),('2','2020-01-06 10:19:54','Compact','kia','avante',2000,2000,'23-456123','f5ds56f465d4',36987453,13,'Unavailable');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_sedan`
--

DROP TABLE IF EXISTS `car_sedan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_sedan` (
  `idCar` varchar(30) NOT NULL,
  `costPerKm` double DEFAULT NULL,
  PRIMARY KEY (`idCar`),
  CONSTRAINT `idCarSedan` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_sedan`
--

LOCK TABLES `car_sedan` WRITE;
/*!40000 ALTER TABLE `car_sedan` DISABLE KEYS */;
INSERT INTO `car_sedan` VALUES ('1',0.3);
/*!40000 ALTER TABLE `car_sedan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_van`
--

DROP TABLE IF EXISTS `car_van`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_van` (
  `idCar` varchar(30) NOT NULL,
  `costPerKm` double DEFAULT NULL,
  `insurancePerDay` double DEFAULT NULL,
  PRIMARY KEY (`idCar`),
  CONSTRAINT `idVanCar` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_van`
--

LOCK TABLES `car_van` WRITE;
/*!40000 ALTER TABLE `car_van` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_van` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massage`
--

DROP TABLE IF EXISTS `massage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `massage` (
  `idMassage` int(11) NOT NULL AUTO_INCREMENT,
  `dateCreate` timestamp NULL DEFAULT NULL,
  `massage` varchar(1000) DEFAULT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idMassage`),
  KEY `receiver_FKy_idx` (`receiver`),
  KEY `sender_FKy_idx` (`sender`),
  CONSTRAINT `receiver_FKy` FOREIGN KEY (`receiver`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sender_FKy` FOREIGN KEY (`sender`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massage`
--

LOCK TABLES `massage` WRITE;
/*!40000 ALTER TABLE `massage` DISABLE KEYS */;
/*!40000 ALTER TABLE `massage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `username` varchar(30) DEFAULT NULL,
  `idCar` varchar(30) DEFAULT NULL,
  `idOrder` int(30) NOT NULL AUTO_INCREMENT,
  `dateCreate` timestamp NULL DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `tripDistance` double DEFAULT NULL,
  `paymentMethods` enum('Check','Credit Card','Bank Transfer','Cash') DEFAULT NULL,
  `bill` double DEFAULT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `idCarOrderIndex` (`idCar`),
  KEY `usernameIndex` (`username`),
  CONSTRAINT `idCar_FKy` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username_FKy` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'car_rental_system'
--

--
-- Dumping routines for database 'car_rental_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-24 17:55:14
