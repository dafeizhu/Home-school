/*
Navicat MySQL Data Transfer

Source Server         : First
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : jiaxiao

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-12-03 22:45:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
  `c_grade` varchar(20) NOT NULL,
  `c_NO` varchar(11) NOT NULL,
  PRIMARY KEY (`c_ID`),
  UNIQUE KEY `c_NO` (`c_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '初三（1）', '301');
INSERT INTO `t_class` VALUES ('2', '初三（2）', '302');
INSERT INTO `t_class` VALUES ('3', '初三（3）', '303');
INSERT INTO `t_class` VALUES ('4', '初三（4）', '304');
INSERT INTO `t_class` VALUES ('5', '初三（5）', '305');

-- ----------------------------
-- Table structure for `t_homework`
-- ----------------------------
DROP TABLE IF EXISTS `t_homework`;
CREATE TABLE `t_homework` (
  `h_ID` int(11) NOT NULL AUTO_INCREMENT,
  `h_c_NO` varchar(11) NOT NULL,
  `h_t_Obj` varchar(10) NOT NULL,
  `h_content` varchar(30) NOT NULL,
  `h_time` date NOT NULL,
  PRIMARY KEY (`h_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_homework
-- ----------------------------
INSERT INTO `t_homework` VALUES ('1', '301', '语文', '看一篇课外阅读，写50字读后感', '2018-09-04');
INSERT INTO `t_homework` VALUES ('2', '301', '数学', '完成课后作业P16.4', '2018-09-05');
INSERT INTO `t_homework` VALUES ('3', '301', '英语', '背诵第一单元单词', '2018-09-06');
INSERT INTO `t_homework` VALUES ('4', '302', '语文', '背诵古诗，回来默写', '2018-09-05');
INSERT INTO `t_homework` VALUES ('5', '302', '数学', '完成测验卷12题', '2018-09-05');
INSERT INTO `t_homework` VALUES ('6', '302', '英语', '背诵第一单元单词，明天听写', '2018-09-05');
INSERT INTO `t_homework` VALUES ('7', '303', '语文', '完成阅读一篇', '2018-09-06');
INSERT INTO `t_homework` VALUES ('8', '303', '数学', '完成试卷', '2018-09-06');
INSERT INTO `t_homework` VALUES ('9', '303', '英语', '背诵第二单元单词', '2018-09-06');

-- ----------------------------
-- Table structure for `t_inform`
-- ----------------------------
DROP TABLE IF EXISTS `t_inform`;
CREATE TABLE `t_inform` (
  `i_ID` int(11) NOT NULL AUTO_INCREMENT,
  `i_t_NO` varchar(11) CHARACTER SET utf8mb4 NOT NULL,
  `i_c_NO` varchar(11) CHARACTER SET utf8mb4 DEFAULT NULL,
  `i_c_grade` varchar(11) CHARACTER SET utf8mb4 NOT NULL,
  `i_content` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `i_time` date NOT NULL,
  PRIMARY KEY (`i_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inform
-- ----------------------------
INSERT INTO `t_inform` VALUES ('1', '2001001', '301', '初三（1）', '下周一刮台风不用来学校,务必躲在家里不要外出，一定要注意安全。！', '2018-09-05');
INSERT INTO `t_inform` VALUES ('2', '2001002', '301', '初三（1）', '下大雨注意安全', '2018-09-06');
INSERT INTO `t_inform` VALUES ('3', '2001003', '301', '初三（1）', '作业明天交', '2018-09-06');
INSERT INTO `t_inform` VALUES ('4', '2001001', '301', '初三（1）', '星期二照常上课,关于家教月刊《父母课堂》订阅意', '2018-09-07');
INSERT INTO `t_inform` VALUES ('5', '2001002', '302', '初三（2）', '下周一刮台风不用来学校', '2018-09-05');
INSERT INTO `t_inform` VALUES ('6', '2001003', '303', '初三（3）', '下周一刮台风不用来学校', '2018-09-05');
INSERT INTO `t_inform` VALUES ('7', '2001001', null, '初三（1）', '今天写了一天代码', '2018-11-13');
INSERT INTO `t_inform` VALUES ('8', '2001001', null, '初三（2）', '我们组的软件工程作业期末之前交 哈哈哈', '2018-11-24');

-- ----------------------------
-- Table structure for `t_parent`
-- ----------------------------
DROP TABLE IF EXISTS `t_parent`;
CREATE TABLE `t_parent` (
  `p_ID` int(11) NOT NULL AUTO_INCREMENT,
  `p_NO` varchar(11) NOT NULL,
  `p_Name` varchar(10) NOT NULL,
  `p_Sex` varchar(10) NOT NULL,
  `p_Password` varchar(16) NOT NULL,
  `p_Tel` varchar(16) NOT NULL,
  PRIMARY KEY (`p_ID`),
  UNIQUE KEY `p_NO` (`p_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_parent
-- ----------------------------
INSERT INTO `t_parent` VALUES ('1', '100160101', '王红', '女', '123456', '13131415167');
INSERT INTO `t_parent` VALUES ('2', '100160102', '李磊', '男', '123456', '13032425267');
INSERT INTO `t_parent` VALUES ('3', '100160103', '牛翠花', '女', '123456', '18926522546');
INSERT INTO `t_parent` VALUES ('4', '100160104', '王铁柱', '男', '123456', '13595653325');
INSERT INTO `t_parent` VALUES ('5', '100160105', '张全蛋', '男', '123456', '13755669946');

-- ----------------------------
-- Table structure for `t_privateletter`
-- ----------------------------
DROP TABLE IF EXISTS `t_privateletter`;
CREATE TABLE `t_privateletter` (
  `pl_ID` int(11) NOT NULL AUTO_INCREMENT,
  `pl_s_NO` varchar(11) NOT NULL,
  `pl_s_Name` varchar(11) NOT NULL,
  `pl_time` date NOT NULL,
  `pl_content` varchar(500) NOT NULL,
  `pl_state` varchar(11) NOT NULL,
  `pl_t_NO` varchar(11) NOT NULL,
  `pl_t_Name` varchar(11) NOT NULL,
  PRIMARY KEY (`pl_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privateletter
-- ----------------------------
INSERT INTO `t_privateletter` VALUES ('1', '1001001', '张子豪', '2018-09-11', '你好，我是初三一班班主任,开学第一天，希望你们各位同学醒目点！', '已读', '2001001', '刘佳怡');
INSERT INTO `t_privateletter` VALUES ('2', '1001001', '张子豪', '2018-12-01', '老师你好，我是张子豪的家长，他最近学校进步很快，我就知道是老师在背后努力，所以我转钱感谢你，已经打你支付宝账号上了，谢谢老师', '未读', '2001001', '刘佳怡');
INSERT INTO `t_privateletter` VALUES ('3', '1001001', '张子豪', '2018-12-01', '好好学习天天向上！', '未读', '2001002', '张子杰');
INSERT INTO `t_privateletter` VALUES ('4', '1001001', '张子豪', '2018-12-01', '小程序开发工具还是不够成熟，这里总是会无法输入文本，老是要重启，希望早日修复！', '未读', '2001001', '刘佳怡');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `s_ID` int(11) NOT NULL AUTO_INCREMENT,
  `s_NO` varchar(11) NOT NULL,
  `s_Name` varchar(11) NOT NULL,
  `s_c_NO` varchar(11) NOT NULL,
  `s_Sex` varchar(1) NOT NULL,
  `s_parent` varchar(11) NOT NULL,
  `s_password` varchar(255) NOT NULL,
  `s_parenttel` varchar(255) NOT NULL,
  `s_address` varchar(255) NOT NULL,
  PRIMARY KEY (`s_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '1001001', '张子豪', '301', '男', '王红', '123456', '13131415167', '广东省广州市');
INSERT INTO `t_student` VALUES ('2', '1001002', '李晓敏', '302', '女', '李磊', '123456', '13032425267', '广东省广州市');
INSERT INTO `t_student` VALUES ('3', '1001003', '李佳鑫', '303', '男', '牛翠花', '123456', '18926522546', '广东省广州市');
INSERT INTO `t_student` VALUES ('4', '1001004', '王子林', '304', '男', '王铁柱', '123456', '13595653325', '广东省广州市');
INSERT INTO `t_student` VALUES ('5', '1001005', '张梓涵', '305', '女', '张全蛋', '123456', '13755669946', '广东省广州市');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `t_ID` int(11) NOT NULL AUTO_INCREMENT,
  `t_NO` varchar(11) NOT NULL,
  `t_Name` varchar(10) NOT NULL,
  `t_Sex` varchar(10) NOT NULL,
  `t_Edu` varchar(10) NOT NULL,
  `t_Obj` varchar(10) NOT NULL,
  `t_Sub` varchar(20) NOT NULL,
  `t_Intro` varchar(20) NOT NULL,
  `t_Password` varchar(16) NOT NULL,
  `t_Tel` varchar(16) NOT NULL,
  PRIMARY KEY (`t_ID`),
  UNIQUE KEY `t_NO` (`t_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '2001001', '刘佳怡', '女', '本科', '语文', '', '工作两年', '654321', '13186525167');
INSERT INTO `t_teacher` VALUES ('2', '2001002', '张子杰', '男', '本科', '数学', '', '工作一年', '654321', '13725356359');
INSERT INTO `t_teacher` VALUES ('3', '2001003', '周晓颖', '女', '本科', '英语', '', '工作两年', '654321', '13044569893');

-- ----------------------------
-- Table structure for `t_teacherclass`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacherclass`;
CREATE TABLE `t_teacherclass` (
  `tc_ID` int(11) NOT NULL AUTO_INCREMENT,
  `tc_t_NO` varchar(11) NOT NULL,
  `tc_c_NO` varchar(11) NOT NULL,
  `tc_c_grade` varchar(10) NOT NULL,
  `tc_t_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`tc_ID`,`tc_c_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacherclass
-- ----------------------------
INSERT INTO `t_teacherclass` VALUES ('1', '2001001', '301', '初三（1）', '刘佳怡');
INSERT INTO `t_teacherclass` VALUES ('2', '2001001', '302', '初三（2）', '刘佳怡');
INSERT INTO `t_teacherclass` VALUES ('3', '2001002', '301', '初三（1）', '张子杰');
INSERT INTO `t_teacherclass` VALUES ('4', '2001002', '304', '初三（4）', '张子杰');
INSERT INTO `t_teacherclass` VALUES ('5', '2001003', '302', '初三（2）', '周晓颖');
INSERT INTO `t_teacherclass` VALUES ('6', '2001003', '303', '初三（3）', '周晓颖');
