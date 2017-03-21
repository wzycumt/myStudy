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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'admin','第一条留言','boy-5.png',1,'2017-02-24 22:07:06','2017-02-24 22:07:06',0),(3,'admin','第二条留言','boy-5.png',1,'2017-02-25 14:13:38','2017-02-25 14:13:38',0),(4,'bootstrap','Bootstrap （当前版本 v3.3.7）提供以下几种方式帮你快速上手，每一种方式针对具有不同技能等级的开发者和不同的使用场景。继续阅读下面的内容，看看哪种方式适合你的需求吧。','boy-5.png',1,'2017-02-25 18:06:50','2017-02-25 18:06:50',0),(5,'匿名','Bootstrap （当前版本 v3.3.7）提供以下几种方式帮你快速上手，每一种方式针对具有不同技能等级的开发者和不同的使用场景。继续阅读下面的内容，看看哪种方式适合你的需求吧。','boy-5.png',1,'2017-02-25 18:08:51','2017-02-25 18:08:51',0),(6,'匿名','验证码测试','boy-5.png',1,'2017-02-25 18:23:52','2017-02-25 18:23:52',0),(7,'留言人','留言板测试','boy-5.png',1,'2017-02-25 18:40:29','2017-02-25 18:40:29',0),(8,'admin','spring MVC参数绑定','boy-5.png',1,'2017-02-25 19:25:28','2017-02-25 19:25:28',0),(9,'站长','spring MVC 参数传递方式','boy-5.png',1,'2017-02-25 19:28:44','2017-02-25 19:28:44',0),(10,'留言','留言板测试','boy-5.png',1,'2017-02-25 19:32:20','2017-02-25 19:32:20',0),(11,'头像','选择头像测试','girl-6.png',1,'2017-02-26 16:59:32','2017-02-26 16:59:32',0),(12,'头像','选择头像测试','boy-4.png',1,'2017-02-26 17:01:48','2017-02-26 17:01:48',0),(13,'匿名','枚举类型测试','boy-0.png',1,'2017-03-01 16:06:12','2017-03-01 16:06:12',0),(14,'匿名','UI优化','girl-4.png',1,'2017-03-06 17:41:26','2017-03-06 17:41:26',0),(15,'匿名','H+ ui','boy-5.png',1,'2017-03-06 17:45:48','2017-03-06 17:45:48',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `PARENT_ID` int(11) NOT NULL COMMENT '父级ID',
  `URL` varchar(200) DEFAULT NULL COMMENT '路径',
  `ICON` varchar(200) DEFAULT NULL COMMENT '图标',
  `ORDER_NUM` int(11) NOT NULL COMMENT '序号',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态 0-无效 1-有效',
  `REMARK` varchar(2000) DEFAULT NULL COMMENT '备注',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'系统设置',0,'','fa fa-cogs',0,1,'',0,'2017-03-09 18:01:07',0,'2017-03-09 22:40:26',2),(2,'用户管理',1,'user/index','fa fa-user',0,1,'',0,'2017-03-09 22:30:09',0,'2017-03-09 22:42:22',5),(3,'菜单管理',1,'menu/index','fa fa-reorder',1,1,'',0,'2017-03-10 10:39:12',0,'2017-03-10 10:39:12',0),(4,'权限管理',1,'role/index','fa fa-user-secret',2,1,'',0,'2017-03-13 09:13:24',0,'2017-03-13 09:13:24',0),(5,'文件上传',0,'nav/fileUpload','fa fa-upload',1,1,'',0,'2017-03-13 16:18:57',0,'2017-03-14 16:54:48',9),(9,'根节点',0,'','fa fa-home',2,1,'',0,'2017-03-14 17:55:27',0,'2017-03-14 17:55:27',0),(10,'子节点1',9,'','fa fa-reorder',0,1,'',0,'2017-03-14 17:56:06',0,'2017-03-14 17:56:06',0),(11,'子节点2',9,'','fa fa-reorder',1,1,'',0,'2017-03-14 17:56:24',0,'2017-03-14 17:56:24',0),(12,'子节点1-1',10,'','fa fa-reorder',0,1,'',0,'2017-03-14 17:57:31',0,'2017-03-14 17:57:31',0),(13,'子节点1-2',10,'','fa fa-reorder',1,0,'',0,'2017-03-14 17:58:32',0,'2017-03-14 17:58:32',0);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_message`
--

DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '留言人',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '内容',
  `AVATAR` varchar(200) DEFAULT NULL COMMENT '头像',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态 0-无效 1-有效',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_message`
