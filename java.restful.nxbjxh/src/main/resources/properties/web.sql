/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-04-18 16:49:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `introduce` varchar(255) default NULL COMMENT '介绍',
  `itemno` varchar(255) default NULL,
  `picture` varchar(255) default NULL COMMENT '图片',
  `unit` varchar(255) default NULL COMMENT '单位',
  `year` char(10) default NULL COMMENT '年份',
  `score` int(11) unsigned NOT NULL COMMENT '学分',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '警戒素与人体免疫相关研究', '警戒素是近年来发现的一类能增强机体免疫功能的内源性物质,广泛 存在于各种细胞内,帮助人体抵抗外界刺激.研究发现,在皮肤病中,多种警戒素表达异常,包括防御素、抗菌肽、嗜酸性粒细胞来源的神经毒素、部分高迁移率族 蛋白等.不同警戒素在不同皮肤病中表达情况各异', '2011-02-07-002 (国)', 'picture/default.png', '宁夏保健学会', '2017', '5');
INSERT INTO `course` VALUES ('2', '警戒素与人体免疫相关研究2', '警戒素与人体免疫相关研究警戒素与人体免疫相关研究警戒素与人体免疫相关研究警戒素与人体免疫相关研究警戒素与人体免疫相关研究', '2011-02-07-002 (国)', 'picture/default.png', '宁夏保健学会', '2017', '5');

