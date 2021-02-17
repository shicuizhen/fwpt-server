/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : fwpt

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 17/02/2021 12:53:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '审批信息id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '提交信息的用户id',
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `grade` int(0) NULL DEFAULT NULL COMMENT '年级',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '提交审批信息时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of approve
-- ----------------------------
INSERT INTO `approve` VALUES (1, 1, '1', '1', 1, '1', '2020-12-28 19:44:34');

-- ----------------------------
-- Table structure for lost_claim
-- ----------------------------
DROP TABLE IF EXISTS `lost_claim`;
CREATE TABLE `lost_claim`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `iid` int(0) NULL DEFAULT NULL COMMENT '启事id',
  `create_id` int(0) NULL DEFAULT NULL COMMENT '该条记录的创建者id',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '记录生成时间',
  `sid` int(0) NULL DEFAULT NULL COMMENT '当前请求状态（0认领中，1认领成功，3认领失效）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_claim
-- ----------------------------
INSERT INTO `lost_claim` VALUES (1, 1, 1, '1', '1', '2020-12-28 19:43:59', 1);

-- ----------------------------
-- Table structure for lost_information
-- ----------------------------
DROP TABLE IF EXISTS `lost_information`;
CREATE TABLE `lost_information`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '启事id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品名称',
  `type` int(0) NULL DEFAULT NULL COMMENT '启事类型（失物0，拾遗1）',
  `kind_id` int(0) NULL DEFAULT NULL COMMENT '物品种类',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '物品信息描述',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失主或拾主姓名',
  `place_id` int(0) NULL DEFAULT NULL COMMENT '丢失/拾遗地点',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '丢失/拾遗详细位置',
  `lost_time` datetime(0) NULL DEFAULT NULL COMMENT '丢失/拾遗时间',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：邮箱',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '信息登记者id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '登记时间',
  `state_id` int(0) NULL DEFAULT NULL COMMENT '物品当前状态（0未完成，1认领成功）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_information
-- ----------------------------
INSERT INTO `lost_information` VALUES (1, '1', 1, 1, '1', '1', 1, '1', '2020-12-28 19:43:32', '1', '1', 1, '2020-12-28 19:43:40', 1);
INSERT INTO `lost_information` VALUES (2, '书籍', 1, 1, '我丢失了一本书', '张三', 1, '1', '2021-02-24 19:35:26', '12345625214', '12454@11.ss', 1, '2021-02-10 19:36:01', 2);
INSERT INTO `lost_information` VALUES (3, '笔', 2, 2, '我捡到了一杆笔', '李四', 2, '1', '2021-02-12 19:37:04', '15445612311', '56@546.sq', 2, '2021-02-17 19:37:22', 2);
INSERT INTO `lost_information` VALUES (4, NULL, NULL, 3, '丢了一个u盘', '王五', 1, '2', '2021-02-11 19:47:46', '15644456225', '2132@11.xx', 3, '2021-02-24 19:48:03', 2);

-- ----------------------------
-- Table structure for lost_kind
-- ----------------------------
DROP TABLE IF EXISTS `lost_kind`;
CREATE TABLE `lost_kind`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '物品类型id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品种类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_kind
-- ----------------------------
INSERT INTO `lost_kind` VALUES (1, '8');
INSERT INTO `lost_kind` VALUES (2, '6');
INSERT INTO `lost_kind` VALUES (3, '8');

-- ----------------------------
-- Table structure for lost_place
-- ----------------------------
DROP TABLE IF EXISTS `lost_place`;
CREATE TABLE `lost_place`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '地点id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地点名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_place
-- ----------------------------
INSERT INTO `lost_place` VALUES (1, '尚学楼');
INSERT INTO `lost_place` VALUES (2, '操场');
INSERT INTO `lost_place` VALUES (3, '尚德楼');
INSERT INTO `lost_place` VALUES (4, '跑道');

