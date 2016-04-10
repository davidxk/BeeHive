/*
MySQL Data Transfer
Source Host: localhost
Source Database: bee_sensor
Target Host: localhost
Target Database: bee_sensor
Date: 2016/3/24 21:16:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `co` float default NULL,
  `temperature` float default NULL,
  `humidity` float default NULL,
  `noise` float default NULL,
  `ultraviolet` float default NULL,
  `phone` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `phonenum` (`phone`),
  CONSTRAINT `phonenum` FOREIGN KEY (`phone`) REFERENCES `users` (`phone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `phone` int(11) NOT NULL,
  `nickname` char(255) default NULL,
  `password` char(255) NOT NULL,
  PRIMARY KEY  (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `report` VALUES ('1', '2016-03-24 16:33:07', '1', '2', '3', '3', '4', '111');
INSERT INTO `report` VALUES ('2', '2016-04-09 11:33:07', '442', '2', '3', '3', '4', '111');
INSERT INTO `report` VALUES ('3', '2016-04-09 11:35:07', '22', '2', '3', '3', '4', '111');
INSERT INTO `report` VALUES ('4', '2016-04-09 11:37:07', '422', '2', '3', '3', '4', '111');
INSERT INTO `report` VALUES ('5', '2016-04-09 11:39:07', '27', '2', '3', '3', '4', '111');
INSERT INTO `users` VALUES ('111', '222', '111');