-- ----------------------------
-- Table structure for courserecord
-- ----------------------------
DROP TABLE IF EXISTS `courserecord`;
CREATE TABLE `courserecord` (
  `id` int(11) NOT NULL auto_increment,
  `user` int(11) NOT NULL,
  `course` int(11) NOT NULL,
  `begintime` varchar(255) default NULL COMMENT '开始时间',
  `endtime` varchar(255) default NULL COMMENT '结束时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courserecord
-- ----------------------------
INSERT INTO `courserecord` VALUES ('1', '13', '1', '2017-04-18 14:00:19', '2017-04-18 14:23:35');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL auto_increment,
  `course` int(11) NOT NULL COMMENT 'course ID',
  `name` varchar(255) default NULL COMMENT 'lession名称',
  `teacher` varchar(255) default NULL COMMENT '主讲',
  `introduce` varchar(255) default NULL COMMENT 'lession介绍',
  `picture` varchar(255) default NULL COMMENT 'lession图',
  `url` varchar(255) default NULL COMMENT 'lession流媒体地址',
  `pdf` varchar(255) default NULL COMMENT '讲义',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('1', '1', '临床常见药源性疾病与防治1', '王月丹', '药源性疾病是不合理用药的结果.现在药物品种、数量增多,药源性疾病的发生率呈上升趋势,其危害性仅次于血管疾病、恶性肿瘤的感染性疾病之后,医务人员要警惕各类药物可能产生的药源性疾病,控制药源性疾病的发生.药源性病系指药物在用于预防、诊断', 'picture/default.png', 'http://localhost:81/1.mp4', 'pdf/test.pdf');
INSERT INTO `lesson` VALUES ('2', '1', '临床常见药源性疾病与防治2', '王月丹', '药源性疾病是不合理用药的结果.现在药物品种、数量增多,药源性疾病的发生率呈上升趋势,其危害性仅次于血管疾病、恶性肿瘤的感染性疾病之后,医务人员要警惕各类药物可能产生的药源性疾病,控制药源性疾病的发生.药源性病系指药物在用于预防、诊断', 'picture/default.png', 'http://localhost:81/1.mp4', 'pdf/test.pdf');
INSERT INTO `lesson` VALUES ('3', '1', '临床常见药源性疾病与防治3', '王月丹', '药源性疾病是不合理用药的结果.现在药物品种、数量增多,药源性疾病的发生率呈上升趋势,其危害性仅次于血管疾病、恶性肿瘤的感染性疾病之后,医务人员要警惕各类药物可能产生的药源性疾病,控制药源性疾病的发生.药源性病系指药物在用于预防、诊断', 'picture/default.png', 'http://localhost:81/1.mp4', 'pdf/test.pdf');
INSERT INTO `lesson` VALUES ('4', '1', '临床常见药源性疾病与防治4', '王月丹', '药源性疾病是不合理用药的结果.现在药物品种、数量增多,药源性疾病的发生率呈上升趋势,其危害性仅次于血管疾病、恶性肿瘤的感染性疾病之后,医务人员要警惕各类药物可能产生的药源性疾病,控制药源性疾病的发生.药源性病系指药物在用于预防、诊断', 'picture/default.png', 'http://localhost:81/1.mp4', 'pdf/test.pdf');
INSERT INTO `lesson` VALUES ('5', '1', '临床常见药源性疾病与防治5', '王月丹', '药源性疾病是不合理用药的结果.现在药物品种、数量增多,药源性疾病的发生率呈上升趋势,其危害性仅次于血管疾病、恶性肿瘤的感染性疾病之后,医务人员要警惕各类药物可能产生的药源性疾病,控制药源性疾病的发生.药源性病系指药物在用于预防、诊断', 'picture/default.png', 'http://localhost:81/1.mp4', 'pdf/test.pdf');

-- ----------------------------
-- Table structure for lessonrecord
-- ----------------------------
DROP TABLE IF EXISTS `lessonrecord`;
CREATE TABLE `lessonrecord` (
  `id` int(11) NOT NULL auto_increment,
  `user` int(11) NOT NULL,
  `course` int(11) NOT NULL COMMENT '课程',
  `lesson` int(11) NOT NULL,
  `begintime` varchar(255) default NULL COMMENT '开始时间',
  `endtime` varchar(255) default NULL,
  `status` int(1) unsigned default NULL COMMENT '0为已经学习过未通过测验1为学习完成通过测验',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessonrecord
-- ----------------------------
INSERT INTO `lessonrecord` VALUES ('2', '13', '1', '1', '2017-04-18 14:00:19', '2017-04-18 14:23:35', '1');
INSERT INTO `lessonrecord` VALUES ('3', '13', '1', '2', '2017-04-18 14:01:51', '2017-04-18 14:04:22', '1');
INSERT INTO `lessonrecord` VALUES ('4', '13', '1', '3', '2017-04-18 14:05:06', '2017-04-18 14:19:18', '1');
INSERT INTO `lessonrecord` VALUES ('5', '13', '1', '4', '2017-04-18 14:05:44', '2017-04-18 14:20:43', '1');
INSERT INTO `lessonrecord` VALUES ('7', '13', '1', '5', '2017-04-18 14:22:55', '2017-04-18 14:23:02', '1');

-- ----------------------------
-- Table structure for number
-- ----------------------------
DROP TABLE IF EXISTS `number`;
CREATE TABLE `number` (
  `id` int(11) NOT NULL auto_increment,
  `number` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of number
-- ----------------------------
INSERT INTO `number` VALUES ('1', '10000');
INSERT INTO `number` VALUES ('2', '20000');

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------
INSERT INTO `param` VALUES ('2', 'schooling', '中专');
INSERT INTO `param` VALUES ('3', 'schooling', '高中');
INSERT INTO `param` VALUES ('4', 'schooling', '本科');
INSERT INTO `param` VALUES ('5', 'schooling', '小学');
INSERT INTO `param` VALUES ('6', 'schooling', '大专');
INSERT INTO `param` VALUES ('7', 'schooling', '初中');
INSERT INTO `param` VALUES ('8', 'schooling', '其他');
INSERT INTO `param` VALUES ('9', 'schooling', '研究生');
INSERT INTO `param` VALUES ('10', 'schooling', '博士后');
INSERT INTO `param` VALUES ('11', 'schooling', '博士');
INSERT INTO `param` VALUES ('12', 'title', '高级工程师');
INSERT INTO `param` VALUES ('13', 'title', '副主任药师');
INSERT INTO `param` VALUES ('14', 'title', '副主任护师');
INSERT INTO `param` VALUES ('15', 'title', '主任药师');
INSERT INTO `param` VALUES ('16', 'title', '医士');
INSERT INTO `param` VALUES ('17', 'title', '主任护师');
INSERT INTO `param` VALUES ('18', 'title', '主管护师');
INSERT INTO `param` VALUES ('19', 'title', '药剂士');
INSERT INTO `param` VALUES ('20', 'title', '技师');
INSERT INTO `param` VALUES ('21', 'title', '技术员');
INSERT INTO `param` VALUES ('22', 'title', '主管技师');
INSERT INTO `param` VALUES ('23', 'title', '护师');
INSERT INTO `param` VALUES ('24', 'title', '主任医师');
INSERT INTO `param` VALUES ('25', 'title', '药剂师');
INSERT INTO `param` VALUES ('26', 'title', '医师');
INSERT INTO `param` VALUES ('27', 'title', '工程师');
INSERT INTO `param` VALUES ('28', 'title', '主任技师');
INSERT INTO `param` VALUES ('29', 'title', '技士');
INSERT INTO `param` VALUES ('30', 'title', '助理工程师');
INSERT INTO `param` VALUES ('31', 'title', '主治医师');
INSERT INTO `param` VALUES ('32', 'title', '护士');
INSERT INTO `param` VALUES ('33', 'title', '副主任医师');
INSERT INTO `param` VALUES ('34', 'title', '副主任技师');
INSERT INTO `param` VALUES ('35', 'title', '主管药师');
INSERT INTO `param` VALUES ('36', 'title', '统计师');
INSERT INTO `param` VALUES ('37', 'title', '副研究馆员');
INSERT INTO `param` VALUES ('38', 'title', '会计师');
INSERT INTO `param` VALUES ('39', 'title', '主管检验师');
INSERT INTO `param` VALUES ('40', 'title', '统计员');
INSERT INTO `param` VALUES ('41', 'title', '实习研究员');
INSERT INTO `param` VALUES ('42', 'title', '助教');
INSERT INTO `param` VALUES ('43', 'title', '副教授');
INSERT INTO `param` VALUES ('44', 'title', '检验士');
INSERT INTO `param` VALUES ('45', 'title', '研究馆员');
INSERT INTO `param` VALUES ('46', 'title', '无职称');
INSERT INTO `param` VALUES ('47', 'title', '高级会计师');
INSERT INTO `param` VALUES ('48', 'title', '助理会计师');
INSERT INTO `param` VALUES ('49', 'title', '编审');
INSERT INTO `param` VALUES ('50', 'title', '教授');
INSERT INTO `param` VALUES ('51', 'title', '副编审');
INSERT INTO `param` VALUES ('52', 'title', '经济员');
INSERT INTO `param` VALUES ('53', 'title', '编辑');
INSERT INTO `param` VALUES ('54', 'title', '检验师');
INSERT INTO `param` VALUES ('55', 'title', '会计员');
INSERT INTO `param` VALUES ('56', 'title', '副研究员');
INSERT INTO `param` VALUES ('57', 'title', '主任检验师');
INSERT INTO `param` VALUES ('58', 'title', '助理编辑');
INSERT INTO `param` VALUES ('59', 'title', '高级统计师');
INSERT INTO `param` VALUES ('60', 'title', '研究员');
INSERT INTO `param` VALUES ('61', 'title', '经济师');
INSERT INTO `param` VALUES ('62', 'title', '助理统计师');
INSERT INTO `param` VALUES ('63', 'title', '馆员');
INSERT INTO `param` VALUES ('64', 'title', '助理研究员');
INSERT INTO `param` VALUES ('65', 'title', '助理馆员');
INSERT INTO `param` VALUES ('66', 'title', '讲师');
INSERT INTO `param` VALUES ('67', 'title', '副主任检验师');
INSERT INTO `param` VALUES ('68', 'title', '高级经济师');
INSERT INTO `param` VALUES ('69', 'title', '助理经济师');
INSERT INTO `param` VALUES ('70', 'title', '中西医结合主治医师');
INSERT INTO `param` VALUES ('71', 'title', '中医主治医师');
INSERT INTO `param` VALUES ('72', 'title', '中医医士');
INSERT INTO `param` VALUES ('73', 'title', '中医医师');
INSERT INTO `param` VALUES ('74', 'title', '中医副主任药师');
INSERT INTO `param` VALUES ('75', 'title', '中西医结合副主任医师');
INSERT INTO `param` VALUES ('76', 'title', '中医副主任医师');
INSERT INTO `param` VALUES ('77', 'title', '中西医结合医师');
INSERT INTO `param` VALUES ('78', 'title', '见习医士');
INSERT INTO `param` VALUES ('79', 'title', '中医主任医师');
INSERT INTO `param` VALUES ('80', 'title', '中医主任药师');
INSERT INTO `param` VALUES ('81', 'title', '中医主管药师');
INSERT INTO `param` VALUES ('82', 'title', '见习护士');
INSERT INTO `param` VALUES ('83', 'title', '中医药士');
INSERT INTO `param` VALUES ('84', 'title', '中医药师');
INSERT INTO `param` VALUES ('85', 'title', '中西医结合主任医师');
INSERT INTO `param` VALUES ('86', 'title', '见习检验师');
INSERT INTO `param` VALUES ('87', 'title', '见习技师');
INSERT INTO `param` VALUES ('88', 'title', '见习药剂士');
INSERT INTO `param` VALUES ('89', 'title', '见习医师');
INSERT INTO `param` VALUES ('90', 'title', '见习检验士');
INSERT INTO `param` VALUES ('91', 'title', '见习护师');
INSERT INTO `param` VALUES ('92', 'title', '见习技士');
INSERT INTO `param` VALUES ('93', 'title', '见习药剂师');
INSERT INTO `param` VALUES ('94', 'title', '中医技士');
INSERT INTO `param` VALUES ('95', 'title', '中医技师');
INSERT INTO `param` VALUES ('96', 'title', '中医主任技师');
INSERT INTO `param` VALUES ('97', 'title', '中医主管技师');
INSERT INTO `param` VALUES ('98', 'title', '中医副主任技师');
INSERT INTO `param` VALUES ('99', 'title', '主管医师');
INSERT INTO `param` VALUES ('100', 'title', '其他');
INSERT INTO `param` VALUES ('101', 'title', '中学初级教师');
INSERT INTO `param` VALUES ('102', 'title', '中学中级教师');
INSERT INTO `param` VALUES ('103', 'title', '中学高级教师');
INSERT INTO `param` VALUES ('104', 'title', '中学特级教师');
INSERT INTO `param` VALUES ('105', 'title', '小学初级教师');
INSERT INTO `param` VALUES ('106', 'title', '小学中级教师');
INSERT INTO `param` VALUES ('107', 'title', '小学高级教师');
INSERT INTO `param` VALUES ('108', 'professional', '急诊学');
INSERT INTO `param` VALUES ('109', 'professional', '普通外科学');
INSERT INTO `param` VALUES ('110', 'professional', '泌尿外科学');
INSERT INTO `param` VALUES ('111', 'professional', '骨外科学');
INSERT INTO `param` VALUES ('112', 'professional', '肿瘤学');
INSERT INTO `param` VALUES ('113', 'professional', '整形/器官移植');
INSERT INTO `param` VALUES ('114', 'professional', '烧伤外科学');
INSERT INTO `param` VALUES ('115', 'professional', '心血管病学');
INSERT INTO `param` VALUES ('116', 'professional', '胃肠病学');
INSERT INTO `param` VALUES ('117', 'professional', '口腔医学');
INSERT INTO `param` VALUES ('118', 'professional', '精神卫生');
INSERT INTO `param` VALUES ('119', 'professional', '影像医学');
INSERT INTO `param` VALUES ('120', 'professional', '神经外科学');
INSERT INTO `param` VALUES ('121', 'professional', '呼吸病学');
INSERT INTO `param` VALUES ('122', 'professional', '大外科');
INSERT INTO `param` VALUES ('123', 'professional', '医学检验');
INSERT INTO `param` VALUES ('124', 'professional', '神经病学');
INSERT INTO `param` VALUES ('125', 'professional', '基础医学');
INSERT INTO `param` VALUES ('126', 'professional', '皮肤性病学');
INSERT INTO `param` VALUES ('127', 'professional', '公卫与预防');
INSERT INTO `param` VALUES ('128', 'professional', '心胸外科学');
INSERT INTO `param` VALUES ('129', 'professional', '血液病学');
INSERT INTO `param` VALUES ('130', 'professional', '护理学');
INSERT INTO `param` VALUES ('131', 'professional', '儿科学');
INSERT INTO `param` VALUES ('132', 'professional', '内分泌病学');
INSERT INTO `param` VALUES ('133', 'professional', '大内科');
INSERT INTO `param` VALUES ('134', 'professional', '医学教育与卫生管理');
INSERT INTO `param` VALUES ('135', 'professional', '眼科学');
INSERT INTO `param` VALUES ('136', 'professional', '中医学/中西医结合');
INSERT INTO `param` VALUES ('137', 'professional', '妇产科学');
INSERT INTO `param` VALUES ('138', 'professional', '传染病学');
INSERT INTO `param` VALUES ('139', 'professional', '耳鼻喉科');
INSERT INTO `param` VALUES ('140', 'professional', '全科医学');
INSERT INTO `param` VALUES ('141', 'professional', '肾脏病学');
INSERT INTO `param` VALUES ('142', 'professional', '麻醉学');
INSERT INTO `param` VALUES ('143', 'professional', '药学');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL auto_increment,
  `lesson` int(11) NOT NULL,
  `ord` int(11) NOT NULL COMMENT '顺序',
  `name` varchar(255) default NULL COMMENT '名称',
  `test` int(11) default NULL COMMENT '上级ID',
  `multi` int(11) default NULL COMMENT '1多选，单选',
  `yes` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '1', '1', '[单选题] 我国全国性资本市场的形成和初步发展阶段是（　　）。 ', '0', '0', null);
INSERT INTO `test` VALUES ('2', '1', '1', 'A.1978-1992年 ', '1', null, '1');
INSERT INTO `test` VALUES ('3', '1', '2', 'B.1993-1998年 ', '1', null, null);
INSERT INTO `test` VALUES ('4', '1', '3', 'C.1981-1990年 ', '1', null, null);
INSERT INTO `test` VALUES ('5', '1', '4', 'D.1999年至今', '1', null, null);
INSERT INTO `test` VALUES ('6', '1', '2', '[多选题] \"证券交易市场通常分为（　　）和场外交易市场。 ', '0', '1', null);
INSERT INTO `test` VALUES ('7', '1', '1', 'A.证券交易所市场 ', '6', null, '1');
INSERT INTO `test` VALUES ('8', '1', '2', 'B.OTC市场 ', '6', null, null);
INSERT INTO `test` VALUES ('9', '1', '3', 'C.地方股权交易中心市场 ', '6', null, null);
INSERT INTO `test` VALUES ('10', '1', '4', 'D.A股市场', '6', null, '1');
INSERT INTO `test` VALUES ('11', '2', '4', '[单选题] 我国全国性资本市场的形成和初步发展阶段是（　　）。 ', '0', '0', null);
INSERT INTO `test` VALUES ('12', '3', '3', '[多选题] \"证券交易市场通常分为（　　）和场外交易市场。 ', '0', '1', null);
INSERT INTO `test` VALUES ('13', '2', '1', 'A.1978-1992年 ', '11', null, '1');
INSERT INTO `test` VALUES ('14', '2', '2', 'B.1993-1998年 ', '11', null, null);
INSERT INTO `test` VALUES ('15', '2', '3', 'C.1981-1990年 ', '11', null, null);
INSERT INTO `test` VALUES ('16', '2', '4', 'D.1999年至今', '11', null, null);
INSERT INTO `test` VALUES ('17', '3', '1', 'A.证券交易所市场 ', '12', null, '1');
INSERT INTO `test` VALUES ('18', '3', '2', 'B.OTC市场 ', '12', null, null);
INSERT INTO `test` VALUES ('19', '3', '3', 'C.地方股权交易中心市场 ', '12', null, '2');
INSERT INTO `test` VALUES ('20', '3', '4', 'D.A股市场', '12', null, null);
INSERT INTO `test` VALUES ('21', '4', '5', '[单选题] 我国全国性资本市场的形成和初步发展阶段是（　　）。 ', '0', '0', null);
INSERT INTO `test` VALUES ('22', '2', '6', '[多选题] \"证券交易市场通常分为（　　）和场外交易市场。 ', '0', '1', null);
INSERT INTO `test` VALUES ('23', '3', '7', '[单选题] 我国全国性资本市场的形成和初步发展阶段是（　　）。 ', '0', '0', null);
INSERT INTO `test` VALUES ('24', '5', '8', '[多选题] \"证券交易市场通常分为（　　）和场外交易市场。 ', '0', '1', null);
INSERT INTO `test` VALUES ('25', '4', '1', 'A.1978-1992年 ', '21', null, '1');
INSERT INTO `test` VALUES ('26', '4', '2', 'B.1993-1998年 ', '21', null, null);
INSERT INTO `test` VALUES ('27', '4', '3', 'C.1981-1990年 ', '21', null, null);
INSERT INTO `test` VALUES ('28', '4', '4', 'D.1999年至今', '21', null, null);
INSERT INTO `test` VALUES ('29', '2', '1', 'A.证券交易所市场 ', '22', null, '1');
INSERT INTO `test` VALUES ('30', '2', '2', 'B.OTC市场 ', '22', null, '1');
INSERT INTO `test` VALUES ('31', '2', '3', 'C.地方股权交易中心市场 ', '22', null, null);
INSERT INTO `test` VALUES ('32', '2', '4', 'D.A股市场', '22', null, null);
INSERT INTO `test` VALUES ('33', '3', '1', 'A.1978-1992年 ', '23', null, '1');
INSERT INTO `test` VALUES ('34', '3', '2', 'B.1993-1998年 ', '23', null, null);
INSERT INTO `test` VALUES ('35', '3', '3', 'C.1981-1990年 ', '23', null, null);
INSERT INTO `test` VALUES ('36', '3', '4', 'D.1999年至今', '23', null, null);
INSERT INTO `test` VALUES ('37', '5', '1', 'A.证券交易所市场 ', '24', null, '1');
INSERT INTO `test` VALUES ('38', '5', '2', 'B.OTC市场 ', '24', null, '1');
INSERT INTO `test` VALUES ('39', '5', '3', 'C.地方股权交易中心市场 ', '24', null, null);
INSERT INTO `test` VALUES ('40', '5', '4', 'D.A股市场', '24', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `number` varchar(20) default NULL COMMENT '学员编号',
  `identity` varchar(20) NOT NULL COMMENT '身份证号',
  `name` varchar(20) default NULL COMMENT '姓名',
  `sex` varchar(2) default NULL COMMENT '性别',
  `phone` varchar(50) default NULL COMMENT '联系方式',
  `unit` varchar(50) default NULL COMMENT '单位',
  `department` varchar(50) default NULL COMMENT '科室',
  `title` varchar(50) default NULL COMMENT '职称',
  `username` varchar(50) default NULL COMMENT '用户名',
  `password` varchar(50) default NULL COMMENT '密码',
  `time` varchar(50) default '0000-00-00 00:00:00' COMMENT '注册时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '', '622425198912151016', '测试', '男', '18693118912', '宁夏自治区第一人民医院', '放射科', '工程师', 'test', 'test', '2014-05-07 14:10:10');
INSERT INTO `user` VALUES ('5', null, '333', '333', '男', '111111', '2222', '111', '高级工程师', '111', '111', '2017-04-07 13:31:40');
INSERT INTO `user` VALUES ('13', '10000', '15012519821221568X', '中国', '男', '0931-8449977', '省二院', '儿科', '副主任药师', '333', '333333', '2017-04-07 15:15:45');
INSERT INTO `user` VALUES ('14', null, '622301198608016059', '汪泳', '男', '18119445588', '中国', '中国', '高级工程师', 'wangyong', 'wangyong', '2017-04-13 15:59:31');
