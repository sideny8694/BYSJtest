-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 192.168.101.65    Database: xc440_system
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `xc440_system`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `xc440_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `xc440_system`;

--
-- Table structure for table `course_category`
--

DROP TABLE IF EXISTS `course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_category` (
  `id` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `label` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `parentid` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_show` tinyint DEFAULT NULL,
  `orderby` int DEFAULT NULL,
  `is_leaf` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_category`
--

LOCK TABLES `course_category` WRITE;
/*!40000 ALTER TABLE `course_category` DISABLE KEYS */;
INSERT INTO `course_category` (`id`, `name`, `label`, `parentid`, `is_show`, `orderby`, `is_leaf`) VALUES ('1','根结点','根结点','0',1,1,0),('1-1','前端开发','前端开发','1',1,1,0),('1-1-1','HTML/CSS','HTML/CSS','1-1',1,1,1),('1-1-10','其它','其它','1-1',1,10,1),('1-1-2','JavaScript','JavaScript','1-1',1,2,1),('1-1-3','jQuery','jQuery','1-1',1,3,1),('1-1-4','ExtJS','ExtJS','1-1',1,4,1),('1-1-5','AngularJS','AngularJS','1-1',1,5,1),('1-1-6','ReactJS','ReactJS','1-1',1,6,1),('1-1-7','Bootstrap','Bootstrap','1-1',1,7,1),('1-1-8','Node.js','Node.js','1-1',1,8,1),('1-1-9','Vue','Vue','1-1',1,9,1),('1-10','研发管理','研发管理','1',1,10,0),('1-10-1','敏捷开发','敏捷开发','1-10',1,1,1),('1-10-2','软件设计','软件设计','1-10',1,2,1),('1-10-3','软件测试','软件测试','1-10',1,3,1),('1-10-4','研发管理','研发管理','1-10',1,4,1),('1-10-5','其它','其它','1-10',1,5,1),('1-11','系统运维','系统运维','1',1,11,0),('1-11-1','Linux','Linux','1-11',1,1,1),('1-11-10','其它','其它','1-11',1,10,1),('1-11-2','Windows','Windows','1-11',1,2,1),('1-11-3','UNIX','UNIX','1-11',1,3,1),('1-11-4','Mac OS','Mac OS','1-11',1,4,1),('1-11-5','网络技术','网络技术','1-11',1,5,1),('1-11-6','路由协议','路由协议','1-11',1,6,1),('1-11-7','无线网络','无线网络','1-11',1,7,1),('1-11-8','Ngnix','Ngnix','1-11',1,8,1),('1-11-9','邮件服务器','邮件服务器','1-11',1,9,1),('1-12','产品经理','产品经理','1',1,12,0),('1-12-1','交互设计','交互设计','1-12',1,1,1),('1-12-2','产品设计','产品设计','1-12',1,2,1),('1-12-3','原型设计','原型设计','1-12',1,3,1),('1-12-4','用户体验','用户体验','1-12',1,4,1),('1-12-5','需求分析','需求分析','1-12',1,5,1),('1-12-6','其它','其它','1-12',1,6,1),('1-13','企业/办公/职场','企业/办公/职场','1',1,13,0),('1-13-1','运营管理','运营管理','1-13',1,1,1),('1-13-2','企业信息化','企业信息化','1-13',1,2,1),('1-13-3','网络营销','网络营销','1-13',1,3,1),('1-13-4','Office/WPS','Office/WPS','1-13',1,4,1),('1-13-5','招聘/面试','招聘/面试','1-13',1,5,1),('1-13-6','电子商务','电子商务','1-13',1,6,1),('1-13-7','CRM','CRM','1-13',1,7,1),('1-13-8','ERP','ERP','1-13',1,8,1),('1-13-9','其它','其它','1-13',1,9,1),('1-14','信息安全','信息安全','1',1,14,0),('1-14-1','密码学/加密/破解','密码学/加密/破解','1-14',1,1,1),('1-14-10','其它','其它','1-14',1,10,1),('1-14-2','渗透测试','渗透测试','1-14',1,2,1),('1-14-3','社会工程','社会工程','1-14',1,3,1),('1-14-4','漏洞挖掘与利用','漏洞挖掘与利用','1-14',1,4,1),('1-14-5','云安全','云安全','1-14',1,5,1),('1-14-6','防护加固','防护加固','1-14',1,6,1),('1-14-7','代码审计','代码审计','1-14',1,7,1),('1-14-8','移动安全','移动安全','1-14',1,8,1),('1-14-9','病毒木马','病毒木马','1-14',1,9,1),('1-15','测试目录','测试目录','1',1,15,0),('1-15-1','测试目录01','测试目录01','1-15',1,1,1),('1-2','移动开发','移动开发','1',1,2,0),('1-2-1','微信开发','微信开发','1-2',1,1,1),('1-2-2','iOS','iOS','1-2',1,2,1),('1-2-3','手游开发','手游开发','1-2',1,3,1),('1-2-4','Swift','Swift','1-2',1,4,1),('1-2-5','Android','Android','1-2',1,5,1),('1-2-6','ReactNative','ReactNative','1-2',1,6,1),('1-2-7','Cordova','Cordova','1-2',1,7,1),('1-2-8','其它','其它','1-2',1,8,1),('1-3','编程开发','编程开发','1',1,3,0),('1-3-1','C/C++','C/C++','1-3',1,1,1),('1-3-2','Java','Java','1-3',1,2,1),('1-3-3','.NET','.NET','1-3',1,3,1),('1-3-4','Objective-C','Objective-C','1-3',1,4,1),('1-3-5','Go语言','Go语言','1-3',1,5,1),('1-3-6','Python','Python','1-3',1,6,1),('1-3-7','Ruby/Rails','Ruby/Rails','1-3',1,7,1),('1-3-8','其它','其它','1-3',1,8,1),('1-4','数据库','数据库','1',1,4,0),('1-4-1','Oracle','Oracle','1-4',1,1,1),('1-4-2','MySQL','MySQL','1-4',1,2,1),('1-4-3','SQL Server','SQL Server','1-4',1,3,1),('1-4-4','DB2','DB2','1-4',1,4,1),('1-4-5','NoSQL','NoSQL','1-4',1,5,1),('1-4-6','Mongo DB','Mongo DB','1-4',1,6,1),('1-4-7','Hbase','Hbase','1-4',1,7,1),('1-4-8','数据仓库','数据仓库','1-4',1,8,1),('1-4-9','其它','其它','1-4',1,9,1),('1-5','人工智能','人工智能','1',1,5,0),('1-5-1','机器学习','机器学习','1-5',1,1,1),('1-5-2','深度学习','深度学习','1-5',1,2,1),('1-5-3','语音识别','语音识别','1-5',1,3,1),('1-5-4','计算机视觉','计算机视觉','1-5',1,4,1),('1-5-5','NLP','NLP','1-5',1,5,1),('1-5-6','强化学习','强化学习','1-5',1,6,1),('1-5-7','其它','其它','1-5',1,7,1),('1-6','云计算/大数据','云计算/大数据','1',1,6,0),('1-6-1','Spark','Spark','1-6',1,1,1),('1-6-2','Hadoop','Hadoop','1-6',1,2,1),('1-6-3','OpenStack','OpenStack','1-6',1,3,1),('1-6-4','Docker/K8S','Docker/K8S','1-6',1,4,1),('1-6-5','云计算基础架构','云计算基础架构','1-6',1,5,1),('1-6-6','虚拟化技术','虚拟化技术','1-6',1,6,1),('1-6-7','云平台','云平台','1-6',1,7,1),('1-6-8','ELK','ELK','1-6',1,8,1),('1-6-9','其它','其它','1-6',1,9,1),('1-7','UI设计','UI设计','1',1,7,0),('1-7-1','Photoshop','Photoshop','1-7',1,1,1),('1-7-10','InDesign','InDesign','1-7',1,10,1),('1-7-11','Pro/Engineer','Pro/Engineer','1-7',1,11,1),('1-7-12','Cinema 4D','Cinema 4D','1-7',1,12,1),('1-7-13','3D Studio','3D Studio','1-7',1,13,1),('1-7-14','After Effects（AE）','After Effects（AE）','1-7',1,14,1),('1-7-15','原画设计','原画设计','1-7',1,15,1),('1-7-16','动画制作','动画制作','1-7',1,16,1),('1-7-17','Dreamweaver','Dreamweaver','1-7',1,17,1),('1-7-18','Axure','Axure','1-7',1,18,1),('1-7-19','其它','其它','1-7',1,19,1),('1-7-2','3Dmax','3Dmax','1-7',1,2,1),('1-7-3','Illustrator','Illustrator','1-7',1,3,1),('1-7-4','Flash','Flash','1-7',1,4,1),('1-7-5','Maya','Maya','1-7',1,5,1),('1-7-6','AUTOCAD','AUTOCAD','1-7',1,6,1),('1-7-7','UG','UG','1-7',1,7,1),('1-7-8','SolidWorks','SolidWorks','1-7',1,8,1),('1-7-9','CorelDraw','CorelDraw','1-7',1,9,1),('1-8','游戏开发','游戏开发','1',1,8,0),('1-8-1','Cocos','Cocos','1-8',1,1,1),('1-8-2','Unity3D','Unity3D','1-8',1,2,1),('1-8-3','Flash','Flash','1-8',1,3,1),('1-8-4','SpriteKit 2D','SpriteKit 2D','1-8',1,4,1),('1-8-5','Unreal','Unreal','1-8',1,5,1),('1-8-6','其它','其它','1-8',1,6,1),('1-9','智能硬件/物联网','智能硬件/物联网','1',1,9,0),('1-9-1','无线通信','无线通信','1-9',1,1,1),('1-9-10','物联网技术','物联网技术','1-9',1,10,1),('1-9-11','其它','其它','1-9',1,11,1),('1-9-2','电子工程','电子工程','1-9',1,2,1),('1-9-3','Arduino','Arduino','1-9',1,3,1),('1-9-4','体感技术','体感技术','1-9',1,4,1),('1-9-5','智能硬件','智能硬件','1-9',1,5,1),('1-9-6','驱动/内核开发','驱动/内核开发','1-9',1,6,1),('1-9-7','单片机/工控','单片机/工控','1-9',1,7,1),('1-9-8','WinCE','WinCE','1-9',1,8,1),('1-9-9','嵌入式','嵌入式','1-9',1,9,1);
/*!40000 ALTER TABLE `course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dictionary` (
  `id` bigint DEFAULT NULL,
  `name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `code` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `item_values` text COLLATE utf8mb4_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary`
--

LOCK TABLES `dictionary` WRITE;
/*!40000 ALTER TABLE `dictionary` DISABLE KEYS */;
INSERT INTO `dictionary` (`id`, `name`, `code`, `item_values`) VALUES (12,'公共属性类型','000','[{\"code\":\"1\",\"codeInt\":1,\"desc\":\"使用态\"},{\"code\":\"0\",\"codeInt\":0,\"desc\":\"删除态\"},{\"code\":\"-1\",\"codeInt\":-1,\"desc\":\"暂时态\"}]'),(13,'对象的审核状态','002','[{\"code\":\"002001\",\"desc\":\"审核未通过\"},{\"code\":\"002002\",\"desc\":\"未审核\"},{\"code\":\"002003\",\"desc\":\"审核通过\"}]'),(14,'资源类型','001','[{\"code\":\"001001\",\"desc\":\"图片\"},{\"code\":\"001002\",\"desc\":\"视频\"},{\"code\":\"001003\",\"desc\":\"其它\"}]'),(15,'课程审核状态','202','[{\"code\":\"202001\",\"desc\":\"审核未通过\"},{\"code\":\"202002\",\"desc\":\"未提交\"},{\"code\":\"202003\",\"desc\":\"已提交\"},{\"code\":\"202004\",\"desc\":\"审核通过\"}]'),(16,'课程收费情况','201','[{\"code\":\"201000\",\"desc\":\"免费\"},{\"code\":\"201001\",\"desc\":\"收费\"}]'),(17,'课程等级','204','[{\"code\":\"204001\",\"desc\":\"初级\"},{\"code\":\"204002\",\"desc\":\"中级\"},{\"code\":\"204003\",\"desc\":\"高级\"}]'),(18,'课程模式状态','200','[{\"code\":\"200002\",\"desc\":\"录播\"},{\"code\":\"200003\",\"desc\":\"直播\"}]'),(19,'课程发布状态','203','[{\"code\":\"203001\",\"desc\":\"未发布\"},{\"code\":\"203002\",\"desc\":\"已发布\"},{\"code\":\"203003\",\"desc\":\"下线\"}]'),(20,'订单交易类型状态','600','[{\"code\":\"600001\",\"desc\":\"未支付\"},{\"code\":\"600002\",\"desc\":\"已支付\"},{\"code\":\"600003\",\"desc\":\"已关闭\"},{\"code\":\"600004\",\"desc\":\"已退款\"},{\"code\":\"600005\",\"desc\":\"已完成\"}]'),(21,'课程作业记录审批状态','306','[{\"code\":\"306001\",\"desc\":\"未提交\"},{\"code\":\"306002\",\"desc\":\"待批改\"},{\"code\":\"306003\",\"desc\":\"已批改\"}]'),(22,'消息通知状态','003','[{\"code\":\"003001\",\"desc\":\"未通知\"},{\"code\":\"003002\",\"desc\":\"成功\"}]'),(23,'支付记录交易状态','601','[{\"code\":\"601001\",\"desc\":\"未支付\"},{\"code\":\"601002\",\"desc\":\"已支付\"},{\"code\":\"601003\",\"desc\":\"已退款\"}]'),(24,'业务订单类型','602','[{\"code\":\"60201\",\"desc\":\"购买课程\"},{\"code\":\"60202\",\"desc\":\"学习资料\"}]'),(25,'第三方支付渠道编号','603','[{\"code\":\"603001\",\"desc\":\"微信支付\"},{\"code\":\"603002\",\"desc\":\"支付宝\"}]'),(26,'选课类型','700','[{\"code\":\"700001\",\"desc\":\"免费课程\"},{\"code\":\"700002\",\"desc\":\"收费课程\"}]'),(27,'选课状态','701','[{\"code\":\"701001\",\"desc\":\"选课成功\"},{\"code\":\"701002\",\"desc\":\"待支付\"}]'),(28,'选课学习资格','702','[{\"code\":\"702001\",\"desc\":\"正常学习\"},{\"code\":\"702002\",\"desc\":\"没有选课或选课后没有支付\"},{\"code\":\"702003\",\"desc\":\"已过期需要申请续期或重新支付\"}]');
/*!40000 ALTER TABLE `dictionary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-23 20:23:47