-- ----------------------------
-- Table structure for ques_comment
-- ----------------------------
DROP TABLE IF EXISTS `ques_comment`;
CREATE TABLE `ques_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '评论对应的回答id',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体内容',
  `at` int(0) NULL DEFAULT NULL COMMENT '安特的用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_comment
-- ----------------------------
INSERT INTO `ques_comment` VALUES (1, 1, 5, '2020-12-30 17:13:53', '我是评论的内容', 3);
INSERT INTO `ques_comment` VALUES (2, 0, 0, '2021-01-29 15:17:35', '', 0);
INSERT INTO `ques_comment` VALUES (3, 0, 0, '2021-01-29 15:19:11', '', 0);
INSERT INTO `ques_comment` VALUES (4, 0, 0, '2021-01-30 05:05:11', '', 0);
INSERT INTO `ques_comment` VALUES (5, 0, 0, '2021-01-30 05:16:25', '', 0);
INSERT INTO `ques_comment` VALUES (6, 0, 0, '2021-01-30 05:17:30', '', 0);
INSERT INTO `ques_comment` VALUES (7, 0, 0, '2021-01-30 05:22:20', '', 0);
INSERT INTO `ques_comment` VALUES (8, 0, 0, '2021-01-30 05:26:11', '', 0);
INSERT INTO `ques_comment` VALUES (9, 0, 0, '2021-01-30 06:03:11', '', 0);

-- ----------------------------
-- Table structure for ques_information
-- ----------------------------
DROP TABLE IF EXISTS `ques_information`;
CREATE TABLE `ques_information`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `sort_id` int(0) NOT NULL COMMENT '问题类别id',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '问题具体内容',
  `is_finish` int(0) NULL DEFAULT NULL COMMENT '问题是否被解决',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_information
-- ----------------------------
INSERT INTO `ques_information` VALUES (1, 3, 1, '2020-12-29 19:41:10', '找合租', '想找个合租', 1);
INSERT INTO `ques_information` VALUES (2, 4, 2, '2020-12-28 19:42:39', '出二手衣服', '二手衣服，九成新', 0);
INSERT INTO `ques_information` VALUES (3, 5, 3, '2021-01-07 09:23:22', '解答高数问题', '帮我解答高数题啊', 0);
INSERT INTO `ques_information` VALUES (4, 4, 1, '2021-01-20 11:56:20', '出二手粉底液', '八成新，可小刀', 0);
INSERT INTO `ques_information` VALUES (5, 5, 2, '2021-01-08 01:24:18', '离散题', '数学离散问题，求解答', 0);
INSERT INTO `ques_information` VALUES (11, 4, 2, NULL, '1', '这是一个信息', 0);
INSERT INTO `ques_information` VALUES (12, 4, 2, '2021-01-11 03:17:47', '1', '这是一个信息', 0);
INSERT INTO `ques_information` VALUES (13, 4, 4, '2021-01-11 07:54:33', '2', '这是一个问题', 0);
INSERT INTO `ques_information` VALUES (14, 1, 0, '2021-01-28 12:53:37', '3', '', 0);
INSERT INTO `ques_information` VALUES (15, 1, 0, '2021-01-28 12:54:07', '4', '1111', 0);

-- ----------------------------
-- Table structure for ques_like
-- ----------------------------
DROP TABLE IF EXISTS `ques_like`;
CREATE TABLE `ques_like`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '问题id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '回答id',
  `cid` int(0) NULL DEFAULT NULL COMMENT '评论id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '点赞的用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_like
-- ----------------------------
INSERT INTO `ques_like` VALUES (1, 1, NULL, NULL, 1, NULL);
INSERT INTO `ques_like` VALUES (2, 1, NULL, NULL, 4, NULL);
INSERT INTO `ques_like` VALUES (3, 1, NULL, NULL, 5, NULL);
INSERT INTO `ques_like` VALUES (4, 3, NULL, NULL, 4, NULL);
INSERT INTO `ques_like` VALUES (5, 5, NULL, NULL, 2, NULL);
INSERT INTO `ques_like` VALUES (6, 5, NULL, NULL, 3, NULL);
INSERT INTO `ques_like` VALUES (7, NULL, 1, NULL, 2, NULL);
INSERT INTO `ques_like` VALUES (8, NULL, 2, NULL, 3, NULL);
INSERT INTO `ques_like` VALUES (9, NULL, 3, NULL, 1, NULL);
INSERT INTO `ques_like` VALUES (10, NULL, NULL, 1, 5, NULL);
INSERT INTO `ques_like` VALUES (11, 2, NULL, NULL, 3, NULL);
INSERT INTO `ques_like` VALUES (12, NULL, NULL, 2, 5, NULL);
INSERT INTO `ques_like` VALUES (13, NULL, 1, NULL, 1, NULL);
INSERT INTO `ques_like` VALUES (14, NULL, 1, NULL, 5, NULL);
INSERT INTO `ques_like` VALUES (15, NULL, NULL, 21, 21, '2021-01-11 03:45:41');
INSERT INTO `ques_like` VALUES (16, 3, NULL, NULL, 2, '2021-01-11 08:22:38');

-- ----------------------------
-- Table structure for ques_reply
-- ----------------------------
DROP TABLE IF EXISTS `ques_reply`;
CREATE TABLE `ques_reply`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '回答id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '回答对应的问题id',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '回答创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_reply
-- ----------------------------
INSERT INTO `ques_reply` VALUES (1, 1, 1, '2020-12-28 19:45:04', '我可以合租');
INSERT INTO `ques_reply` VALUES (2, 1, 5, '2021-01-01 14:25:08', '我也能租');
INSERT INTO `ques_reply` VALUES (3, 2, 4, '2021-01-29 14:25:11', '我想买衣服');
INSERT INTO `ques_reply` VALUES (4, 3, 1, '2021-01-29 14:25:14', '高数题我会');
INSERT INTO `ques_reply` VALUES (5, 4, 2, '2021-01-07 14:25:17', '刀20可否');
INSERT INTO `ques_reply` VALUES (6, 5, 3, '2021-01-21 14:25:20', '我会离散题');
INSERT INTO `ques_reply` VALUES (7, 11, 3, '2021-02-05 10:33:55', '回答你');

-- ----------------------------
-- Table structure for ques_report
-- ----------------------------
DROP TABLE IF EXISTS `ques_report`;
CREATE TABLE `ques_report`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '举报信息id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '问题id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '回答id',
  `cid` int(0) NULL DEFAULT NULL COMMENT '评论id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '举报人id',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_report
-- ----------------------------
INSERT INTO `ques_report` VALUES (1, 1, NULL, NULL, 1, NULL);
INSERT INTO `ques_report` VALUES (2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `ques_report` VALUES (3, NULL, 2, NULL, NULL, NULL);
INSERT INTO `ques_report` VALUES (4, 5, NULL, NULL, NULL, NULL);
INSERT INTO `ques_report` VALUES (5, 4, NULL, NULL, NULL, NULL);
INSERT INTO `ques_report` VALUES (6, NULL, NULL, 2, NULL, NULL);
INSERT INTO `ques_report` VALUES (7, NULL, NULL, 1, NULL, NULL);
INSERT INTO `ques_report` VALUES (8, NULL, 1, NULL, NULL, NULL);
INSERT INTO `ques_report` VALUES (9, 1, NULL, NULL, 5, NULL);
INSERT INTO `ques_report` VALUES (10, NULL, 3, NULL, 2, '2021-01-11 03:20:38');
INSERT INTO `ques_report` VALUES (11, NULL, NULL, 1, 2, '2021-01-11 03:20:46');

-- ----------------------------
-- Table structure for ques_sort
-- ----------------------------
DROP TABLE IF EXISTS `ques_sort`;
CREATE TABLE `ques_sort`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父类id（根分类的父分类id为0）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  `depression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别详情介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_sort
-- ----------------------------
INSERT INTO `ques_sort` VALUES (1, 0, '生活', '生活类问题', '2020-12-28 19:45:18');
INSERT INTO `ques_sort` VALUES (2, 0, '学习', '学习类问题', '2020-12-28 19:45:18');
INSERT INTO `ques_sort` VALUES (3, 1, '合租', '找人共同合租', '2020-12-28 19:45:18');
INSERT INTO `ques_sort` VALUES (4, 1, '出二手物品', '出售二手商品', '2020-12-28 19:45:18');
INSERT INTO `ques_sort` VALUES (5, 2, '数学题', '求解答数学题', '2020-12-28 19:45:18');
INSERT INTO `ques_sort` VALUES (6, 3, '新增', '新增', '2021-02-11 23:37:59');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `sex` int(0) NOT NULL COMMENT '性别',
  `birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `photo_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `grade` int(0) NOT NULL COMMENT '年级',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `created_by` int(0) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` int(0) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '20171308001', '张三', '123', '张张', 1, '2020-11-11 19:37:05', 'F:\\图片\\8180.jpg', 17, '软件工程', '15613358962', '17695842635@163.com', NULL, '2020-11-04 19:37:23', NULL, '2020-12-23 19:37:30');
INSERT INTO `users` VALUES (2, '20171308002', '李四', '123', 'lili', 0, '2020-12-16 19:39:30', 'F:\\图片\\8180.jpg', 17, '市场营销', '15613358962', '17695842635@163.com', NULL, '2020-12-16 19:40:02', NULL, '2020-12-01 19:40:09');
INSERT INTO `users` VALUES (3, '20171308003', '王五', '123', '望望', 1, '2021-01-13 11:57:46', 'F:\\图片\\8180.jpg', 17, '专业英语', '15613358962', '17695842635@163.com', NULL, '2020-12-28 11:57:59', NULL, '2020-12-28 11:58:04');
INSERT INTO `users` VALUES (4, '20171308004', '刘六', '123', '柳柳', 1, '2021-01-13 11:57:46', 'F:\\图片\\8180.jpg', 17, '网络', '15613358962', '17695842635@163.com', 0, '2020-12-28 11:57:59', NULL, '2020-12-28 11:58:04');
INSERT INTO `users` VALUES (5, '20171308005', '齐琪', '123', '琪琪', 1, '2021-01-13 11:57:46', 'F:\\图片\\8180.jpg', 17, '科技', '15613358962', '17695842635@163.com', NULL, '2020-12-28 11:57:59', NULL, '2020-12-28 11:58:04');

SET FOREIGN_KEY_CHECKS = 1;
