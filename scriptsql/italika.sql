-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: italika-financing
-- ------------------------------------------------------
-- Server version	5.7.43-log

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
-- Table structure for table `italika_client`
--

DROP TABLE IF EXISTS `italika_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_client` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phone_number` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_client`
--

LOCK TABLES `italika_client` WRITE;
/*!40000 ALTER TABLE `italika_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `italika_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_code`
--

DROP TABLE IF EXISTS `italika_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_code` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_code`
--

LOCK TABLES `italika_code` WRITE;
/*!40000 ALTER TABLE `italika_code` DISABLE KEYS */;
INSERT INTO `italika_code` VALUES (1,'COLOR'),(2,'MODELO');
/*!40000 ALTER TABLE `italika_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_code_value`
--

DROP TABLE IF EXISTS `italika_code_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_code_value` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) NOT NULL,
  `code_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_italika_code_value_code_id_idx` (`code_id`),
  CONSTRAINT `fk_italika_code_value_code_id` FOREIGN KEY (`code_id`) REFERENCES `italika_code` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_code_value`
--

LOCK TABLES `italika_code_value` WRITE;
/*!40000 ALTER TABLE `italika_code_value` DISABLE KEYS */;
INSERT INTO `italika_code_value` VALUES (1,'Rojo',1),(2,'Vort-x',2);
/*!40000 ALTER TABLE `italika_code_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_financial_plan`
--

DROP TABLE IF EXISTS `italika_financial_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_financial_plan` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `percentage` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_financial_plan`
--

LOCK TABLES `italika_financial_plan` WRITE;
/*!40000 ALTER TABLE `italika_financial_plan` DISABLE KEYS */;
INSERT INTO `italika_financial_plan` VALUES (1,'ITALIKA_PLUS',0.125);
/*!40000 ALTER TABLE `italika_financial_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_motorcicle`
--

DROP TABLE IF EXISTS `italika_motorcicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_motorcicle` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `serial_number_motor` varchar(45) NOT NULL,
  `model_code_value_id` bigint(11) NOT NULL,
  `color_code_value_id` bigint(11) DEFAULT NULL,
  `price_producto` decimal(19,6) NOT NULL,
  `administration_outlay` decimal(19,6) NOT NULL,
  `accesories_cost` decimal(19,6) NOT NULL,
  `insurance_cost` decimal(19,6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `serial_number_motor_UNIQUE` (`serial_number_motor`),
  KEY `fk_italika_motorcicle_color_code_value_idx` (`color_code_value_id`),
  KEY `fk_italika_motorcicle_modelo_code_value_idx` (`model_code_value_id`),
  CONSTRAINT `fk_italika_motorcicle_color_code_value` FOREIGN KEY (`color_code_value_id`) REFERENCES `italika_code_value` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_italika_motorcicle_modelo_code_value` FOREIGN KEY (`model_code_value_id`) REFERENCES `italika_code_value` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_motorcicle`
--

LOCK TABLES `italika_motorcicle` WRITE;
/*!40000 ALTER TABLE `italika_motorcicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `italika_motorcicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_quote`
--

DROP TABLE IF EXISTS `italika_quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_quote` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number_quote` varchar(45) NOT NULL,
  `initial_repayment` varchar(45) DEFAULT NULL,
  `quote_date` varchar(45) DEFAULT NULL,
  `has_credit` varchar(45) DEFAULT NULL,
  `motorcicle_id` bigint(11) NOT NULL,
  `client_id` bigint(11) NOT NULL,
  `financial_plan_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `number_quote_UNIQUE` (`number_quote`),
  KEY `fk_italika_quote_client_id_idx` (`client_id`),
  KEY `fk_italika_quote_motorcicle_id_idx` (`motorcicle_id`),
  KEY `fk_italika_quote_financial_id_idx` (`financial_plan_id`),
  CONSTRAINT `fk_italika_quote_client_id` FOREIGN KEY (`client_id`) REFERENCES `italika_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_italika_quote_financial_id` FOREIGN KEY (`financial_plan_id`) REFERENCES `italika_financial_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_italika_quote_motorcicle_id` FOREIGN KEY (`motorcicle_id`) REFERENCES `italika_motorcicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_quote`
--

LOCK TABLES `italika_quote` WRITE;
/*!40000 ALTER TABLE `italika_quote` DISABLE KEYS */;
/*!40000 ALTER TABLE `italika_quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `italika_schedule_quote`
--

DROP TABLE IF EXISTS `italika_schedule_quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `italika_schedule_quote` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(45) NOT NULL,
  `interest` varchar(45) NOT NULL,
  `interes_iva` varchar(45) NOT NULL,
  `repayment` varchar(45) NOT NULL,
  `remaining_balance` varchar(45) NOT NULL,
  `quote_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_italika_schedule_quote_quote_id_idx` (`quote_id`),
  CONSTRAINT `fk_italika_schedule_quote_quote_id` FOREIGN KEY (`quote_id`) REFERENCES `italika_quote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `italika_schedule_quote`
--

LOCK TABLES `italika_schedule_quote` WRITE;
/*!40000 ALTER TABLE `italika_schedule_quote` DISABLE KEYS */;
/*!40000 ALTER TABLE `italika_schedule_quote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12 18:15:06
