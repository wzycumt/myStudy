-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: myStudy
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `NAME` varchar(120) NOT NULL COMMENT '留言人',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '留言内容',
  `AVATAR` varchar(120) NOT NULL COMMENT '头像',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0-无效 1-有效 2-删除',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '最后一次修改时间',
  `VERSION` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'admin','第一条留言','boy-5.png',1,'2017-02-24 22:07:06','2017-02-24 22:07:06',0),(3,'admin','第二条留言','boy-5.png',1,'2017-02-25 14:13:38','2017-02-25 14:13:38',0),(4,'bootstrap','Bootstrap （当前版本 v3.3.7）提供以下几种方式帮你快速上手，每一种方式针对具有不同技能等级的开发者和不同的使用场景。继续阅读下面的内容，看看哪种方式适合你的需求吧。','boy-5.png',1,'2017-02-25 18:06:50','2017-02-25 18:06:50',0),(5,'匿名','Bootstrap （当前版本 v3.3.7）提供以下几种方式帮你快速上手，每一种方式针对具有不同技能等级的开发者和不同的使用场景。继续阅读下面的内容，看看哪种方式适合你的需求吧。','boy-5.png',1,'2017-02-25 18:08:51','2017-02-25 18:08:51',0),(6,'匿名','验证码测试','boy-5.png',1,'2017-02-25 18:23:52','2017-02-25 18:23:52',0),(7,'留言人','留言板测试','boy-5.png',1,'2017-02-25 18:40:29','2017-02-25 18:40:29',0),(8,'admin','spring MVC参数绑定','boy-5.png',1,'2017-02-25 19:25:28','2017-02-25 19:25:28',0),(9,'站长','spring MVC 参数传递方式','boy-5.png',1,'2017-02-25 19:28:44','2017-02-25 19:28:44',0),(10,'留言','留言板测试','boy-5.png',1,'2017-02-25 19:32:20','2017-02-25 19:32:20',0),(11,'头像','选择头像测试','girl-6.png',1,'2017-02-26 16:59:32','2017-02-26 16:59:32',0),(12,'头像','选择头像测试','boy-4.png',1,'2017-02-26 17:01:48','2017-02-26 17:01:48',0),(13,'匿名','枚举类型测试','boy-0.png',1,'2017-03-01 16:06:12','2017-03-01 16:06:12',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_NAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `NICKNAME` varchar(50) DEFAULT NULL COMMENT '昵称',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `PHONE` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态 0-无效 1-有效',
  `REMARK` varchar(2000) DEFAULT NULL COMMENT '备注',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','管理员','温照宇','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-02 10:09:55',0,'2017-03-02 10:09:55',0);
INSERT INTO `t_user` VALUES (2,'guest','guest','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,NOW(),0,NOW(),0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-03 17:55:21
