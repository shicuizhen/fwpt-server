/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.22 : Database - fwpt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fwpt` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `fwpt`;

/*Table structure for table `approve` */

DROP TABLE IF EXISTS `approve`;

CREATE TABLE `approve` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '审批信息id',
  `uid` int DEFAULT NULL COMMENT '提交信息的用户id',
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `grade` int DEFAULT NULL COMMENT '年级',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  `create_time` datetime DEFAULT NULL COMMENT '提交审批信息时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `approve` */

insert  into `approve`(`id`,`uid`,`sno`,`name`,`grade`,`major`,`create_time`) values 
(1,1,'1','1',1,'1','2020-12-28 19:44:34');

/*Table structure for table `college` */

DROP TABLE IF EXISTS `college`;

CREATE TABLE `college` (
  `id` int NOT NULL AUTO_INCREMENT,
  `college` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `college` */

insert  into `college`(`id`,`college`) values 
(1,'计算机科学与工程学院'),
(2,'体育学院'),
(3,'美术与设计学院'),
(4,'法学院'),
(5,'化工学院'),
(6,'资源与环境科学学院'),
(7,'物理学院 机电学院'),
(8,'外国语学院'),
(9,'音乐学院'),
(10,'理学院'),
(11,'文学与传媒学院'),
(12,'历史文化学院'),
(13,'经济管理学院'),
(14,'教师教育学院');

/*Table structure for table `lost_claim` */

DROP TABLE IF EXISTS `lost_claim`;

CREATE TABLE `lost_claim` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `iid` int DEFAULT NULL COMMENT '启事id',
  `create_id` int DEFAULT NULL COMMENT '该条记录的创建者id',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式：手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式：邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '记录生成时间',
  `sid` int DEFAULT NULL COMMENT '当前请求状态（0认领中，1认领成功，3认领失效）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `lost_claim` */

insert  into `lost_claim`(`id`,`iid`,`create_id`,`telephone`,`email`,`create_time`,`sid`) values 
(1,1,1,'1','1','2020-12-28 19:43:59',1);

/*Table structure for table `lost_information` */

DROP TABLE IF EXISTS `lost_information`;

CREATE TABLE `lost_information` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '启事id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品名称',
  `type` int DEFAULT NULL COMMENT '启事类型（失物0失物启事，拾遗1招领启事）',
  `kind_id` int DEFAULT NULL COMMENT '物品种类',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '物品信息描述',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '失主或拾主姓名',
  `place_id` int DEFAULT NULL COMMENT '丢失/拾遗地点',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '丢失/拾遗详细位置',
  `lost_time` datetime DEFAULT NULL COMMENT '丢失/拾遗时间',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式：手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式：邮箱',
  `create_by` int DEFAULT NULL COMMENT '信息登记者id',
  `create_time` datetime DEFAULT NULL COMMENT '登记时间',
  `state_id` int DEFAULT NULL COMMENT '物品当前状态（0未完成，1认领成功）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `lost_information` */

insert  into `lost_information`(`id`,`name`,`type`,`kind_id`,`description`,`username`,`place_id`,`position`,`lost_time`,`telephone`,`email`,`create_by`,`create_time`,`state_id`) values 
(1,'丢了的猫',1,1,'描述','猫的主人',1,'尚学楼301','2020-12-28 19:43:32','15632252254','4564546@45.21',2,'2020-12-28 19:43:40',1),
(2,'书籍',0,1,'我丢失了一本书','张三',1,'尚学楼322','2021-02-24 19:35:26','12345625214','12454@11.ss',1,'2021-02-10 19:36:01',1),
(3,'笔',1,2,'我捡到了一杆笔','李四',2,'操场西侧','2021-02-12 19:37:04','15445612311','56@546.sq',2,'2021-02-17 19:37:22',0),
(4,'u盘',0,3,'丢了一个u盘','王五',5,'食堂二楼西侧','2021-02-11 19:47:46','15644456225','2132@11.xx',3,'2021-02-24 19:48:03',1),
(5,'发卡',0,1,'丢了一个发卡','发卡的主人',2,'操场东门','2021-01-01 00:00:00','14568965254','1@11.22',4,'2021-02-23 11:49:14',0),
(6,'杯子',1,1,'我的杯子去哪了','三杯',3,'尚德楼302','2021-01-01 00:00:00','15612363252','2121.@11.1',5,'2021-02-23 11:55:05',0),
(7,'书',1,1,'余华的活着','佚名',2,'操场东侧','2021-02-17 11:34:36','32111121111','2121@11.1',5,'2021-02-25 11:34:54',0),
(50,'黑帽子',1,2,'不知道','张三',1,'302','2021-02-22 16:00:00','321','312',2,'2021-02-28 14:03:33',0),
(51,'红发卡',1,2,'跑步的时候丢的','1561',1,'跑步的时候丢的','2021-03-21 16:00:00','1561','17692151418@163.com',2,'2021-03-01 03:17:57',0),
(52,'书籍围城',1,1,'忘了拿走','12',1,'南门','2021-03-28 16:00:00','12','2121@111.212',2,'2021-03-01 03:40:52',0),
(53,'身份证',0,4,'在操场东侧吧','3321',1,'跑步时丢的','2021-03-01 16:00:00','231','231',2,'2021-03-01 04:14:38',0),
(56,'三国演义',0,1,'第三排的位置','李立',1,'305','2021-03-03 16:00:00','12356523652','32323@121.ds',2,'2021-03-02 13:58:18',0),
(57,'画册本',1,5,'在大概第二排的位置','丽红',1,'102','2021-03-07 16:00:00','15454785452','1111@11.11',2,'2021-03-02 14:15:17',0),
(58,'身份证',1,4,'17级软件工程章三','章三',1,'宿舍到尚学楼的路上','2021-03-02 16:00:00','15632541265','121121@11.11',2,'2021-03-02 14:20:55',0),
(59,'学生证',0,4,'18级软件工程钱多多','qdd',1,'不记得了','2021-03-28 16:00:00','222222211111','32132@11.1',3,'2021-03-02 14:23:57',0),
(60,'身份证',1,4,'上自习可能不小心弄丢了','白敬亭',1,'一楼','2021-03-15 16:00:00','14526325852','1211@11.11',2,'2021-03-02 14:29:29',0),
(61,'高数书',1,1,'下课忘记拿','爱学习',1,'402','2021-03-29 16:00:00','15874589635','1111！.sss',3,'2021-03-02 14:31:30',0),
(62,'笔记本',0,1,'跑步的时候忘记拿了','爱跑步',1,'东侧','2021-03-08 16:00:00','15632523698','1212@11.11',2,'2021-03-02 14:36:00',0),
(66,'111',0,2,'111','111',1,'111','2021-03-01 16:00:00','111','17692151418@163.com',1,'2021-03-03 06:43:29',0),
(67,'英语书',1,1,'203','啥啥啥',1,'203','2021-03-01 16:00:00','15623365236','25525211',2,'2021-03-05 11:37:43',0),
(68,'身份证',1,4,'身份证','15',1,'操场','2021-03-01 16:00:00','15','15',2,'2021-03-05 11:41:32',0),
(69,'学生证',1,4,'不记得了','刘六',1,'不知道丢哪里了','2021-02-28 16:00:00','14178965623','14521254@11.11',2,'2021-03-05 11:43:33',0),
(70,'银色u盘',0,5,'跑道','啊啊啊',1,'跑道','2021-03-29 16:00:00','15666666666','17692151418@163.com',1,'2021-03-05 14:43:52',0),
(72,'我的书包',0,2,'忘记拿了','章伞伞',1,'302','2021-03-29 16:00:00','15645656235','1111111111',21,'2021-03-15 02:22:13',1),
(73,'笔记本',1,4,'我的数学笔记本啊','王丢丢',1,'跑着跑着就丢了','2021-03-30 16:00:00','15613352145','17692151418@163.com',21,'2021-03-15 02:26:41',0),
(74,'231231',1,3,'捡到了帽子','小红帽',1,'跑道上有一个帽子','2021-03-14 16:00:00','15647852145','786868',21,'2021-03-15 02:28:33',1),
(75,'故事书',0,1,'8号楼宿舍下面','scz',1,'宿舍楼下','2021-03-27 16:00:00','15613584563','3178680558@163.com',21,'2021-03-15 08:56:19',0),
(76,'学生证',1,4,'忘记了','学生证',1,'尚德楼103','2021-03-07 16:00:00','15632521452','17692151418@163.com',21,'2021-03-15 09:01:52',0),
(77,'外套',0,3,'打球忘记拿了','scz',1,'操场西侧网上','2021-03-01 16:00:00','18745852145','17692151418@163.com',21,'2021-03-15 09:05:06',0),
(78,'银行卡',0,4,'应该是东边桌子上','scz',1,'二楼','2021-03-14 16:00:00','15636545214','17692151418@163.com',21,'2021-03-15 09:07:21',0),
(79,'身份证',0,4,'不记得了','四重奏',1,'111','2021-04-06 11:05:23','15636545214','17692151418@163.com',21,'2021-04-23 09:07:21',1),
(80,'312',-1,2,'312','312',1,'321','2021-04-11 16:00:00','3211','321',21,'2021-04-07 01:18:48',1);

/*Table structure for table `lost_kind` */

DROP TABLE IF EXISTS `lost_kind`;

CREATE TABLE `lost_kind` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '物品类型id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品种类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `lost_kind` */

insert  into `lost_kind`(`id`,`name`) values 
(1,'书本类'),
(2,'生活用品'),
(3,'衣物'),
(4,'证件类'),
(5,'其他');

/*Table structure for table `lost_place` */

DROP TABLE IF EXISTS `lost_place`;

CREATE TABLE `lost_place` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '地点id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校地点名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `lost_place` */

insert  into `lost_place`(`id`,`name`) values 
(1,'尚学楼'),
(2,'操场'),
(3,'尚德楼'),
(4,'跑道'),
(5,'食堂'),
(6,'其他');

/*Table structure for table `major` */

DROP TABLE IF EXISTS `major`;

CREATE TABLE `major` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `college` int NOT NULL COMMENT '学院编号',
  `major` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `major` */

insert  into `major`(`id`,`college`,`major`) values 
(1,1,'软件工程'),
(2,1,'计算机科学与技术'),
(3,1,'物流工程'),
(4,1,'信息安全'),
(5,1,'物联网工程'),
(6,2,'体育教育'),
(7,2,'社会体育'),
(8,2,'社会体育指导与管理'),
(9,3,'美术学'),
(10,3,'美术教育'),
(11,3,'动画'),
(12,3,'环境设计'),
(13,3,'视觉传达设计'),
(14,3,'艺术设计'),
(15,3,'工业设计'),
(16,4,'思想政治教育'),
(17,4,'法学'),
(18,4,'社会工作'),
(19,4,'社区管理与服务'),
(20,4,'知识产权'),
(21,5,'化学'),
(22,5,'药物制剂'),
(23,5,'制药工程'),
(24,5,'生物工程'),
(25,5,'食品科学与工程'),
(26,5,'化学工程与工艺'),
(27,5,'材料科学与工程'),
(28,6,'地理科学'),
(29,6,'环境生态工程'),
(30,6,'人文地理与城乡规划'),
(31,6,'地理信息科学'),
(32,6,'自然地理与资源环境'),
(33,6,'资源环境与城乡规划管理'),
(34,6,'摄影测量与遥感'),
(35,6,'资源环境与城乡规划管理'),
(36,7,'物理学'),
(37,7,'通信工程'),
(38,7,'电气工程及其自动化'),
(39,7,'电子信息工程'),
(40,7,'机械设计制造及其自动化'),
(41,7,'机器人工程'),
(42,8,'日语'),
(43,8,'英语'),
(44,8,'商务英语'),
(45,8,'俄语'),
(46,8,'英语教育'),
(47,9,'音乐教育'),
(48,9,'音乐学'),
(49,9,'舞蹈学'),
(50,10,'数学与应用数学'),
(51,10,'信息与计算科学'),
(52,10,'数据科学与大数据技术'),
(53,10,'信息与计算科学'),
(54,10,'数学教育'),
(55,11,'数字媒体技术'),
(56,11,'教育技术学'),
(57,11,'汉语言文学'),
(58,11,'语文教育'),
(59,11,'广告学'),
(60,11,'影视多媒体技术'),
(61,11,'秘书学'),
(62,11,'广播电视学'),
(63,12,'历史学'),
(64,12,'文化产业管理'),
(65,12,'人文教育'),
(66,12,'历史教育'),
(67,12,'文化市场经营管理'),
(68,13,'物业管理'),
(69,13,'市场营销'),
(70,13,'旅游管理'),
(71,13,'酒店管理'),
(72,13,'会计'),
(73,13,'工程造价');

/*Table structure for table `mood` */

DROP TABLE IF EXISTS `mood`;

CREATE TABLE `mood` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

/*Data for the table `mood` */

insert  into `mood`(`id`,`content`,`uid`,`create_time`,`nick`) values 
(2,'111111',2,'2021-03-05 09:05:25',NULL),
(113,'今天很开心',3,'2021-03-07 03:40:45','一枚开心'),
(114,'546456456',4,'2021-03-07 03:42:17','4564564'),
(115,'啊啊啊啊啊啊啊啊',5,'2021-03-10 10:04:47','啊啊啊'),
(116,'我好',1,'2021-03-10 10:30:18','你也好'),
(120,'11111111111',21,'2021-04-06 07:28:17','22222'),
(121,'猜猜我是谁',21,'2021-04-07 07:13:13','匿名');

/*Table structure for table `ques_information` */

DROP TABLE IF EXISTS `ques_information`;

CREATE TABLE `ques_information` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `sort_id` int NOT NULL COMMENT '问题类别id',
  `create_by` int NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题具体内容',
  `is_finish` int unsigned NOT NULL COMMENT '问题是否被解决',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `ques_information` */

insert  into `ques_information`(`id`,`sort_id`,`create_by`,`create_time`,`title`,`content`,`is_finish`) values 
(1,3,1,'2020-12-29 00:00:00','找合租','想找个合租',0),
(2,4,2,'2020-12-28 00:00:00','出二手衣服','二手衣服，九成新',0),
(3,5,3,'2021-01-07 00:00:00','解答高数问题','帮我解答高数题啊',0),
(4,4,1,'2021-01-20 00:00:00','出二手粉底液','八成新，可小刀',1),
(5,5,2,'2021-01-08 00:00:00','离散题','数学离散问题，求解答',0),
(11,4,2,'2021-02-20 15:04:53','1','这是一个信息',0),
(13,4,4,'2021-01-11 00:00:00','2','这是一个问题',0),
(15,1,5,'2021-01-28 00:00:00','4','出',0),
(17,3,6,'2021-02-23 12:22:05','123123123','123123123',0),
(18,3,7,'2021-02-28 14:18:50','租房','谁租',0),
(24,2,1,'2021-03-03 06:44:23','出','1213',0),
(25,5,1,'2021-03-10 10:54:15','一丢丢','一丢丢',0),
(26,1,8,'2021-03-10 10:54:26','一丢丢','一丢丢',0),
(27,1,21,'2021-03-15 09:25:34','学习嘛','求一份高数复习资料，感谢！！！',0);

/*Table structure for table `ques_like` */

DROP TABLE IF EXISTS `ques_like`;

CREATE TABLE `ques_like` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `qid` int unsigned DEFAULT '0' COMMENT '问题id',
  `rid` int unsigned DEFAULT '0' COMMENT '回答id',
  `uid` int unsigned DEFAULT '0' COMMENT '点赞的用户id',
  `create_time` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `ques_like` */

insert  into `ques_like`(`id`,`qid`,`rid`,`uid`,`create_time`) values 
(155,NULL,4,1,'2021-02-21 12:17:37'),
(161,NULL,11,2,'2021-02-21 12:39:40'),
(167,NULL,17,5,'2021-02-22 01:10:39'),
(168,NULL,18,4,'2021-02-22 01:10:40'),
(169,NULL,16,6,'2021-02-22 01:10:52'),
(172,NULL,26,7,'2021-02-22 05:25:53'),
(214,NULL,4,8,'2021-03-01 05:46:21'),
(215,NULL,5,9,'2021-03-01 05:46:23'),
(216,NULL,6,10,'2021-03-01 05:46:26'),
(218,NULL,9,11,'2021-03-01 05:46:30'),
(224,NULL,10,12,'2021-03-01 05:46:45'),
(267,NULL,3,13,'2021-03-03 06:41:33'),
(268,NULL,1,14,'2021-03-03 06:47:06'),
(270,NULL,2,15,'2021-03-06 06:08:35'),
(271,NULL,7,16,'2021-03-06 09:44:56'),
(272,NULL,1,1,'2021-03-10 10:29:53'),
(273,NULL,5,21,'2021-03-15 02:19:25'),
(274,NULL,43,21,'2021-03-15 02:19:27');

/*Table structure for table `ques_reply` */

DROP TABLE IF EXISTS `ques_reply`;

CREATE TABLE `ques_reply` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '回答id',
  `qid` int DEFAULT NULL COMMENT '回答对应的问题id',
  `create_by` int DEFAULT NULL COMMENT '回答创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '具体内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `ques_reply` */

insert  into `ques_reply`(`id`,`qid`,`create_by`,`create_time`,`content`) values 
(1,1,1,'2020-12-28 19:45:04','我可以合租'),
(2,1,1,'2021-01-01 14:25:08','我也能租'),
(3,2,1,'2021-01-29 14:25:11','我想买衣服'),
(4,3,2,'2021-01-29 14:25:14','高数题我会'),
(5,4,3,'2021-01-07 14:25:17','刀20可否'),
(6,5,4,'2021-01-21 14:25:20','我会离散题'),
(7,11,5,'2021-02-05 10:33:55','回答你'),
(10,12,1,'2021-02-19 07:11:26','写下你关于这个问题的想法吧'),
(31,1,6,'2021-03-03 06:38:57','覆盖f'),
(32,1,7,'2021-03-03 06:47:10','3213221321'),
(33,1,8,'2021-03-03 06:47:53','33123'),
(34,1,9,'2021-03-03 06:47:58','3123213'),
(35,1,10,'2021-03-03 06:48:08','32131312'),
(36,2,11,'2021-03-03 06:48:20','21312'),
(37,2,12,'2021-03-03 06:48:56','321312'),
(38,2,13,'2021-03-03 06:49:02','111111'),
(39,2,14,'2021-03-03 06:49:40','111111111111111111'),
(40,2,15,'2021-03-03 06:49:56','12121212121212'),
(41,2,16,'2021-03-06 06:08:54','11111'),
(42,1,17,'2021-03-10 10:29:35','我也想'),
(43,4,18,'2021-03-10 10:55:50','想买'),
(44,5,21,'2021-03-15 02:19:51','我可以回答你'),
(45,1,21,'2021-04-07 09:45:56','和我一起'),
(46,2,21,'2021-04-07 09:49:46','什么样子');

/*Table structure for table `ques_sort` */

DROP TABLE IF EXISTS `ques_sort`;

CREATE TABLE `ques_sort` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `pid` int DEFAULT NULL COMMENT '父类id（根分类的父分类id为0）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类别名',
  `depression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类别详情介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `ques_sort` */

