/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : fwpt

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/11/2020 19:02:13
*/
use fwpt;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve`  (
  `id` int(0) NOT NULL COMMENT '审批信息id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '提交信息的用户id',
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `grade` int(0) NULL DEFAULT NULL COMMENT '年级',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '提交审批信息时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of approve
-- ----------------------------

-- ----------------------------
-- Table structure for lost_claim
-- ----------------------------
DROP TABLE IF EXISTS `lost_claim`;
CREATE TABLE `lost_claim`  (
  `id` int(0) NOT NULL COMMENT '记录id',
  `iid` int(0) NULL DEFAULT NULL COMMENT '启事id',
  `create_id` int(0) NULL DEFAULT NULL COMMENT '该条记录的创建者id',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式：邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '记录生成时间',
  `sid` int(0) NULL DEFAULT NULL COMMENT '当前请求状态（0认领中，1认领成功，3认领失效）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_claim
-- ----------------------------

-- ----------------------------
-- Table structure for lost_information
-- ----------------------------
DROP TABLE IF EXISTS `lost_information`;
CREATE TABLE `lost_information`  (
  `id` int(0) NOT NULL COMMENT '物品id',
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_information
-- ----------------------------

-- ----------------------------
-- Table structure for lost_kind
-- ----------------------------
DROP TABLE IF EXISTS `lost_kind`;
CREATE TABLE `lost_kind`  (
  `id` int(0) NOT NULL COMMENT '物品类型id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品种类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_kind
-- ----------------------------

-- ----------------------------
-- Table structure for lost_place
-- ----------------------------
DROP TABLE IF EXISTS `lost_place`;
CREATE TABLE `lost_place`  (
  `id` int(0) NOT NULL COMMENT '地点id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地点名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_place
-- ----------------------------

-- ----------------------------
-- Table structure for ques_comment
-- ----------------------------
DROP TABLE IF EXISTS `ques_comment`;
CREATE TABLE `ques_comment`  (
  `id` int(0) NOT NULL COMMENT '评论id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '评论对应的回答id',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体内容',
  `at` int(0) NULL DEFAULT NULL COMMENT '安特的用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_comment
-- ----------------------------

-- ----------------------------
-- Table structure for ques_information
-- ----------------------------
DROP TABLE IF EXISTS `ques_information`;
CREATE TABLE `ques_information`  (
  `id` int(0) NOT NULL COMMENT '问题id',
  `sort_id` int(0) NOT NULL COMMENT '问题类别id',
  `create_by` int(0) NOT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '问题具体内容',
  `is_finish` int(0) NULL DEFAULT NULL COMMENT '问题是否被解决',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_information
-- ----------------------------

-- ----------------------------
-- Table structure for ques_like
-- ----------------------------
DROP TABLE IF EXISTS `ques_like`;
CREATE TABLE `ques_like`  (
  `id` int(0) NOT NULL COMMENT '点赞id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '问题id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '回答id',
  `cid` int(0) NULL DEFAULT NULL COMMENT '评论id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '点赞的用户id',
  `state` int(0) NULL DEFAULT NULL COMMENT '点赞状态（当前该信息是否被该用户赞）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_like
-- ----------------------------

-- ----------------------------
-- Table structure for ques_reply
-- ----------------------------
DROP TABLE IF EXISTS `ques_reply`;
CREATE TABLE `ques_reply`  (
  `id` int(0) NOT NULL COMMENT '回答id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '回答对应的问题id',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '回答创建者',
  `cerate_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_reply
-- ----------------------------

-- ----------------------------
-- Table structure for ques_report
-- ----------------------------
DROP TABLE IF EXISTS `ques_report`;
CREATE TABLE `ques_report`  (
  `id` int(0) NOT NULL COMMENT '举报信息id',
  `qid` int(0) NULL DEFAULT NULL COMMENT '问题id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '回答id',
  `cid` int(0) NULL DEFAULT NULL COMMENT '评论id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '举报人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_report
-- ----------------------------

-- ----------------------------
-- Table structure for ques_sort
-- ----------------------------
DROP TABLE IF EXISTS `ques_sort`;
CREATE TABLE `ques_sort`  (
  `id` int(0) NOT NULL COMMENT '类别id',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父类id（根分类的父分类id为0）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  `depression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别详情介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques_sort
-- ----------------------------

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
