/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2013-04-15 12:04:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_front_mood`
-- ----------------------------
DROP TABLE IF EXISTS `t_front_mood`;
CREATE TABLE `t_front_mood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publish_content` varchar(100) NOT NULL,
  `publish_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKAA09CBF831FE70EA` (`user_id`),
  CONSTRAINT `FKAA09CBF831FE70EA` FOREIGN KEY (`user_id`) REFERENCES `t_front_sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_front_mood
-- ----------------------------

-- ----------------------------
-- Table structure for `t_front_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_front_sys_user`;
CREATE TABLE `t_front_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_front_sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` bigint(20) NOT NULL,
  `click` longtext,
  `menu_name` varchar(100) NOT NULL,
  `menu_no` varchar(100) NOT NULL,
  `menu_url` longtext,
  `order_no` varchar(100) DEFAULT NULL,
  `parent_no` varchar(100) NOT NULL,
  `target` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', 'return false;', '系统管理', '1', null, '1', '-1', null);
INSERT INTO `t_sys_menu` VALUES ('2', 'return false;', '权限管理', '1001', null, '1001', '1', null);
INSERT INTO `t_sys_menu` VALUES ('3', 'return false;', '基础数据维护', '1002', null, '1002', '1', null);
INSERT INTO `t_sys_menu` VALUES ('4', 'return false;', '运行监控', '1003', null, '1003', '1', null);
INSERT INTO `t_sys_menu` VALUES ('5', null, '用户管理', '1001001', 'admin/toUserList.do', '1001001', '1001', null);
INSERT INTO `t_sys_menu` VALUES ('6', null, '角色管理', '1001002', 'admin/toRoleList.do', '1001002', '1001', null);
INSERT INTO `t_sys_menu` VALUES ('7', null, '权限分配', '1001003', 'admin/build.do', '1001003', '1001', null);
INSERT INTO `t_sys_menu` VALUES ('8', null, '菜单管理', '1001004', 'admin/toMenuFrame.do', '1001004', '1001', null);
INSERT INTO `t_sys_menu` VALUES ('9', null, '字典维护', '1002001', 'admin/build.do', '1002001', '1002', null);
INSERT INTO `t_sys_menu` VALUES ('10', null, '全局参数表维护', '1002002', 'admin/build.do', '1002002', '1002', null);
INSERT INTO `t_sys_menu` VALUES ('11', null, 'request请求', '1003001', 'admin/build.do', '1003001', '1003', null);
INSERT INTO `t_sys_menu` VALUES ('12', null, 'session会话', '1003002', 'admin/build.do', '1003002', '1003', null);
INSERT INTO `t_sys_menu` VALUES ('13', null, 'JDBC执行监控', '1003003', 'admin/build.do', '1003003', '1003', null);
INSERT INTO `t_sys_menu` VALUES ('14', null, '系统异常监控', '1003004', 'admin/build.do', '1003004', '1003', null);
INSERT INTO `t_sys_menu` VALUES ('15', null, '服务器信息监控', '1003005', 'admin/build.do', '1003005', '1003', null);

-- ----------------------------
-- Table structure for `t_sys_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_privilege`;
CREATE TABLE `t_sys_privilege` (
  `id` bigint(20) NOT NULL,
  `privilege_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_privilege
-- ----------------------------
INSERT INTO `t_sys_privilege` VALUES ('1', '超级权限');
INSERT INTO `t_sys_privilege` VALUES ('2', '系统权限');

-- ----------------------------
-- Table structure for `t_sys_privilege_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_privilege_menu`;
CREATE TABLE `t_sys_privilege_menu` (
  `privilege_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`privilege_id`,`menu_id`),
  KEY `FKE83B638A9EC211C8` (`privilege_id`),
  KEY `FKE83B638AE120C2EC` (`menu_id`),
  CONSTRAINT `FKE83B638A9EC211C8` FOREIGN KEY (`privilege_id`) REFERENCES `t_sys_privilege` (`id`),
  CONSTRAINT `FKE83B638AE120C2EC` FOREIGN KEY (`menu_id`) REFERENCES `t_sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_privilege_menu
-- ----------------------------
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '1');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '2');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '3');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '4');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '5');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '6');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '7');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '8');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '9');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '10');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '11');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '12');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '13');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '14');
INSERT INTO `t_sys_privilege_menu` VALUES ('1', '15');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '1');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '2');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '5');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '6');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '7');
INSERT INTO `t_sys_privilege_menu` VALUES ('2', '8');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员');
INSERT INTO `t_sys_role` VALUES ('2', '系统管理员');

-- ----------------------------
-- Table structure for `t_sys_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_privilege`;
CREATE TABLE `t_sys_role_privilege` (
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`),
  KEY `FKA850DB859EC211C8` (`privilege_id`),
  KEY `FKA850DB85FA8F578C` (`role_id`),
  CONSTRAINT `FKA850DB859EC211C8` FOREIGN KEY (`privilege_id`) REFERENCES `t_sys_privilege` (`id`),
  CONSTRAINT `FKA850DB85FA8F578C` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_role_privilege
-- ----------------------------
INSERT INTO `t_sys_role_privilege` VALUES ('1', '1');
INSERT INTO `t_sys_role_privilege` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `register_date` datetime NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', '123456', '2013-03-12 08:29:07', 'super');
INSERT INTO `t_sys_user` VALUES ('2', '123456', '2013-03-12 08:29:07', 'admin');

-- ----------------------------
-- Table structure for `t_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKEEC648EDFA8F578C` (`role_id`),
  KEY `FKEEC648ED9FBA1B6C` (`user_id`),
  CONSTRAINT `FKEEC648ED9FBA1B6C` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`id`),
  CONSTRAINT `FKEEC648EDFA8F578C` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', '1');
INSERT INTO `t_sys_user_role` VALUES ('2', '2');