insert  into `ques_sort`(`id`,`pid`,`name`,`depression`,`create_time`) values 
(1,0,'求资料','生活类问题','2020-12-28 19:45:18'),
(2,0,'解答学习问题','学习类问题','2020-12-28 19:45:18'),
(3,1,'网课','找人共同合租','2020-12-28 19:45:18'),
(4,1,'出二手物品','出售二手商品','2020-12-28 19:45:18'),
(5,2,'一起学习','求解答数学题','2020-12-28 19:45:18'),
(6,3,'合租','新增','2021-02-11 23:37:59'),
(7,1,'其他','生活类问题','2021-03-12 14:05:20');

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '举报信息id',
  `content` char(255) DEFAULT NULL COMMENT '问题id',
  `uid` int DEFAULT NULL COMMENT '举报人id',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `report` */

insert  into `report`(`id`,`content`,`uid`,`create_time`) values 
(1,'1',1,NULL),
(2,'3',2,'2021-03-12 20:22:55'),
(3,NULL,3,'2021-03-12 20:22:55'),
(4,'5',4,'2021-03-12 20:22:56'),
(5,'4',5,'2021-03-12 20:22:56'),
(6,NULL,6,'2021-03-12 20:22:57'),
(7,NULL,7,'2021-03-12 20:22:58'),
(8,NULL,8,'2021-03-12 20:22:58'),
(9,'1',9,'2021-03-12 20:23:00'),
(10,NULL,2,'2021-01-11 03:20:38'),
(11,NULL,2,'2021-01-11 03:20:46'),
(12,'11111111111111',11,'2021-03-12 20:23:03'),
(13,'789789789',1,'2021-03-09 07:09:08'),
(14,'7897754645130.',1,'2021-03-09 07:11:50'),
(15,'举报你',1,'2021-03-10 11:04:06');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `sex` int NOT NULL COMMENT '性别(男0，女1)',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `photo_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像地址',
  `grade` int NOT NULL COMMENT '年级',
  `major` int NOT NULL COMMENT '专业',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `created_by` int DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`,`sno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `users` */

insert  into `users`(`id`,`sno`,`name`,`password`,`nick`,`sex`,`birthday`,`photo_address`,`grade`,`major`,`phone`,`email`,`created_by`,`create_time`) values 
(1,'20171308001','张三','123456','阿三',0,'2020-11-11 19:37:05','F:\\bishe\\fwpt\\src\\assets\\usersImg/11.jpg',17,1,'15613358962','17695842635@163.com',NULL,'2020-11-04 19:37:23'),
(2,'20171308002','李四','123456','小四',0,'2020-12-16 19:39:30','F:\\bishe\\fwpt\\src\\assets\\usersImg/12.jpg',18,1,'15613358962','17695842635@163.com',NULL,'2020-12-16 19:40:02'),
(3,'20171308003','王五','123456','呜呜',0,'2021-01-13 11:57:46','F:\\bishe\\fwpt\\src\\assets\\usersImg/13.jpg',19,1,'15613358962','17695842635@163.com',NULL,'2020-12-28 11:57:59'),
(4,'20171308004','刘六','123456','小六',0,'2021-01-13 11:57:46','F:\\bishe\\fwpt\\src\\assets\\usersImg/14.jpg',20,1,'15613358962','17695842635@163.com',1,'2020-12-28 11:57:59'),
(5,'20171308005','宋志','123456','大志',0,'2021-01-13 11:57:46','F:\\bishe\\fwpt\\src\\assets\\usersImg/15.jpg',17,1,'15613358962','17695842635@163.com',NULL,'2020-12-28 11:57:59'),
(6,'20171308006','刘彪','123456','链表',0,'2021-03-07 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/16.jpg',18,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 04:39:29'),
(7,'20171308007','王处','123456','围城',0,'2021-03-21 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/17.jpg',19,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 06:31:05'),
(8,'20171308008','李卢','123456','来了',0,'2021-03-21 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/18.jpg',20,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 06:32:40'),
(9,'20171308009','张强','123456','强强',0,'2021-03-14 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/19.jpg',17,2,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:06:29'),
(10,'20171308010','李放','123456','理发',0,'2021-03-14 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/20.jpg',18,3,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:07:33'),
(11,'20171308011','宋献','123456','小献',0,'2021-03-21 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/21.jpg',19,2,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:09:12'),
(12,'20171308012','齐琪','123456','气球',1,'2021-03-14 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/1.jpg',20,2,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:13:48'),
(13,'20171308013','李莉','123456','丽丽',1,'2021-03-21 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/2.jpg',17,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:19:18'),
(14,'20171308014','艾静','123456','静静',1,'2021-03-22 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/3.jpg',18,2,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:26:13'),
(15,'20171308015','宋松','123456','松子',1,'2021-03-28 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/4.jpg',19,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:28:35'),
(16,'20171308016','刘琦','123456','琦琦',1,'2021-03-28 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/5.jpg',20,1,'15613358962','17695842635@163.com',NULL,'2021-03-03 07:30:13'),
(17,'20171308017','陆文昔','123456','阿昔',1,'2021-03-21 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/6.jpg',17,1,'15613358962','17695842635@163.com',NULL,'2021-03-10 10:08:51'),
(18,'20171308034','吉鑫升','123456','jixs',0,'2021-03-09 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/14.jpg',18,1,'15613358962','17695842635@163.com',NULL,'2021-03-10 11:08:17'),
(19,'20171308018','韩兆文','123456','海贼王',0,'2021-03-07 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/8.jpg',19,3,'15613358962','17695842635@163.com',NULL,'2021-03-12 08:50:02'),
(20,'20171308019','宋倩茜','123456','双曲线',1,'2021-02-28 16:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/9.jpg',20,1,'15613358962','17695842635@163.com',NULL,'2021-03-12 08:52:32'),
(21,'20171308096','时翠真','123456','scz',1,'2021-03-17 00:00:00','F:\\bishe\\fwpt\\src\\assets\\usersImg/9.jpg',17,2,'15613358962','17695842635@163.com',NULL,'2021-04-07 09:44:16'),
(28,'20171386952','万小凌','123456','壹万',1,'2021-04-25 16:00:00','',18,3,'12345678945','17692151418@163.com',NULL,'2021-04-08 06:48:30');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
