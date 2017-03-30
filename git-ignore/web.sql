/*
Navicat MySQL Data Transfer

Source Server         : www.xiningleyuan.com
Source Server Version : 50629
Source Host           : www.xiningleyuan.com:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-05-08 22:56:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for caiji
-- ----------------------------
DROP TABLE IF EXISTS `caiji`;
CREATE TABLE `caiji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laorenid` int(11) DEFAULT NULL,
  `laorenname` varchar(255) DEFAULT NULL,
  `gaoya` int(11) DEFAULT NULL,
  `diya` int(11) DEFAULT NULL,
  `xuetang` decimal(10,2) DEFAULT NULL,
  `maibo` int(11) DEFAULT NULL,
  `xueyang` int(11) DEFAULT NULL,
  `tizhong` decimal(10,2) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `createuser` int(11) DEFAULT NULL,
  `createusername` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caiji
-- ----------------------------

-- ----------------------------
-- Table structure for laoren
-- ----------------------------
DROP TABLE IF EXISTS `laoren`;
CREATE TABLE `laoren` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `idnumber` varchar(18) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `createuser` int(11) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `createusername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laoren
-- ----------------------------
INSERT INTO `laoren` VALUES ('1', '李小明', '女', '50', '回族', '1968年1月2日', '620125489658754589', '华中路', '09865485458', '18765489845', '1', '2016年4月4日', '超级管理员');
INSERT INTO `laoren` VALUES ('2', '李正华', '男', '89', '汉族', '1912年2月1日', '622012191202014458', '青海省西宁市城东区海西路一号院1140号2单元605室', '07550126458', '18119568878', '1', '2016年4月4日', '超级管理员');
INSERT INTO `laoren` VALUES ('12', '王涛', '男', '40', '汉', '19740409', '62070219740409111X', '西宁市城西区西关大街15号', null, '18993298099', '1', '2016年04月29日', '超级管理员');
INSERT INTO `laoren` VALUES ('13', '李雪来', '女', '80', '汉', null, null, '城中区瑞和园4号楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('15', '祁蓉媛', '女', '82', '汉', null, null, '城中区瑞和园小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('16', '胡玉兰', '女', '72', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('17', '张玉兰', '女', '70', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('18', '席华来', '女', '75', '汉', null, null, '城中区瑞和园小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('19', '张玉英', '女', '73', '汉', null, null, '城中区瑞和园小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('21', '邓秀', '女', '74', '汉', '1943年11月28日', '630103194311281621', '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('22', '王淑珍', '女', '77', '汉', '1940年7月28日', '632521194007287021', '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('23', '刘淑兰', '女', '83', '汉', null, null, '新民街17号园3号楼6楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('24', '萧淑霞', '女', '79', '汉', null, null, '新民街17号园3号楼4楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('25', '铁存贵', '女', '81', '汉', null, null, '新民街17号园3号楼5楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('26', '杨文军', '男', '62', '汉', null, null, '城中区瑞和园小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('28', '白春玲', '女', '58', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('29', '廖文龙', '男', '76', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('30', '冯珍花', '女', '54', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('31', '李秀菊', '女', '78', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('33', '谢春花', '女', '64', '汉', null, null, '新民街17号园1号楼171室', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('36', '和玉柱', '男', '68', '汉', null, null, '新民街17号园1号楼171室', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('45', '胡占花', '女', '46', '汉', null, null, '城中区兴隆巷5号楼263室', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('46', '李生汉', '男', '73', '汉', '1944年6月18日', '630103194406180014', '城中区正和小区3号楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('47', '艾淑莱', '女', '65', '汉', null, null, '城中区饮马街1号', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('48', '汤雄', '男', '76', '汉', '1940年12月11日', '632221194012110013', '城中区北玉井巷2号楼362室', null, '15500559881', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('49', '陈玉兰', '女', '73', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('50', '王春林', '女', '65', '汉', '1951年6月9日', '63010319510609002', '城中瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('51', '刘菊凤', '女', '53', '汉', null, null, '城中瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('52', '陈 学顺', '男', '76', '汉', null, null, '城中区正和小区3号楼35单元', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('53', '白莉', '女', '58', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('54', '杨成福', '男', '68', '汉', null, '6301031948031101x', '城中区大新街5号', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('55', '秦世荣', '男', '65', '汉', '1951年9月23日', '632800195109230017', '城中区法院街20号', null, '13997031378', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('56', '丁秀菊', '女', '54', '汉', '1962年11月15日', '630103196211151685', '城中区文化街', null, '15809719219', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('57', '师长军', '男', '43', '汉', '1971年11月2日', '63010319711026161x', '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('58', '郑玉兰', '女', '76', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('59', '师守清', '男', '78', '汉', null, null, '城中区瑞和小区6号楼2单元', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('60', '曹生莲', '女', '71', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('61', '师桂美', '女', '53', '汉', '1963年12月17号', '632825196312170023', '城中区新民街', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('62', '张风莲', '女', '65', '汉', null, null, '城中区瑞和小区', '8233276', null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('63', '周理', '男', '71', '汉', '1945年9月5日', null, '城中区新民街', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('64', '丁玉红', '女', '50', '汉', '1967年2月19号', '630103196702191622', '城中区宾和路社区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('65', '年玉玲', '女', '78', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('68', '高春秀', '女', '62', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('69', '袁秀兰', '女', '77', '汉', '1938年2月28号', '630103193802281621', '城中区新民街46号2号楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('70', '赵得芝', '女', '77', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('71', '沈玉兰', '女', '72', '汉', '1944年12月16号', '630104194412161027', '城中区正和小区4号楼1单元', null, '13709718676', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('72', '秦英子', '女', '66', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('73', '李永林', '男', '77', '汉', '1940年1月24号', '632126194001241014', '城中区黎和园小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('74', '廖义华', '女', '76', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('75', '张福山', '男', '80', '汉', null, null, '城中区黎和园小区2号楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('76', '宁洪来', '女', '80', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('77', '宋存志', '男', '66', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('78', '陶宗兰', '女', '76', '汉', '1939年4月8号', '630103193904081620', '城中区勤学巷1号楼', null, '15500563316', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('79', '蒋勇', '男', '47', '男', '1969年7月196号', '632621196907190035', '南川东路', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('80', '雷庭', '男', '46', '汉', '1968年3月24号', '632622196803240014', '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('81', '董静霞', '女', '72', '汉', null, null, '城中区正和小区', '8236185', null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('82', '张玉秀', '女', '73', '汉', null, null, '城中区正和小区', null, '18997123772', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('83', '潘洪雄', '男', '80', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('84', '罗彩云', '男', '60', '汉', null, null, '城中区正和小区', '4919325', null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('85', '陈珣', '男', '68', '汉', null, null, '城中区新民街46号', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('86', '王健', '男', '62', '汉', null, null, '关门街82号1号楼', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('87', '高吉寿', '男', '72', '汉', null, null, '城中区瑞和园5号楼', null, '13519738234', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('88', '李林', '男', '67', '汉', null, null, '城中区17号园', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('89', '李成木', '男', '65', '汉', '1957年4月5号', '630103195104050032', null, null, '13897404871', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('90', '白春兰', '女 ', '59', '汉', null, null, '城中区正和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('91', '周玉香', '女', '71', '汉', '1945年12月2号', '632826194512020342', '城中区法院街', '8234575', null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('92', '赵贵芝', '女', '59', '汉', '1957年12月6号', '630103195712061229', '城中区瑞和小区', null, '13109798267', '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('93', '刘芬', '女 ', '78', '汉', null, null, '城中区瑞和小区', null, null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('94', '马生兰', '女', '77', '汉', null, null, '城中区瑞和小区', '8223720', null, '1', '2016年05月03日', '超级管理员');
INSERT INTO `laoren` VALUES ('95', '韩华', '女', '68', '汉', '1948年12月27日', '63010319481270021', '城中区瑞和小区', null, '15202512163', '1', '2016年05月03日', '超级管理员');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent` int(11) DEFAULT '0',
  `shunxu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '', '0', '1');
INSERT INTO `menu` VALUES ('2', '用户管理', 'xitong/user.do', '1', '1');
INSERT INTO `menu` VALUES ('3', '老人管理', 'xitong/laoren.do', '1', '2');
INSERT INTO `menu` VALUES ('4', '健康管理', null, '0', '2');
INSERT INTO `menu` VALUES ('5', '健康数据采集', 'jiankang/caiji.do', '4', '1');
INSERT INTO `menu` VALUES ('6', '健康趋势', 'jiankang/qushi.do', '4', '3');
INSERT INTO `menu` VALUES ('7', '生活照料', '', '0', '3');
INSERT INTO `menu` VALUES ('8', '健康数据管理', 'jiankang/shuju.do', '4', '2');

-- ----------------------------
-- Table structure for shuxing
-- ----------------------------
DROP TABLE IF EXISTS `shuxing`;
CREATE TABLE `shuxing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `chinesetype` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `shunxu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shuxing
-- ----------------------------
INSERT INTO `shuxing` VALUES ('1', 'bingshi', '病史', '糖尿病', null, '2');
INSERT INTO `shuxing` VALUES ('3', 'bingshi', '病史', '老年痴呆症', null, '7');
INSERT INTO `shuxing` VALUES ('4', 'bingshi', '病史', '痛风', null, '5');
INSERT INTO `shuxing` VALUES ('5', 'bingshi', '病史', '高血压', null, '1');
INSERT INTO `shuxing` VALUES ('6', 'bingshi', '病史', '一级残疾', null, '12');
INSERT INTO `shuxing` VALUES ('7', 'bingshi', '病史', '冠心病', null, '3');
INSERT INTO `shuxing` VALUES ('8', 'bingshi', '病史', '颈椎病', null, '4');
INSERT INTO `shuxing` VALUES ('9', 'bingshi', '病史', '肺炎', null, '5');
INSERT INTO `shuxing` VALUES ('10', 'bingshi', '病史', '二级残疾', null, '13');
INSERT INTO `shuxing` VALUES ('11', 'bingshi', '病史', '高血脂', null, '8');
INSERT INTO `shuxing` VALUES ('12', 'bingshi', '病史', '慢性支气管炎', null, '10');
INSERT INTO `shuxing` VALUES ('13', 'bingshi', '病史', '脑卒中', null, '11');
INSERT INTO `shuxing` VALUES ('14', 'bingshi', '病史', '关节炎', null, '9');
INSERT INTO `shuxing` VALUES ('15', 'bingshi', '病史', '其它', null, '14');
INSERT INTO `shuxing` VALUES ('16', 'role', '角色', '超级管理员', '超级管理员拥有系统最大权限，可对系统进行高分险操作，分配角色时请注意！', '1');
INSERT INTO `shuxing` VALUES ('17', 'role', '角色', '系统管理员', '系统管理员只拥有系统管理的访问权限，可分配账号，管理老人等，不可使用其它功能！', '2');
INSERT INTO `shuxing` VALUES ('18', 'role', '角色', '健康管理员', '健康管理员只拥有健康管理的访问权限，可分配采集、管理健康数据等，不可使用其它功能！', '3');
INSERT INTO `shuxing` VALUES ('19', 'role', '角色', '生活管理员', '生活管理员只拥有生活照料的访问权限，不可使用其它功能！', '4');
INSERT INTO `shuxing` VALUES ('20', 'sex', '性别', '男', null, '1');
INSERT INTO `shuxing` VALUES ('21', 'sex', '性别', '女', null, '2');

-- ----------------------------
-- Table structure for tableinfo
-- ----------------------------
DROP TABLE IF EXISTS `tableinfo`;
CREATE TABLE `tableinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tablename` varchar(255) DEFAULT NULL,
  `columnname` varchar(255) DEFAULT NULL,
  `chinese` varchar(255) DEFAULT NULL,
  `tabledisable` varchar(255) DEFAULT NULL,
  `modaldisable` varchar(255) DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'text',
  `shunxu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tableinfo
-- ----------------------------
INSERT INTO `tableinfo` VALUES ('1', 'user', 'id', 'ID', null, null, 'number', '1');
INSERT INTO `tableinfo` VALUES ('2', 'user', 'name', '姓名', null, null, 'text', '2');
INSERT INTO `tableinfo` VALUES ('3', 'user', 'username', '用户名', null, null, 'text', '3');
INSERT INTO `tableinfo` VALUES ('4', 'user', 'password', '密码', 'disable', null, 'password', '4');
INSERT INTO `tableinfo` VALUES ('5', 'laoren', 'id', 'ID', null, null, 'number', '1');
INSERT INTO `tableinfo` VALUES ('6', 'laoren', 'name', '姓名', null, null, 'text', '2');
INSERT INTO `tableinfo` VALUES ('7', 'laoren', 'sex', '性别', null, null, 'select', '3');
INSERT INTO `tableinfo` VALUES ('8', 'laoren', 'age', '年龄', null, null, 'number', '4');
INSERT INTO `tableinfo` VALUES ('9', 'laoren', 'nation', '民族', null, null, 'text', '5');
INSERT INTO `tableinfo` VALUES ('10', 'laoren', 'birthday', '出生日期', null, null, 'date', '6');
INSERT INTO `tableinfo` VALUES ('11', 'laoren', 'idnumber', '身份证号', null, null, 'text', '7');
INSERT INTO `tableinfo` VALUES ('12', 'laoren', 'address', '地址', null, null, 'text', '8');
INSERT INTO `tableinfo` VALUES ('13', 'laoren', 'phone', '电话', null, null, 'tel', '9');
INSERT INTO `tableinfo` VALUES ('14', 'laoren', 'mobile', '手机', null, null, 'tel', '10');
INSERT INTO `tableinfo` VALUES ('15', 'laoren', 'createuser', '创建人', 'disable', 'disable', 'number', '11');
INSERT INTO `tableinfo` VALUES ('16', 'laoren', 'createtime', '创建时间', null, 'disable', 'datetime-local', '13');
INSERT INTO `tableinfo` VALUES ('17', 'caiji', 'id', 'ID', null, null, '', '1');
INSERT INTO `tableinfo` VALUES ('18', 'caiji', 'laorenid', '老人ID', null, null, 'number', '2');
INSERT INTO `tableinfo` VALUES ('19', 'caiji', 'gaoya', '高压', null, null, 'number', '4');
INSERT INTO `tableinfo` VALUES ('20', 'caiji', 'diya', '低压', null, null, 'number', '5');
INSERT INTO `tableinfo` VALUES ('21', 'caiji', 'xuetang', '血糖', null, null, 'number', '6');
INSERT INTO `tableinfo` VALUES ('22', 'caiji', 'maibo', '脉博', null, null, 'number', '7');
INSERT INTO `tableinfo` VALUES ('23', 'caiji', 'xueyang', '血氧', null, null, 'number', '8');
INSERT INTO `tableinfo` VALUES ('24', 'caiji', 'tizhong', '体重', null, null, 'number', '9');
INSERT INTO `tableinfo` VALUES ('25', 'caiji', 'time', '测量时间', null, null, 'datetime-local', '10');
INSERT INTO `tableinfo` VALUES ('27', 'caiji', 'createuser', '创建人', 'disable', 'disable', 'none', '11');
INSERT INTO `tableinfo` VALUES ('28', 'user', 'createuser', '创建人', 'disable', 'disable', 'number', '8');
INSERT INTO `tableinfo` VALUES ('29', 'user', 'createusername', '创建人姓名', null, 'disable', 'text', '9');
INSERT INTO `tableinfo` VALUES ('30', 'laoren', 'createusername', '创建人姓名', null, 'disable', 'text', '12');
INSERT INTO `tableinfo` VALUES ('31', 'user', 'createtime', '创建时间', null, 'disable', 'datetime-local', '7');
INSERT INTO `tableinfo` VALUES ('32', 'caiji', 'createusername', '创建人姓名', null, 'disable', 'none', '12');
INSERT INTO `tableinfo` VALUES ('33', 'caiji', 'createtime', '创建时间', null, 'disable', 'none', '13');
INSERT INTO `tableinfo` VALUES ('34', 'caiji', 'laorenname', '老人姓名', null, '', 'text', '3');
INSERT INTO `tableinfo` VALUES ('35', 'user', 'shuxingroleid', '角色ID', 'disable', 'disable', 'number', '5');
INSERT INTO `tableinfo` VALUES ('36', 'user', 'shuxingrolename', '角色名称', null, 'disable', 'select', '6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createuser` int(11) DEFAULT NULL,
  `createusername` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `shuxingroleid` int(11) DEFAULT NULL,
  `shuxingrolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shuxingroleid` (`shuxingroleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '超级管理员', 'root', 'root', '5', 'root', null, '16', '超级管理员');
INSERT INTO `user` VALUES ('7', '系统管理员', 'xitong', 'xitong', '5', '系统管理员', '2016-05-06 12:01:51', '17', '系统管理员');
INSERT INTO `user` VALUES ('8', '健康管理员', 'jiankang', 'jiankang', '5', '系统管理员', '2016-05-06 12:02:32', '18', '健康管理员');
INSERT INTO `user` VALUES ('9', '生活管理员', 'shenghuo', 'shenghuo', '5', '系统管理员', '2016-05-06 12:02:53', '19', '生活管理员');

-- ----------------------------
-- Table structure for usertomenu
-- ----------------------------
DROP TABLE IF EXISTS `usertomenu`;
CREATE TABLE `usertomenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shuxingid` int(11) DEFAULT NULL,
  `menuid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `menuid` (`menuid`) USING BTREE,
  KEY `shuxingid` (`shuxingid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertomenu
-- ----------------------------
INSERT INTO `usertomenu` VALUES ('1', '16', '1');
INSERT INTO `usertomenu` VALUES ('2', '16', '2');
INSERT INTO `usertomenu` VALUES ('3', '16', '3');
INSERT INTO `usertomenu` VALUES ('4', '16', '4');
INSERT INTO `usertomenu` VALUES ('5', '16', '5');
INSERT INTO `usertomenu` VALUES ('6', '16', '6');
INSERT INTO `usertomenu` VALUES ('7', '16', '7');
INSERT INTO `usertomenu` VALUES ('8', '16', '8');
INSERT INTO `usertomenu` VALUES ('9', '19', '7');
INSERT INTO `usertomenu` VALUES ('10', '17', '1');
INSERT INTO `usertomenu` VALUES ('11', '17', '2');
INSERT INTO `usertomenu` VALUES ('12', '17', '3');
INSERT INTO `usertomenu` VALUES ('13', '18', '4');
INSERT INTO `usertomenu` VALUES ('14', '18', '5');
INSERT INTO `usertomenu` VALUES ('15', '18', '6');
INSERT INTO `usertomenu` VALUES ('16', '19', '8');
