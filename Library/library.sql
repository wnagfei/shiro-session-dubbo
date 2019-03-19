/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-01-02 21:31:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminName` varchar(20) NOT NULL COMMENT '管理员用户名',
  `adminPw` varchar(20) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('0001', '0001');

-- ----------------------------
-- Table structure for `historyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `historyinfo`;
CREATE TABLE `historyinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` int(20) NOT NULL COMMENT '用户名',
  `seatId` varchar(60) NOT NULL,
  `date` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of historyinfo
-- ----------------------------
INSERT INTO `historyinfo` VALUES ('3', '3', '3', '3');
INSERT INTO `historyinfo` VALUES ('4', '221200001', '1', '2016-01-02');
INSERT INTO `historyinfo` VALUES ('5', '221200001', '1', '2016-01-02');

-- ----------------------------
-- Table structure for `longtermapplyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `longtermapplyinfo`;
CREATE TABLE `longtermapplyinfo` (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` int(20) NOT NULL COMMENT '用户名',
  `seatId` int(3) NOT NULL COMMENT '座位编号',
  `isAgree` varchar(10) NOT NULL,
  `time` int(3) NOT NULL COMMENT '申请时长',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `seatId` (`seatId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of longtermapplyinfo
-- ----------------------------
INSERT INTO `longtermapplyinfo` VALUES ('2', '221200002', '2', 'yes', '100');

-- ----------------------------
-- Table structure for `majorinfo`
-- ----------------------------
DROP TABLE IF EXISTS `majorinfo`;
CREATE TABLE `majorinfo` (
  `majorCode` int(2) NOT NULL COMMENT '专业代码',
  `majorName` varchar(20) NOT NULL COMMENT '专业名称',
  `scademyCode` int(2) NOT NULL COMMENT '学院代码',
  PRIMARY KEY (`majorCode`),
  KEY `scademyCode` (`scademyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of majorinfo
-- ----------------------------
INSERT INTO `majorinfo` VALUES ('22', '软件工程', '22');
INSERT INTO `majorinfo` VALUES ('23', '公共管理学院', '23');

-- ----------------------------
-- Table structure for `noticeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `noticeinfo`;
CREATE TABLE `noticeinfo` (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `amallTitle` varchar(20) DEFAULT NULL COMMENT '副标题',
  `contents` varchar(255) NOT NULL COMMENT '内容',
  `accessory` varchar(255) DEFAULT NULL COMMENT '附件',
  `date` varchar(20) NOT NULL COMMENT '发布日期',
  `author` varchar(20) NOT NULL COMMENT '作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of noticeinfo
-- ----------------------------
INSERT INTO `noticeinfo` VALUES ('1', '李嘉诚', '中国首富', '好多好多钱', '123', '2015.10.11', '李彦宏');
INSERT INTO `noticeinfo` VALUES ('2', '今晚打老虎', '', '12345', null, '2015-12-30 13:24:22', '阿三');
INSERT INTO `noticeinfo` VALUES ('3', '今晚打老虎2', '22', '123456', null, '2015-12-30 13:26:32', '阿四');
INSERT INTO `noticeinfo` VALUES ('4', '今晚打老虎3', '222', '1234567', null, '2015-12-30', '阿五');

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` int(20) NOT NULL COMMENT '用户名',
  `seatId` int(3) NOT NULL COMMENT '座位编号',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `seatId` (`seatId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('11', '221200001', '1');

-- ----------------------------
-- Table structure for `scademyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `scademyinfo`;
CREATE TABLE `scademyinfo` (
  `scademyCode` int(2) NOT NULL COMMENT '学院代码',
  `scademyName` varchar(20) NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`scademyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scademyinfo
-- ----------------------------
INSERT INTO `scademyinfo` VALUES ('1', '电气工程与自动化学院');
INSERT INTO `scademyinfo` VALUES ('2', '机械工程及自动化学院');
INSERT INTO `scademyinfo` VALUES ('3', '数学与计算机科学学院');
INSERT INTO `scademyinfo` VALUES ('4', '化学化工学院');
INSERT INTO `scademyinfo` VALUES ('5', '土木工程学院');
INSERT INTO `scademyinfo` VALUES ('6', '环境与资源学院');
INSERT INTO `scademyinfo` VALUES ('7', '管理学院');
INSERT INTO `scademyinfo` VALUES ('8', '生物科学与工程学院');
INSERT INTO `scademyinfo` VALUES ('9', '外国语学院');
INSERT INTO `scademyinfo` VALUES ('11', '物理与电信工程学院');
INSERT INTO `scademyinfo` VALUES ('14', '八方物流学院');
INSERT INTO `scademyinfo` VALUES ('15', '建筑学院');
INSERT INTO `scademyinfo` VALUES ('16', '紫金矿业学院');
INSERT INTO `scademyinfo` VALUES ('17', '工艺美术学院');
INSERT INTO `scademyinfo` VALUES ('18', '材料科学与工程学院');
INSERT INTO `scademyinfo` VALUES ('19', '法学院');
INSERT INTO `scademyinfo` VALUES ('21', '至诚学院');
INSERT INTO `scademyinfo` VALUES ('22', '软件学院');
INSERT INTO `scademyinfo` VALUES ('23', '公共管理学院');
INSERT INTO `scademyinfo` VALUES ('24', '阳光学院');
INSERT INTO `scademyinfo` VALUES ('26', '工程技术学院');
INSERT INTO `scademyinfo` VALUES ('29', '人文社会科学学院');

-- ----------------------------
-- Table structure for `seatinfo`
-- ----------------------------
DROP TABLE IF EXISTS `seatinfo`;
CREATE TABLE `seatinfo` (
  `seatId` int(3) NOT NULL COMMENT '座位编号',
  `location` varchar(20) NOT NULL COMMENT '位置',
  `isOrder` varchar(10) NOT NULL DEFAULT 'yes' COMMENT '是否可预约',
  `isUsed` varchar(10) NOT NULL DEFAULT 'yes' COMMENT '是否可用',
  PRIMARY KEY (`seatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seatinfo
-- ----------------------------
INSERT INTO `seatinfo` VALUES ('1', '一楼', 'no', 'yes');
INSERT INTO `seatinfo` VALUES ('2', '一楼', 'yes', 'no');
INSERT INTO `seatinfo` VALUES ('3', '二楼', 'yes', 'yes');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(20) NOT NULL COMMENT '用户名',
  `userPw` varchar(20) NOT NULL COMMENT '密码',
  `userName` varchar(20) NOT NULL COMMENT '用户姓名',
  `userSex` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `majorCode` int(2) NOT NULL COMMENT '专业代码',
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `friendId` int(20) DEFAULT NULL COMMENT '好友帐号',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('66', '123456', '66', 'male', '22', null, null, null);
INSERT INTO `userinfo` VALUES ('1111', '123456', '2', 'male', '22', null, null, null);
INSERT INTO `userinfo` VALUES ('4444', '123456', '4444', 'female', '22', '', '', null);
INSERT INTO `userinfo` VALUES ('221200001', '221200001', '张三', 'male', '22', '1383838438', '1234@qq.com', '221200003');
INSERT INTO `userinfo` VALUES ('221200002', '123456', '李四', 'male', '22', null, null, null);
INSERT INTO `userinfo` VALUES ('221200003', '123456', '王五', 'male', '23', null, null, null);
INSERT INTO `userinfo` VALUES ('221200004', '123456', '赵六', 'male', '22', '', '', null);
INSERT INTO `userinfo` VALUES ('221200006', '123456', '哒哒哒', 'male', '22', null, null, null);
