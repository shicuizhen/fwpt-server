/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : bs

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 09/11/2020 20:38:17
*/
use fwpt;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consults
-- ----------------------------
DROP TABLE IF EXISTS `consults`;
CREATE TABLE `consults`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '存储的信息类型（咨询1-回答2-评论3-回复4）',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '发布人id',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '咨询-回答-评论-回复的内容',
  `like_num` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最近更新时间',
  `to_id` int(0) NULL DEFAULT NULL COMMENT '对应的上一级id（回答2-评论3-回复4需要填写该项，分别是，回答对应的咨询id，评论对应的回答id，回复对应的评论发布人id）',
  `is_finish` tinyint(0) NULL DEFAULT NULL COMMENT '问题是否被解决（只有咨询1需要填写这一项，默认为0，解决后置1）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consults
-- ----------------------------

-- ----------------------------
-- Table structure for lost_found
-- ----------------------------
DROP TABLE IF EXISTS `lost_found`;
CREATE TABLE `lost_found`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '类型（失物登记1，招领登记2）',
  `create_by` int(0) NULL DEFAULT NULL COMMENT '登记者id',
  `name` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记物品的名称',
  `place` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品丢失或者拾遗地点',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '物品描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '信息登记时间',
  `respond_id` int(0) NULL DEFAULT NULL COMMENT '回应信息的用户id',
  `contact_type` tinyint(0) NULL DEFAULT NULL COMMENT '回应信息用户的联系方式类型',
  `contact_content` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回应信息的用户的联系方式内容',
  `message` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回应信息的用户的留言',
  `last_respond_time` datetime(0) NULL DEFAULT NULL COMMENT '最近回应时间',
  `is_finish` int(0) NULL DEFAULT NULL COMMENT '物品状态（失物：寻找失物1，认领中2，认领成功3；招领：等待招领1，招领中2；招领成功3）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_found
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `rid` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `level` tinyint(0) NULL DEFAULT NULL COMMENT '角色级别',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名（学号）',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `avatar_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `avatar_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像真实路径',
  `professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在专业',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `pwd_reset_time` datetime(0) NULL DEFAULT NULL COMMENT '修改密码时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
