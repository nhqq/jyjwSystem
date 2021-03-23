/*
 Navicat Premium Data Transfer

 Source Server         : my_sql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : jyjw

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 16/01/2021 19:24:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_number` int(11) NOT NULL,
  `c_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_create_time` datetime(0) NOT NULL,
  `t_id` int(11) NOT NULL,
  `c_week` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未设置',
  `c_time_finish` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未设置',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 1, '语文', '2021-01-04 16:32:34', 1, '未设置', '2021&19');
INSERT INTO `course` VALUES (2, 2, 'Linux', '2021-01-12 16:33:02', 2, '1&2、4&1', '2020&17');
INSERT INTO `course` VALUES (3, 3, '线性代数', '2021-01-12 16:33:02', 1, '1&3、4&2', '2020&13');
INSERT INTO `course` VALUES (24, 172809111, 'history', '2021-01-16 16:25:45', 1, '7&5', '2021&11');
INSERT INTO `course` VALUES (25, 174462067, 'Java Web', '2021-01-16 16:53:18', 1, '7&1、7&2', '2021&18');
INSERT INTO `course` VALUES (26, 174526143, '高等数学', '2021-01-16 16:54:22', 2, '3&3', '2021&16');
INSERT INTO `course` VALUES (27, 174551470, '计算机网络', '2021-01-16 16:54:47', 2, '5&3', '2021&17');
INSERT INTO `course` VALUES (28, 177884953, '软件测试技术', '2021-01-16 17:50:21', 3, '未设置', '2021&20');
INSERT INTO `course` VALUES (29, 178201875, 'C语言实战', '2021-01-16 17:55:38', 3, '3&4', '2021&18');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `score` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未考试',
  PRIMARY KEY (`sc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (3, 2, 1, '50');
INSERT INTO `score` VALUES (72, 26, 4, '未考试');
INSERT INTO `score` VALUES (73, 27, 4, '未考试');
INSERT INTO `score` VALUES (74, 1, 3, '90');
INSERT INTO `score` VALUES (75, 2, 3, '未考试');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_number` int(11) NULL DEFAULT NULL,
  `s_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_age` int(3) NULL DEFAULT NULL,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 1810414215, '聂涵', '男', 22, 'nh', '111111');
INSERT INTO `student` VALUES (2, 1810414217, '汪斌', '男', 20, 'wb', '123456');
INSERT INTO `student` VALUES (3, 1810414223, '谢金峰', '男', 21, 'xjf', '123456');
INSERT INTO `student` VALUES (4, 1810414225, '晏康文', '男', 21, 'ykw', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_number` int(11) NOT NULL,
  `t_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_age` int(3) NOT NULL,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 1, '汤姆', '男', 20, 'tom', '111111');
INSERT INTO `teacher` VALUES (2, 2, '弗兰克', '男', 23, 'frank', '123456');
INSERT INTO `teacher` VALUES (3, 3, '鲍勃', '男', 24, 'bob', '123456');

SET FOREIGN_KEY_CHECKS = 1;