--

LOCK TABLES `t_message` WRITE;
/*!40000 ALTER TABLE `t_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_rel_role_menu`
--

DROP TABLE IF EXISTS `t_rel_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rel_role_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `MENU_ID` int(11) NOT NULL COMMENT '菜单ID',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rel_role_menu`
--

LOCK TABLES `t_rel_role_menu` WRITE;
/*!40000 ALTER TABLE `t_rel_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_rel_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_rel_user_role`
--

DROP TABLE IF EXISTS `t_rel_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rel_user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rel_user_role`
--

LOCK TABLES `t_rel_user_role` WRITE;
/*!40000 ALTER TABLE `t_rel_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_rel_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '角色名',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态 0-无效 1-有效',
  `REMARK` varchar(2000) DEFAULT NULL COMMENT '备注',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员',1,'',0,'2017-03-13 09:18:33',0,'2017-03-13 09:18:38',1),(2,'普通用户',1,'',0,'2017-03-13 09:22:50',0,'2017-03-13 09:22:50',0);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_search_config`
--

DROP TABLE IF EXISTS `t_search_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_search_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CODE` varchar(50) DEFAULT NULL COMMENT '编码',
  `DESCRIPTION` varchar(200) DEFAULT NULL COMMENT '描述',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态 0-无效 1-有效',
  `REMARK` varchar(2000) DEFAULT NULL COMMENT '备注',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_search_config`
--

LOCK TABLES `t_search_config` WRITE;
/*!40000 ALTER TABLE `t_search_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_search_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_search_config_field`
--

DROP TABLE IF EXISTS `t_search_config_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_search_config_field` (
  `ID` int(11) NOT NULL COMMENT '主键',
  `SEARCH_CONFIG_ID` int(11) NOT NULL COMMENT '查询配置ID',
  `DISPLAY_NAME` varchar(50) DEFAULT NULL COMMENT '显示名称',
  `FIELD_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `FIELD_TYPE` tinyint(4) NOT NULL COMMENT '字段类型',
  `FIELD_REFERENCE` varchar(200) DEFAULT NULL COMMENT '字段引用',
  `ID_DEFAULT` tinyint(1) NOT NULL COMMENT '是否默认',
  `ORDER_NUM` int(11) NOT NULL COMMENT '序号',
  `CREATOR` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_PERSON` int(11) NOT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `VERSION` smallint(6) NOT NULL COMMENT '版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询配置字段表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_search_config_field`
--

LOCK TABLES `t_search_config_field` WRITE;
/*!40000 ALTER TABLE `t_search_config_field` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_search_config_field` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','管理员','温照宇','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-02 10:09:55',0,'2017-03-02 10:09:55',0),(3,'guest','guest','访客','访客','18911223344','hdmwzy@sina.com',0,'remark',0,'2017-03-07 18:08:21',0,'2017-03-16 17:01:49',3),(4,'user1','user1','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(5,'user2','user2','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(6,'user3','user3','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(7,'user4','user4','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(8,'user5','user5','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(9,'user6','user6','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(10,'user7','user7','访客','访客','18911434843','hdmwzy@sina.com',1,NULL,0,'2017-03-08 14:32:57',0,'2017-03-08 14:32:57',0),(11,'user8','user8','访客','访客','18911434843','hdmwzy@sina.com',1,'',0,'2017-03-08 14:33:00',1,'2017-03-16 16:09:38',1),(12,'user9','user9','访客','user9','18911223344','hdmwzy@sina.com',1,'',1,'2017-03-16 16:13:24',1,'2017-03-16 16:13:24',0);
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

-- Dump completed on 2017-03-20  9:55:26
