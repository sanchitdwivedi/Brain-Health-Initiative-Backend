-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: healthcaredb
-- ------------------------------------------------------
-- Server version	8.0.27
use healthcaredb;
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
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin@gmail.com','Akshay','MALE','Kumar',9822344567,560100,1),(2,'sanjay.dutt@gmail.com','Sanjay','MALE','Dutt',8763838994,422006,2);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `consultation_form`
--

LOCK TABLES `consultation_form` WRITE;
/*!40000 ALTER TABLE `consultation_form` DISABLE KEYS */;
INSERT INTO `consultation_form` VALUES (1,'Yes','2022-05-09 05:30:00.000000',0,'Blood Test','2022-06-23 05:30:00.000000','I63','I63 ICD','None',0,'[{\"medicineName\":\"Dolo\",\"dosage\":\"1-0-1\",\"remarks\":\"Take Regularily\",\"duration\":\"30\"}]','[{\"uuid\":2,\"options\":[1,3]},{\"uuid\":3,\"options\":[16,17]},{\"uuid\":4,\"options\":[22]},{\"uuid\":6,\"options\":[]},{\"uuid\":9,\"options\":[22]},{\"uuid\":11,\"options\":[]}]','BP:110/80','Regular Followup',2,3,1,NULL),(2,'Yes','2022-05-09 05:30:00.000000',0,'Blood Test',NULL,'R51','I63 ICD','None',1,'[{\"medicineName\":\"Dolo\",\"dosage\":\"1-0-1\",\"remarks\":\"Take Regularily\",\"duration\":\"10\"}]','[{\"uuid\":2,\"options\":[2,3]},{\"uuid\":3,\"options\":[17]},{\"uuid\":4,\"options\":[23]},{\"uuid\":7,\"options\":[]}]','BP:Normal','Regular Followup',2,3,1,1),(3,'Yes','2022-05-09 05:30:00.000000',1,'Blood Test','2022-06-10 05:30:00.000000','I63','I63 ICD','None',1,'[{\"medicineName\":\"Dolo\",\"dosage\":\"1-0-1\",\"remarks\":\"Take Regularily\",\"duration\":\"30\"}]','[]','Rest please','Regular Followup',2,3,1,NULL),(4,'Yes','2022-05-09 05:30:00.000000',2,'Blood Test','2022-07-20 05:30:00.000000','R51','I63 ICD','None',1,'[{\"medicineName\":\"Dolo\",\"dosage\":\"1-0-2\",\"remarks\":\"Take Regularily\",\"duration\":\"10\"}]','[{\"uuid\":2,\"options\":[5,6]},{\"uuid\":22,\"options\":[5,36,37]},{\"uuid\":23,\"options\":[60,61,63]},{\"uuid\":24,\"options\":[]}]','','Regular Followup',1,2,2,NULL),(5,'Yes','2022-05-09 05:30:00.000000',0,'Blood Test',NULL,'I63','I63 ICD','None',1,'[{\"medicineName\":\"Dolo\",\"dosage\":\"1-0-1\",\"remarks\":\"Take Regularily\",\"duration\":\"30\"}]','[{\"uuid\":2,\"options\":[1,2]},{\"uuid\":3,\"options\":[16,17]},{\"uuid\":4,\"options\":[22]},{\"uuid\":6,\"options\":[]},{\"uuid\":9,\"options\":[22]},{\"uuid\":11,\"options\":[]}]','BP :Normal','Regular Followup',2,3,3,1);
/*!40000 ALTER TABLE `consultation_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Mumbai','Mumbai','salman.khan@gmail.com','Salman','MALE','Khan',9835437883,560100,'Maharashtra',3,2),(2,'Bangalore','Bangalore','shreya.chauhan@gmail.com','Shreya','FEMALE','Chauhan',8747834344,560100,'Karnataka',4,3),(3,'Delhi','Delhi','menka.yadav@iiitb.ac.in','Menka ','FEMALE','Yadav',9175120581,422101,'Delhi',5,2);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,1,'Bangalore','Bangalore','Cauvery Hospital',560100,'Karnataka',1),(2,1,'Delhi','Delhi','AIIMS Delhi',422102,'Delhi',2),(3,1,'Bangalore','Bangalore','NIIMS',560100,'Karnataka',3);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1,'Primary Healthcare Center','phc'),(2,'Secondary Healthcare Center','shc'),(3,'Tertiary Healthcare Center','thc');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `national_health_record`
--

LOCK TABLES `national_health_record` WRITE;
/*!40000 ALTER TABLE `national_health_record` DISABLE KEYS */;
INSERT INTO `national_health_record` VALUES (1,'987654321012','Hosur Road','Electronic City','Bangalore','1996-02-14','M.Tech','Sachin',0,'Patil',9175120581,422101,0,'Karnataka'),(2,'987654321013','Hosur Road','Electronic City','Bangalore','1996-02-14','M.Tech','Amit',0,'Dwivedi',9175120581,422101,0,'Karnataka'),(3,'987654321014','Hosur Road','Electronic City','Bangalore','1996-02-14','M.Tech','Aman',0,'Chauhan',9175120581,422101,0,'Karnataka'),(4,'987654321015','Hosur Road','Electronic City','Bangalore','1996-02-14','M.Tech','Neha',1,'Sharma',9175120581,422101,0,'Karnataka');
/*!40000 ALTER TABLE `national_health_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'987654321012','Hosur Road','Electronic City','Bangalore','1996-02-14 05:30:00.000000','M.Tech','Sachin','MALE','Khushal Abrol','Patil',9175120581,422101,'Father','BELOW_POVERTY_LINE','Karnataka'),(2,'987654321013','Hosur Road','Electronic City','Bangalore','1996-02-14 05:30:00.000000','M.Tech','Amit','MALE','Amit','Dwivedi',9175120581,422101,'Father','BELOW_POVERTY_LINE','Karnataka'),(3,'987654321015','Hosur Road','Electronic City','Bangalore','1996-02-14 05:30:00.000000','M.Tech','Neha','FEMALE','Amit','Sharma',9175120581,422101,'Father','BELOW_POVERTY_LINE','Karnataka');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questionnaire_data`
--

LOCK TABLES `questionnaire_data` WRITE;
/*!40000 ALTER TABLE `questionnaire_data` DISABLE KEYS */;
INSERT INTO `questionnaire_data` VALUES (1,0,0,'Not Found','[]',0),(2,1,1,'Have you or any other member of your family suffered from any of the following?','[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]',0),(3,1,1,'Select symptoms associated with the patient :','[16,17,18,19,20,21]',1),(4,0,1,'Unprovoked stereotyped motor or sensory events, involving only one part of the body, with or without impaired awareness of surroundings','[22, 23]',0),(5,0,1,'Generalised seizure','[]',0),(6,0,1,'Probable focal seizure','[]',0),(7,0,0,'Uncertain for seizure','[]',0),(8,0,1,'If the patient is below 10 years old','[22, 23]',0),(9,0,1,'A diagnosis of epilepsy is made when a patient has more than 1 unprovoked seizure 24 hours apart','[22, 23]',0),(10,0,1,'fever?','[22, 23]',0),(11,0,0,'Epilepsy diagonosis','[]',0),(12,0,0,'Uncertain for Epilepsy','[]',0),(13,1,1,'Is patient suffering from:','[24,25,26,27,28,29]',1),(14,0,0,'Atypical febrile siezure','[]',0),(15,0,1,'Is age <5 Years','[22, 23]',0),(16,0,0,'Typical febrile siezure','[]',0),(17,1,1,'Is patient suffering from:','[30,31,28,34]',1),(18,0,0,'Typical absence seizures','[]',0),(19,1,1,'Is patient suffering from:','[32,33]',1),(20,0,0,'Generalised seizure','[]',0),(21,0,0,'Probable absence seizures','[]',0),(22,1,1,'Select applicable options','[4,5,36,37,38]',0),(23,1,1,'Check for the signs:','[58,59,60,61,62,63,64,65,66]',0),(24,0,0,'Stroke - Refer to secondary healthcare center','[]',0);
/*!40000 ALTER TABLE `questionnaire_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questionnaire_flow_with_count`
--

LOCK TABLES `questionnaire_flow_with_count` WRITE;
/*!40000 ALTER TABLE `questionnaire_flow_with_count` DISABLE KEYS */;
INSERT INTO `questionnaire_flow_with_count` VALUES (1,'[16,17,18,19,20,21]',1,4,3),(2,'[16,17,18,19,20,21]',2,4,3),(3,'[16,17,18,19,20,21]',3,4,3),(4,'[16,17,18,19,20,21]',4,5,3),(5,'[16,17,18,19,20,21]',5,5,3),(6,'[16,17,18,19,20,21]',6,5,3),(7,'[24,25,26,27,28,29]',0,14,13),(8,'[24,25,26,27,28,29]',-1,15,13),(9,'[30,31,34,35]',0,19,17),(10,'[30,31,34,35]',-1,18,17),(11,'[32,33]',0,20,19),(12,'[32,33]',-1,21,19),(13,'[16,17,18,19,20,21]',0,4,3);
/*!40000 ALTER TABLE `questionnaire_flow_with_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questionnaire_flow_without_count`
--

LOCK TABLES `questionnaire_flow_without_count` WRITE;
/*!40000 ALTER TABLE `questionnaire_flow_without_count` DISABLE KEYS */;
INSERT INTO `questionnaire_flow_without_count` VALUES (1,'[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]','[1,2,3]',1,3,2),(2,'[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]','[4,5,6,7,8]',1,22,2),(7,'[22, 23]','[22]',0,6,4),(8,'[22, 23]','[23]',0,7,4),(9,'[]','[]',0,8,5),(10,'[]','[]',0,9,6),(11,'[22, 23]','[22]',0,10,8),(12,'[22, 23]','[23]',0,9,8),(13,'[22, 23]','[22]',0,11,9),(14,'[22, 23]','[23]',0,12,9),(15,'[22,23]','[22]',0,13,10),(16,'[22, 23]','[23]',0,17,10),(17,'[22,23]','[22]',0,16,15),(18,'[22,23]','[23]',0,14,15),(20,'[4,5,36,37,38]','[4,5,36,37,38]',1,23,22),(21,'[58,59,60,61,62,63,64,65,66]','[58,59,60,61,62,63,64,65,66]',1,24,23);
/*!40000 ALTER TABLE `questionnaire_flow_without_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questionnaire_options`
--

LOCK TABLES `questionnaire_options` WRITE;
/*!40000 ALTER TABLE `questionnaire_options` DISABLE KEYS */;
INSERT INTO `questionnaire_options` VALUES (4,'Abnormal speech'),(38,'Any loss of sensation or any abnormal sensation in the face, arms'),(8,'Any loss of sensation or any abnormal sensation in the face, arms and legs'),(13,'Any recent change in behavior or personality'),(31,'Blinking/staring'),(30,'Brief events (<few secs)'),(9,'Deterioration of memory within the last five years (applicable to subjects above 30 years of age)'),(17,'Did he/she ever injure himself/herself or have tongue bite during an episode'),(19,'Did he/she have such an episode while asleep'),(16,'Did he/She pass urine or stool in his/her clothes during an episode'),(61,'Difficulty in speaking or understanding'),(37,'Difficulty in walking (exclude individuals with pain or swelling of'),(7,'Difficulty in walking (exclude individuals with pain or swelling of joints of lower limbs)'),(63,'Dizziness'),(65,'Double vision'),(10,'Drooping of eyelids(a) temporary, for a few hours, or (b) permanent'),(11,'Episodes of severe facial pain'),(5,'Facial paralysis with sideways deviation of the mouth'),(24,'Generalized convulsive'),(21,'Has an episode ever occured WITHOUT preceding mental/emotional stress'),(12,'Headache; if yes, a. Unilateral b. Associated with flashes of light or circles c. Associated with vomiting'),(59,'Impaired consciousness'),(26,'Lasts <5 minutes'),(62,'Loss of balance or incoordination while walking'),(1,'Loss of consciousness'),(32,'Multiple per day'),(23,'No'),(28,'No developmental delay/regression'),(27,'No post ictal weakness'),(34,'Onset after 3 years'),(33,'Precipitated at bedside by hyperventilation'),(29,'Regains consciouness completely within 5 min'),(25,'Single episode'),(14,'Slowness of movement'),(60,'Slurred speech'),(2,'Sudden episode of loss of contact with the surroundings'),(64,'Swallowing problems'),(15,'Tremor'),(3,'Uncontrollable shaking of head, arms or legs'),(66,'Vision impairment'),(20,'Was the patient completely unconcious during the episode'),(18,'Was there frothing from ,outh during an episode'),(58,'Weakness or loss of sensation on one side of body with deviation of face to one side'),(36,'Weakness or paralysis of arms and/or legs'),(6,'Weakness or Paralysis of arms or legs'),(22,'Yes');
/*!40000 ALTER TABLE `questionnaire_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Secondary Specialist Doctor','secondary specialist'),(2,'Tertiary Specialist','tertiary specialist'),(3,'Medical Officer','medical officer'),(4,'Admin','admin'),(5,'Program Manager','program manager');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'$2a$12$/HTzSuWlWkZLzaKw9wSfzurAqFC3RRNZqIghhAoFP23x6jEhooXFu',1,123456789101,4),(2,1,'$2a$12$dACilrCsGN5d3qvd7nklq.L49KjM1vUpIRfuA6C2BjMCGLUdIcY3y',1,123456789102,5),(3,1,'$2a$12$ix7EbkzGG27rLN.lnHqBked/VlYaF97hVIK3gFwdmQT8kCF66KI4W',1,123456789100,1),(4,1,'$2a$12$L7HD6wJzUu69j0AEMB0W/.tC.a/uM4gbiNyVddRS6PTU2t7H9E8MK',1,123456789105,3),(5,1,'$2a$12$/wla.jkpIOwAxWW5d6oyfumV2DbmwNtWpgjkxp4jKfpiMCSdbs7kK',1,123456789106,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-11 18:01:29
