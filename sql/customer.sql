/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : ry-cloud

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 15/04/2026 15:34:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '客户姓名',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户地址',
  `sex` tinyint NOT NULL DEFAULT 0 COMMENT '性别 0为男，1为女,2为未知',
  `born_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `feature` tinyint NULL DEFAULT 0 COMMENT '客户特征 1好沟通   2不好沟通  3爱投诉',
  `driver_num` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '驾驶证号',
  `driver_vdate` date NULL DEFAULT NULL COMMENT '驾驶证到期日',
  `idcard_num` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '身份证号',
  `wechat_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '微信昵称',
  `wechat_appid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '微信appid',
  `wechat_openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `publish` tinyint NULL DEFAULT 1 COMMENT '是否可用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int NULL DEFAULT 0 COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int NULL DEFAULT 0 COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 132946 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户信息 ' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
