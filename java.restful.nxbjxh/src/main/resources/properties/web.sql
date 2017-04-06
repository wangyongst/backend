/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-04-06 15:03:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(50) NOT NULL,
  `course_name` varchar(255) default NULL,
  `item_no` varchar(255) default NULL,
  `assign_num` char(10) default NULL,
  `main_people` varchar(50) default NULL COMMENT '主办人',
  `expert` varchar(50) default NULL,
  `expert_unit` varchar(255) default NULL,
  `assign_class` char(10) default NULL,
  `item_unit` varchar(255) default NULL COMMENT '项目主办单位',
  `year` char(10) default NULL,
  PRIMARY KEY  (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `value_int` bigint(20) default NULL,
  `value_string` varchar(255) default NULL,
  `huayi_id` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------
INSERT INTO `param` VALUES ('2', 'schooling', null, '中专', '6D5BAC53-308A-4FD0-8942-9D2400E343A8');
INSERT INTO `param` VALUES ('3', 'schooling', null, '高中', '83CA8327-C53B-4FDE-8A3A-9D2400E343A8');
INSERT INTO `param` VALUES ('4', 'schooling', null, '本科', 'B5DAC640-A32B-40FE-92F4-9D2400E343A8');
INSERT INTO `param` VALUES ('5', 'schooling', null, '小学', 'A09F3FB4-95E2-4635-957F-9D2400E343A8');
INSERT INTO `param` VALUES ('6', 'schooling', null, '大专', 'E843B435-50D5-488B-9632-9D2400E343A8');
INSERT INTO `param` VALUES ('7', 'schooling', null, '初中', 'BC51AEAF-8D1B-4508-9F5A-9D2400E343A8');
INSERT INTO `param` VALUES ('8', 'schooling', null, '其他', '409518C5-DA94-4D4E-9618-9D6F00E7D6FE');
INSERT INTO `param` VALUES ('9', 'schooling', null, '研究生', '2F6CEBCE-D98F-4108-8AA1-9D8C00E9A7B0');
INSERT INTO `param` VALUES ('10', 'schooling', null, '博士后', '7F088171-E96F-4316-8244-9D8C00E9A7B5');
INSERT INTO `param` VALUES ('11', 'schooling', null, '博士', 'F690E9F5-F3CE-4186-BDDF-9D8C00E9A7B5');
INSERT INTO `param` VALUES ('12', 'title', null, '高级工程师', '1B44001E-D0ED-4D7D-8004-9B2F0124B22E');
INSERT INTO `param` VALUES ('13', 'title', null, '副主任药师', '9EBDC906-B0CC-4CE7-8208-9B2F0124B22E');
INSERT INTO `param` VALUES ('14', 'title', null, '副主任护师', '539E51C2-8652-435F-8361-9B2F0124B22E');
INSERT INTO `param` VALUES ('15', 'title', null, '主任药师', 'AAF6E9A1-1F77-4DF5-838B-9B2F0124B22E');
INSERT INTO `param` VALUES ('16', 'title', null, '医士', 'BA8C132F-0D0F-428C-858F-9B2F0124B22E');
INSERT INTO `param` VALUES ('17', 'title', null, '主任护师', 'DB9A65F4-893C-48BD-873F-9B2F0124B22E');
INSERT INTO `param` VALUES ('18', 'title', null, '主管护师', '746FD884-24B8-4F7F-8D88-9B2F0124B22E');
INSERT INTO `param` VALUES ('19', 'title', null, '药剂士', '673E52F3-B92D-468E-8E5F-9B2F0124B22E');
INSERT INTO `param` VALUES ('20', 'title', null, '技师', '0A3BA382-42DB-459B-917D-9B2F0124B22E');
INSERT INTO `param` VALUES ('21', 'title', null, '技术员', '46EF158B-7B8B-4EEB-92A9-9B2F0124B22E');
INSERT INTO `param` VALUES ('22', 'title', null, '主管技师', '25FBA574-7AF4-4F03-955B-9B2F0124B22E');
INSERT INTO `param` VALUES ('23', 'title', null, '护师', 'F3FFA3DA-31FA-42B8-97C4-9B2F0124B22E');
INSERT INTO `param` VALUES ('24', 'title', null, '主任医师', 'AD054866-5331-4546-98BC-9B2F0124B22E');
INSERT INTO `param` VALUES ('25', 'title', null, '药剂师', 'C2E414E9-9B78-4CA1-9C58-9B2F0124B22E');
INSERT INTO `param` VALUES ('26', 'title', null, '医师', '7A62BA8B-E83C-4038-A6BF-9B2F0124B22E');
INSERT INTO `param` VALUES ('27', 'title', null, '工程师', 'CAB6D08C-FD01-4DF0-A8A3-9B2F0124B22E');
INSERT INTO `param` VALUES ('28', 'title', null, '主任技师', '7BBBAB7C-7335-47EE-ADAA-9B2F0124B22E');
INSERT INTO `param` VALUES ('29', 'title', null, '技士', '5444EAB3-A2E7-46D1-B1D0-9B2F0124B22E');
INSERT INTO `param` VALUES ('30', 'title', null, '助理工程师', '25D04624-ECBF-497E-B322-9B2F0124B22E');
INSERT INTO `param` VALUES ('31', 'title', null, '主治医师', '6A076A06-15CE-4B0D-B4F9-9B2F0124B22E');
INSERT INTO `param` VALUES ('32', 'title', null, '护士', 'F2D07246-76F8-4D18-B696-9B2F0124B22E');
INSERT INTO `param` VALUES ('33', 'title', null, '副主任医师', '10849B98-9DF0-40F9-B7E7-9B2F0124B22E');
INSERT INTO `param` VALUES ('34', 'title', null, '副主任技师', '851FDD40-1264-4DFC-B9AE-9B2F0124B22E');
INSERT INTO `param` VALUES ('35', 'title', null, '主管药师', '04BBF7E7-844F-4830-BA2A-9B2F0124B22E');
INSERT INTO `param` VALUES ('36', 'title', null, '统计师', '76BE6376-4976-4038-82BD-9B2F0124B233');
INSERT INTO `param` VALUES ('37', 'title', null, '副研究馆员', 'A16C8D4E-5629-4A97-8624-9B2F0124B233');
INSERT INTO `param` VALUES ('38', 'title', null, '会计师', '73AB23A3-E440-4CB2-8704-9B2F0124B233');
INSERT INTO `param` VALUES ('39', 'title', null, '主管检验师', 'D0683ACF-E9AF-4DF0-88E3-9B2F0124B233');
INSERT INTO `param` VALUES ('40', 'title', null, '统计员', '77730AF4-E8E2-45B1-8938-9B2F0124B233');
INSERT INTO `param` VALUES ('41', 'title', null, '实习研究员', 'CFB4D462-CED5-4A5F-8E37-9B2F0124B233');
INSERT INTO `param` VALUES ('42', 'title', null, '助教', 'DE3BCF42-5CBD-4E57-92F9-9B2F0124B233');
INSERT INTO `param` VALUES ('43', 'title', null, '副教授', '1BFCFE35-8BDA-497E-938A-9B2F0124B233');
INSERT INTO `param` VALUES ('44', 'title', null, '检验士', 'AEA3A0B7-07C9-4F02-94D8-9B2F0124B233');
INSERT INTO `param` VALUES ('45', 'title', null, '研究馆员', 'FAE54EC4-1096-44CA-982B-9B2F0124B233');
INSERT INTO `param` VALUES ('46', 'title', null, '无职称', '35208E7A-F827-498E-997D-9B2F0124B233');
INSERT INTO `param` VALUES ('47', 'title', null, '高级会计师', '9F46C3D3-357A-4C3C-A099-9B2F0124B233');
INSERT INTO `param` VALUES ('48', 'title', null, '助理会计师', '09BC7D7E-E40E-4EE4-A1B1-9B2F0124B233');
INSERT INTO `param` VALUES ('49', 'title', null, '编审', '1D42D394-DF08-401C-A38B-9B2F0124B233');
INSERT INTO `param` VALUES ('50', 'title', null, '教授', '9EB9EA34-334D-4886-A3B1-9B2F0124B233');
INSERT INTO `param` VALUES ('51', 'title', null, '副编审', 'B772B9F2-9841-42D2-A3E0-9B2F0124B233');
INSERT INTO `param` VALUES ('52', 'title', null, '经济员', '0299DB3B-59D2-49AD-A470-9B2F0124B233');
INSERT INTO `param` VALUES ('53', 'title', null, '编辑', '3FC02E63-96AB-4BA1-A4F9-9B2F0124B233');
INSERT INTO `param` VALUES ('54', 'title', null, '检验师', 'D3B10063-3220-4F77-A531-9B2F0124B233');
INSERT INTO `param` VALUES ('55', 'title', null, '会计员', '2E3FD670-6C40-450B-A78F-9B2F0124B233');
INSERT INTO `param` VALUES ('56', 'title', null, '副研究员', 'F15497CD-719D-4A25-A7FA-9B2F0124B233');
INSERT INTO `param` VALUES ('57', 'title', null, '主任检验师', '524D610A-780F-4201-AA39-9B2F0124B233');
INSERT INTO `param` VALUES ('58', 'title', null, '助理编辑', '7562849E-0765-4966-AD65-9B2F0124B233');
INSERT INTO `param` VALUES ('59', 'title', null, '高级统计师', '6D5ABFBB-64A2-4F0D-AD87-9B2F0124B233');
INSERT INTO `param` VALUES ('60', 'title', null, '研究员', '55F97BF3-F112-4656-B1C5-9B2F0124B233');
INSERT INTO `param` VALUES ('61', 'title', null, '经济师', '8F66C3AB-CC5C-4625-B1D7-9B2F0124B233');
INSERT INTO `param` VALUES ('62', 'title', null, '助理统计师', '12E185BA-B9D8-4382-B49F-9B2F0124B233');
INSERT INTO `param` VALUES ('63', 'title', null, '馆员', 'D83002B9-2B0F-45B1-B789-9B2F0124B233');
INSERT INTO `param` VALUES ('64', 'title', null, '助理研究员', '3FEC509E-7DD9-4B48-B7D6-9B2F0124B233');
INSERT INTO `param` VALUES ('65', 'title', null, '助理馆员', '592384AD-0934-4937-B97B-9B2F0124B233');
INSERT INTO `param` VALUES ('66', 'title', null, '讲师', 'FEE7FA5C-8437-4EF2-BC31-9B2F0124B233');
INSERT INTO `param` VALUES ('67', 'title', null, '副主任检验师', 'E365969F-D296-4D41-BCDF-9B2F0124B233');
INSERT INTO `param` VALUES ('68', 'title', null, '高级经济师', 'CE0B2D7F-680A-4782-BD42-9B2F0124B233');
INSERT INTO `param` VALUES ('69', 'title', null, '助理经济师', 'E616E699-4582-4203-BD46-9B2F0124B233');
INSERT INTO `param` VALUES ('70', 'title', null, '中西医结合主治医师', '74A721FC-1776-4AD3-8065-9CFE00D93250');
INSERT INTO `param` VALUES ('71', 'title', null, '中医主治医师', '7283E96B-A6C7-490F-821E-9CFE00D93250');
INSERT INTO `param` VALUES ('72', 'title', null, '中医医士', '89F4705D-C39C-482F-853E-9CFE00D93250');
INSERT INTO `param` VALUES ('73', 'title', null, '中医医师', '5FF71D52-3B14-47AE-8845-9CFE00D93250');
INSERT INTO `param` VALUES ('74', 'title', null, '中医副主任药师', 'AC73F7A7-D395-4038-889C-9CFE00D93250');
INSERT INTO `param` VALUES ('75', 'title', null, '中西医结合副主任医师', '69ED8B6C-CB6E-4FD2-88F7-9CFE00D93250');
INSERT INTO `param` VALUES ('76', 'title', null, '中医副主任医师', '88013164-D160-45AE-9446-9CFE00D93250');
INSERT INTO `param` VALUES ('77', 'title', null, '中西医结合医师', '200F3AB9-D769-4CE0-99F1-9CFE00D93250');
INSERT INTO `param` VALUES ('78', 'title', null, '见习医士', '25D4D7A6-740B-483C-9DDF-9CFE00D93250');
INSERT INTO `param` VALUES ('79', 'title', null, '中医主任医师', 'E364C7B0-4737-42BD-9DFF-9CFE00D93250');
INSERT INTO `param` VALUES ('80', 'title', null, '中医主任药师', '5C8F5665-0292-4B59-9E70-9CFE00D93250');
INSERT INTO `param` VALUES ('81', 'title', null, '中医主管药师', '2E036316-0A2D-4864-A063-9CFE00D93250');
INSERT INTO `param` VALUES ('82', 'title', null, '见习护士', '170F6295-E267-4501-AD1D-9CFE00D93250');
INSERT INTO `param` VALUES ('83', 'title', null, '中医药士', '7CF2363D-6F4D-4372-B485-9CFE00D93250');
INSERT INTO `param` VALUES ('84', 'title', null, '中医药师', '20EE47B8-EAD4-411B-B9EE-9CFE00D93250');
INSERT INTO `param` VALUES ('85', 'title', null, '中西医结合主任医师', 'DA15AF8B-32D1-4523-BD6A-9CFE00D93250');
INSERT INTO `param` VALUES ('86', 'title', null, '见习检验师', 'A65413A6-B03E-4383-810C-9CFF0113B305');
INSERT INTO `param` VALUES ('87', 'title', null, '见习技师', '5D65EC45-3403-441A-8351-9CFF0113B305');
INSERT INTO `param` VALUES ('88', 'title', null, '见习药剂士', '30B0BDB0-6F97-4ADE-90B1-9CFF0113B305');
INSERT INTO `param` VALUES ('89', 'title', null, '见习医师', 'F9192924-A708-4B5D-9191-9CFF0113B305');
INSERT INTO `param` VALUES ('90', 'title', null, '见习检验士', '069E7BAC-AC4D-405E-98B1-9CFF0113B305');
INSERT INTO `param` VALUES ('91', 'title', null, '见习护师', 'C2FD8F49-D728-400F-A08F-9CFF0113B305');
INSERT INTO `param` VALUES ('92', 'title', null, '见习技士', 'AF4B5FCB-663F-4E4F-A82C-9CFF0113B305');
INSERT INTO `param` VALUES ('93', 'title', null, '见习药剂师', 'B5BF9935-93A7-45F3-BEAF-9CFF0113B305');
INSERT INTO `param` VALUES ('94', 'title', null, '中医技士', '44663848-F649-40E1-8142-9D6100EC5DA1');
INSERT INTO `param` VALUES ('95', 'title', null, '中医技师', '6B40B56B-4B77-4AB8-913F-9D6100EC5DA1');
INSERT INTO `param` VALUES ('96', 'title', null, '中医主任技师', 'C9FC7184-EC49-4574-985F-9D6100EC5DA1');
INSERT INTO `param` VALUES ('97', 'title', null, '中医主管技师', '04C9ACFF-E083-4AE4-A98A-9D6100EC5DA1');
INSERT INTO `param` VALUES ('98', 'title', null, '中医副主任技师', 'E94719F5-F28F-45EF-BE19-9D6100EC5DA1');
INSERT INTO `param` VALUES ('99', 'title', null, '主管医师', '48207F68-25D9-444A-9233-C1B6333C252C');
INSERT INTO `param` VALUES ('100', 'title', null, '其他', 'D3BFD4D6-B2E1-403F-BDF3-9BE401790D43');
INSERT INTO `param` VALUES ('101', 'title', null, '中学初级教师', '63F77029-4931-4920-94B2-9C0C00B7A8F1');
INSERT INTO `param` VALUES ('102', 'title', null, '中学中级教师', 'A106EF23-4A93-4705-B7CD-9C0C00B7C57D');
INSERT INTO `param` VALUES ('103', 'title', null, '中学高级教师', 'D9EA7A68-E239-4998-A1EC-9C0C00B7D0EF');
INSERT INTO `param` VALUES ('104', 'title', null, '中学特级教师', 'D381F6EC-1066-41D5-BA8C-9C0C00B7DC32');
INSERT INTO `param` VALUES ('105', 'title', null, '小学初级教师', 'F2C7A330-14A9-4DF5-B783-9C0C00B9A640');
INSERT INTO `param` VALUES ('106', 'title', null, '小学中级教师', 'B69C8903-4F66-47D2-974E-9C0C00BA11BC');
INSERT INTO `param` VALUES ('107', 'title', null, '小学高级教师', 'DAF297AD-807B-41B6-B5A7-9C0C00BA330A');
INSERT INTO `param` VALUES ('108', 'professional', null, '急诊学', '41BF7BF3-A289-4B5B-8237-9B8A00F2802B');
INSERT INTO `param` VALUES ('109', 'professional', null, '普通外科学', 'EE272D47-CCE0-40A2-8687-9B8A00F2802B');
INSERT INTO `param` VALUES ('110', 'professional', null, '泌尿外科学', '946B3D35-715C-4DD5-8A62-9B8A00F2802B');
INSERT INTO `param` VALUES ('111', 'professional', null, '骨外科学', '9687918B-0F3A-40A0-8B96-9B8A00F2802B');
INSERT INTO `param` VALUES ('112', 'professional', null, '肿瘤学', '453DADA0-4BB8-4D68-8CC5-9B8A00F2802B');
INSERT INTO `param` VALUES ('113', 'professional', null, '整形/器官移植', '831B2075-414A-43C5-8DAB-9B8A00F2802B');
INSERT INTO `param` VALUES ('114', 'professional', null, '烧伤外科学', 'DD4D364F-FE6E-43AD-90B2-9B8A00F2802B');
INSERT INTO `param` VALUES ('115', 'professional', null, '心血管病学', '28BE9AC4-005D-421F-940D-9B8A00F2802B');
INSERT INTO `param` VALUES ('116', 'professional', null, '胃肠病学', '8D3226CF-F79A-4021-99E2-9B8A00F2802B');
INSERT INTO `param` VALUES ('117', 'professional', null, '口腔医学', '4E1347B0-5EF8-45FE-9AB2-9B8A00F2802B');
INSERT INTO `param` VALUES ('118', 'professional', null, '精神卫生', 'F57BB55C-C167-4645-9C7F-9B8A00F2802B');
INSERT INTO `param` VALUES ('119', 'professional', null, '影像医学', '997D12C8-31FA-41F0-9F33-9B8A00F2802B');
INSERT INTO `param` VALUES ('120', 'professional', null, '神经外科学', 'E6DEEA3E-4D17-4B23-A088-9B8A00F2802B');
INSERT INTO `param` VALUES ('121', 'professional', null, '呼吸病学', '69E0064F-67E6-477C-A32E-9B8A00F2802B');
INSERT INTO `param` VALUES ('122', 'professional', null, '大外科', '31EC24D3-BF91-4F62-A571-9B8A00F2802B');
INSERT INTO `param` VALUES ('123', 'professional', null, '医学检验', '700AD458-2F3B-412F-A756-9B8A00F2802B');
INSERT INTO `param` VALUES ('124', 'professional', null, '神经病学', 'BA076B65-079B-4894-A879-9B8A00F2802B');
INSERT INTO `param` VALUES ('125', 'professional', null, '基础医学', '8B7EEB2C-45EC-47EA-AA08-9B8A00F2802B');
INSERT INTO `param` VALUES ('126', 'professional', null, '皮肤性病学', 'F4BAC12D-C435-46AC-ACF6-9B8A00F2802B');
INSERT INTO `param` VALUES ('127', 'professional', null, '公卫与预防', '8834A9B2-6E44-49EA-ACF7-9B8A00F2802B');
INSERT INTO `param` VALUES ('128', 'professional', null, '心胸外科学', '3CB440F9-1125-4C44-AE43-9B8A00F2802B');
INSERT INTO `param` VALUES ('129', 'professional', null, '血液病学', '0EB43057-3785-4EF1-B23B-9B8A00F2802B');
INSERT INTO `param` VALUES ('130', 'professional', null, '护理学', '0A69D5BD-A1F3-40DB-B248-9B8A00F2802B');
INSERT INTO `param` VALUES ('131', 'professional', null, '儿科学', '85FEED13-D56A-4746-B597-9B8A00F2802B');
INSERT INTO `param` VALUES ('132', 'professional', null, '内分泌病学', '81E2C375-BBE1-4213-B739-9B8A00F2802B');
INSERT INTO `param` VALUES ('133', 'professional', null, '大内科', '2368B69A-74DA-4A3C-B809-9B8A00F2802B');
INSERT INTO `param` VALUES ('134', 'professional', null, '医学教育与卫生管理', '21976911-FF54-4303-B9BA-9B8A00F2802B');
INSERT INTO `param` VALUES ('135', 'professional', null, '眼科学', '60753BE4-123A-4E01-B9CA-9B8A00F2802B');
INSERT INTO `param` VALUES ('136', 'professional', null, '中医学/中西医结合', 'C6E2B627-80A1-42BF-B9D4-9B8A00F2802B');
INSERT INTO `param` VALUES ('137', 'professional', null, '妇产科学', 'ADC804E8-300B-4341-BADF-9B8A00F2802B');
INSERT INTO `param` VALUES ('138', 'professional', null, '传染病学', 'C722C123-1C43-4D46-BB18-9B8A00F2802B');
INSERT INTO `param` VALUES ('139', 'professional', null, '耳鼻喉科', '684C73D0-A3CB-4B53-BC0F-9B8A00F2802B');
INSERT INTO `param` VALUES ('140', 'professional', null, '全科医学', '5DD41FD9-6324-448A-BD1C-9B8A00F2802B');
INSERT INTO `param` VALUES ('141', 'professional', null, '肾脏病学', 'E0CE9B02-721C-4722-BD6D-9B8A00F2802B');
INSERT INTO `param` VALUES ('142', 'professional', null, '麻醉学', 'AB56E981-D138-4430-BF11-9B8A00F2802B');
INSERT INTO `param` VALUES ('143', 'professional', null, '药学', '5F79C0C4-3F0C-4BFD-BFCB-9B8A00F2802B');

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
  PRIMARY KEY  (`id`),
  UNIQUE KEY `identity` (`identity`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '526700000003', '622425198912151016', '测试', '男', '18693118912', '宁夏自治区第一人民医院', '放射科', '工程师', 'test', 'test', '2014-05-07 14:10:10');
