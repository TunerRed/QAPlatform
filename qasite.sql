/*
Navicat MySQL Data Transfer

Source Server         : LocalConnection
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : qasite

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2018-07-13 15:16:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `Id` int(11) NOT NULL auto_increment COMMENT '�ش�ı��',
  `content` varchar(1000) default NULL COMMENT '�ش������',
  `replier_id` int(11) default NULL COMMENT '�ش���id',
  `question_id` int(11) default NULL COMMENT '���������id',
  `state` int(11) default NULL COMMENT '�ش�״̬',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('112', '我们忘了一件重要的东西，如果没有它的话，我们就洗什么东西都洗不干净', '116', '110', '0');
INSERT INTO `answer` VALUES ('113', '那么，这究竟是什么东西呢？', '118', '110', '0');
INSERT INTO `answer` VALUES ('114', '如果我们洗衣服或者洗澡的时候不使用肥皂，那总归是洗不干净的', '119', '110', '0');
INSERT INTO `answer` VALUES ('115', '对于污垢来说，肥皂是它们的天敌', '110', '110', '0');
INSERT INTO `answer` VALUES ('116', '就比如说烟炱吧，它就特别难清洗掉', '114', '110', '0');
INSERT INTO `answer` VALUES ('117', '烟炱是十分微小的炭粒，它的边缘凹凸不平', '115', '110', '0');
INSERT INTO `answer` VALUES ('118', '如果这样的小炭粒落在皮肤的凹纹里，就很难把它弄出来了', '117', '110', '0');
INSERT INTO `answer` VALUES ('119', '当然是泡沫多的好用。由此可见，肥皂好不好用的关键在于泡沫。', '117', '116', '0');
INSERT INTO `answer` VALUES ('120', '你仔细地观察它一下', '115', '115', '0');
INSERT INTO `answer` VALUES ('121', '它全部都是由小肥皂泡组成的，外面是包着一层水膜的小空气球', '116', '115', '0');
INSERT INTO `answer` VALUES ('122', '把烟炱抓住并带走的正是这些泡泡', '116', '115', '0');
INSERT INTO `answer` VALUES ('123', '烟炱的小颗粒沾在这些泡沫的泡泡上，要想把它们冲走就不难了', '113', '115', '0');
INSERT INTO `answer` VALUES ('124', '工厂把矿物从废石里面洗出来用的也是这种方法', '119', '115', '0');
INSERT INTO `answer` VALUES ('125', '矿物和废石在水中都是会下沉的', '116', '115', '0');
INSERT INTO `answer` VALUES ('126', '可是，假如把它们磨碎了，放在泡沫里，它们就不会下沉了', '113', '115', '0');
INSERT INTO `answer` VALUES ('127', '不要小看那些小泡泡，它们有着很强的力量，可以把矿物和废石的小颗粒全都带到上面来', '113', '115', '0');
INSERT INTO `answer` VALUES ('128', '这个时候，选择就开始了', '117', '115', '0');
INSERT INTO `answer` VALUES ('129', '由于废石的颗粒无法长时间沾在泡泡上，所以就会沉到桶底去', '116', '115', '0');
INSERT INTO `answer` VALUES ('130', '而矿物的颗粒却不会下沉', '117', '115', '0');
INSERT INTO `answer` VALUES ('131', '这样一来，桶的表面就会漂浮着一层矿物，那就很容易撇出来了', '110', '115', '0');
INSERT INTO `answer` VALUES ('132', '这又是一个简单得不能再简单的问题了', '119', '117', '0');
INSERT INTO `answer` VALUES ('133', '问题如此简单，就好像不需要问一样', '114', '117', '0');
INSERT INTO `answer` VALUES ('134', '可是，一旦提出这个问题，十个人当中只有一个人知道我们为什么要喝水', '112', '117', '0');
INSERT INTO `answer` VALUES ('135', '你会回答：我们喝水，那是因为我们需要水。', '115', '117', '0');
INSERT INTO `answer` VALUES ('136', '人活着就要一刻不停地饮水，补充水分是人体必需的。', '112', '119', '0');
INSERT INTO `answer` VALUES ('137', '你呵一口气到冰冷的玻璃上，玻璃就会模糊，上面布满了小水滴。', '114', '119', '0');
INSERT INTO `answer` VALUES ('138', '那么，这些水滴是从哪里来的呢？是从你身体里来的。', '118', '119', '0');
INSERT INTO `answer` VALUES ('139', '另外，天热的时候，你的身体会出汗。汗液是从哪里来的呢？也是你的身体。', '119', '119', '0');
INSERT INTO `answer` VALUES ('140', '既然你一直在消耗水和流失水，所以你就应该随时去补充它', '115', '119', '0');
INSERT INTO `answer` VALUES ('141', '一个人在24小时之内会流失掉整整12杯水', '112', '119', '0');
INSERT INTO `answer` VALUES ('142', '所以，他至少应该喝下或者吃下这么多的水', '117', '119', '0');
INSERT INTO `answer` VALUES ('143', '在肉里、蔬菜里、面包里——在任何一种食物中，水分都要比固体物质多得多', '110', '110', '0');
INSERT INTO `answer` VALUES ('144', '肉里面的水分要比固体物质多一倍，而黄瓜里几乎全都是水分', '119', '110', '0');
INSERT INTO `answer` VALUES ('145', '再来说说你身体里的水分吧，它和新鲜黄瓜里所含的水分几乎一样多', '119', '110', '0');
INSERT INTO `answer` VALUES ('146', '假如你的体重是40千克，那么其中的35千克都是水分，而固体物质只有5千克', '118', '110', '0');
INSERT INTO `answer` VALUES ('147', '成人的身体中所含的水分要少一些，大约是体重的四分之三。', '119', '110', '0');
INSERT INTO `answer` VALUES ('148', '你或许会问：“那为什么人不会淌一地板的水，就像果子冻那样？”', '111', '110', '0');
INSERT INTO `answer` VALUES ('149', '奥妙在于东西是由什么构成的，其他的倒并不怎么重要', '119', '110', '0');
INSERT INTO `answer` VALUES ('150', '不错，最重要的就是它是由什么构成的', '111', '110', '0');
INSERT INTO `answer` VALUES ('151', '从表面上看来，水是无害的东西', '116', '118', '0');
INSERT INTO `answer` VALUES ('152', '然而，却时常发生这样的事情：水像火药那样爆炸起来', '112', '118', '0');
INSERT INTO `answer` VALUES ('153', '火药算什么！如果你不善于对付水的话，它比火药还要危险二十倍', '117', '118', '0');
INSERT INTO `answer` VALUES ('154', '有一次，水炸毁了一座五层的大楼，二十三人不幸遇难。', '119', '118', '0');
INSERT INTO `answer` VALUES ('155', '这座大楼的底层有一个大锅炉，锅炉里面的水足有一池塘那么多。', '119', '116', '0');
INSERT INTO `answer` VALUES ('156', '锅炉在工作的时候，里面的水沸腾之后，蒸汽便通过管道来到了蒸汽机里面', '114', '116', '0');
INSERT INTO `answer` VALUES ('157', '有一次，锅炉工忘记按时添水了，于是锅炉里面的水就变得越来越少', '113', '116', '0');
INSERT INTO `answer` VALUES ('158', '可炉子这时还在继续燃烧着，炉壁也被烧得通红，可锅炉工却并没有意识到这一点，一下子就把水灌到了烧得通红的锅炉里', '117', '116', '0');
INSERT INTO `answer` VALUES ('159', '可是，你知道的，把水浇到火红的钢铁上会出现什么情况，它会瞬间全部转化为蒸汽', '114', '116', '0');
INSERT INTO `answer` VALUES ('160', '这里也发生了同样的事情，水一下子全都变成了蒸汽，锅炉里面贮存的蒸汽太多了，由于经受不住巨大的压力，所以就炸裂了', '110', '116', '0');
INSERT INTO `answer` VALUES ('161', '此外，德国还发生过更为严重的事故：有一次，二十二个蒸汽锅同时爆炸，把周围的房屋全部炸毁了', '115', '116', '0');
INSERT INTO `answer` VALUES ('162', '蒸汽锅的碎片甚至飞到了距离爆炸地点半公里以外的地方', '118', '116', '0');
INSERT INTO `answer` VALUES ('163', '我问一个孩子：“为什么穿上冰鞋之后也不能在地板上滑行？”', '110', '112', '0');
INSERT INTO `answer` VALUES ('164', '他回答我说：“因为冰又硬又滑，地板却没有那么硬，也不怎么滑。”', '114', '112', '0');
INSERT INTO `answer` VALUES ('165', '可是，你知道的，有一种石板地，也是又硬又滑的，可在这种地面上仍然不能滑行。', '118', '112', '0');
INSERT INTO `answer` VALUES ('166', '当我们溜冰的时候，冰在冰刀的压力下融化了，在冰与冰刀之间出现了一层水', '111', '112', '0');
INSERT INTO `answer` VALUES ('167', '如果没有这层水的话，在冰上滑行就跟在地板上滑行一样困难了', '110', '112', '0');
INSERT INTO `answer` VALUES ('168', '水就如同机器里的润滑剂一样，可以有效地减轻冰刀与冰之间的摩擦', '113', '112', '0');
INSERT INTO `answer` VALUES ('169', '冰川能够从雪山上滑下来，也是这个缘故', '119', '112', '0');
INSERT INTO `answer` VALUES ('170', '在冰的重压之下，它的下层融化了，所以冰川就会顺着山坡滑下来，就像你穿上冰鞋在溜冰场上滑行一样', '114', '112', '0');
INSERT INTO `answer` VALUES ('171', '每个人都会说水是透明的', '117', '119', '0');
INSERT INTO `answer` VALUES ('172', '然而，实际上只有薄层的水才是透明的', '117', '119', '0');
INSERT INTO `answer` VALUES ('173', '海洋的底层是漆黑一团的，因为阳光无法穿透那么厚层的水', '112', '119', '0');
INSERT INTO `answer` VALUES ('174', '而且，并不仅仅只有水是这样——任何物质取一薄层都是透明的，厚层的便不透明了', '118', '119', '0');
INSERT INTO `answer` VALUES ('175', '比方说一块透明无色的玻璃，如果你从它的边缘去观察，这块玻璃也变得不透明无色了', '112', '119', '0');
INSERT INTO `answer` VALUES ('176', '不久之前，一位科学家制作了一块铁片，厚度只有十万分之一毫米', '117', '119', '0');
INSERT INTO `answer` VALUES ('177', '这块铁片便如同玻璃一样透明，并且几乎是完全无色的', '118', '119', '0');
INSERT INTO `answer` VALUES ('178', '把它放在书页上，可以轻而易举地看到最小字号的字', '115', '119', '0');
INSERT INTO `answer` VALUES ('179', '冬天的夜晚，劈柴在炉子里噼啪作响', '112', '115', '0');
INSERT INTO `answer` VALUES ('180', '你看着炉子里的火苗，很容易就想到许许多多奇异的东西，比如说被烈火焚烧的城市和被包围的城堡', '113', '115', '0');
INSERT INTO `answer` VALUES ('181', '劈柴的爆裂声就如同炮火的轰鸣声一样，而火舌就好像是沿着城墙跑的士兵', '117', '115', '0');
INSERT INTO `answer` VALUES ('182', '在古代的时候，人们认为火里面住着掌管火的神灵——火壁虎', '111', '115', '0');
INSERT INTO `answer` VALUES ('183', '也有人认为火本身就是神灵，并且建造庙宇来供奉它', '112', '115', '0');
INSERT INTO `answer` VALUES ('184', '这样的庙宇中点着供奉给火神的灯，几百年都不会熄灭。', '114', '115', '0');
INSERT INTO `answer` VALUES ('185', '在这个世界上，点长明灯是最古老的风俗之一', '119', '115', '0');
INSERT INTO `answer` VALUES ('186', '早在几万年之前，人类还不会取火', '113', '115', '0');
INSERT INTO `answer` VALUES ('187', '实际上，人们不是取火，而是觅火，就如同现代人寻觅宝石一样', '113', '115', '0');
INSERT INTO `answer` VALUES ('188', '这就难怪人们当时珍惜火就像珍惜宝石一样了', '116', '115', '0');
INSERT INTO `answer` VALUES ('189', '假如它熄灭了，就再也没有其他地方可以找到火了', '112', '115', '0');
INSERT INTO `answer` VALUES ('190', '你知道的，人们那时候还不会取火呢', '118', '115', '0');
INSERT INTO `answer` VALUES ('191', '原始人并不具备我们这样的工具。他们既没有锯，也没有刨子。', '119', '112', '0');
INSERT INTO `answer` VALUES ('192', '他们用尖利的石块或骨头来代替锯和刨子', '112', '112', '0');
INSERT INTO `answer` VALUES ('193', '所以，用这样的工具干活是绝对不会轻松的', '117', '112', '0');
INSERT INTO `answer` VALUES ('194', '为了让木头发热并且着起火来，他们不得不长时间地刮着、擦着', '110', '112', '0');
INSERT INTO `answer` VALUES ('195', '或许正是这个方法才让人们想到：摩擦生火', '112', '112', '0');
INSERT INTO `answer` VALUES ('196', '如果想要让木头着起火来，必须先要让它发热得很厉害', '116', '112', '0');
INSERT INTO `answer` VALUES ('197', '由此可见，两根小木棍必须要摩擦很久才行', '110', '112', '0');
INSERT INTO `answer` VALUES ('198', '发明火柴并不是很久以前的事情', '119', '114', '0');
INSERT INTO `answer` VALUES ('199', '1933年，第一家火柴工厂刚好一百岁', '115', '114', '0');
INSERT INTO `answer` VALUES ('200', '在此之前，人们取火都使用其他的方法', '115', '114', '0');
INSERT INTO `answer` VALUES ('201', '一百多年前，人们的口袋里放着的并不是火柴盒，而是一只小盒子，里面装着三样奇怪的东西：一小块钢铁，一块不大的石头和一小块像海绵一样的东西', '116', '114', '0');
INSERT INTO `answer` VALUES ('202', '假如你问这些东西都是什么，他们就会告诉你，那个铁块是火镰，那块石头是火石，而那个像海绵一样的东西则是火绒', '116', '114', '0');
INSERT INTO `answer` VALUES ('203', '这整整一堆东西就相当于一根火柴！', '117', '114', '0');
INSERT INTO `answer` VALUES ('204', '一个衣着华丽的胖家伙，嘴里叼着一根长长的烟管儿', '112', '111', '0');
INSERT INTO `answer` VALUES ('205', '他一只手握着火镰，另一只手拿着火石和火绒', '112', '111', '0');
INSERT INTO `answer` VALUES ('206', '他用火镰去敲击火石', '118', '111', '0');
INSERT INTO `answer` VALUES ('207', '没有任何效果！他又试了一次，火镰上面迸出了火星，可却并没有把火绒点燃', '114', '111', '0');
INSERT INTO `answer` VALUES ('208', '最后，当打到第四次或者第五次的时候，火绒才被点燃了', '116', '111', '0');
INSERT INTO `answer` VALUES ('209', '说句实在话，这就像一个打火机一样', '119', '111', '0');
INSERT INTO `answer` VALUES ('210', '打火机里面也有一块小小的石头，那就是火石；也有一个小小的铁轮，那就是火镰；而那个浸透汽油的灯芯则是火绒', '115', '111', '0');
INSERT INTO `answer` VALUES ('211', '很多物质遇到强热之后就会燃烧，少量物质甚至稍微加热就会着火', '117', '116', '0');
INSERT INTO `answer` VALUES ('212', '可是也有些东西不管你怎么点都不会燃烧', '111', '116', '0');
INSERT INTO `answer` VALUES ('213', '其实，这与灰烬不会燃烧是一样的道理。', '111', '115', '0');
INSERT INTO `answer` VALUES ('214', '氢气，就是用来灌气球和飞艇的那种气体。', '113', '113', '0');
INSERT INTO `answer` VALUES ('215', '当然，现在也可以用另外一种气体来灌飞艇，那就是氦气。', '118', '113', '0');
INSERT INTO `answer` VALUES ('216', '氦气不会燃烧，所以飞艇飞行的时候没有安全隐患。', '114', '113', '0');
INSERT INTO `answer` VALUES ('217', '你从杂物间抱来一捆重重的劈柴，把它们丢在炉子旁边', '112', '119', '0');
INSERT INTO `answer` VALUES ('218', '这捆劈柴又大又结实，散发着香气，好像屋子里搬来了一棵圣诞树一样', '118', '119', '0');
INSERT INTO `answer` VALUES ('219', '把炉子点起火来，过一两个小时，你再来看，那堆劈柴已经不剩什么了', '116', '119', '0');
INSERT INTO `answer` VALUES ('220', '只在地板上留下了一块融雪的痕迹，炉膛内有一小撮灰', '117', '119', '0');

-- ----------------------------
-- Table structure for laberl
-- ----------------------------
DROP TABLE IF EXISTS `laberl`;
CREATE TABLE `laberl` (
  `Id` int(11) NOT NULL auto_increment COMMENT '��ǩ�ı��',
  `name` varchar(255) default NULL COMMENT '��ǩ���ƣ�������ѧ�ࣩ',
  `fa_label` varchar(255) default NULL COMMENT '����ǩ',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laberl
-- ----------------------------
INSERT INTO `laberl` VALUES ('1', '生活', null);
INSERT INTO `laberl` VALUES ('2', '文学', null);
INSERT INTO `laberl` VALUES ('3', '编程', null);
INSERT INTO `laberl` VALUES ('4', '视频', null);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `Id` int(11) NOT NULL auto_increment COMMENT '������',
  `time1` datetime default '0000-00-00 00:00:00' COMMENT '����ʱ��',
  `description` varchar(1000) default '' COMMENT '��������',
  `title` varchar(255) default NULL COMMENT '�������',
  `ariser_id` int(11) default NULL COMMENT '������ID',
  `points` int(10) default '0' COMMENT '���ͷ���',
  `answers` int(11) default NULL COMMENT '�ش���Ŀ',
  `states` int(2) default NULL COMMENT '����״̬',
  `label1` varchar(255) default NULL COMMENT '��ǩ1���ɿգ�',
  `label2` varchar(255) default NULL COMMENT '��ǩ2���ɿգ�',
  `label3` varchar(255) default NULL COMMENT '��ǩ3���ɿգ�',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('21', '2018-07-12 08:46:57', '人们是如何使用肥皂泡的？人们是如何使用肥皂泡的？', '人们是如何使用肥皂泡的？', '110', '16', '7', '1', null, null, null);
INSERT INTO `question` VALUES ('22', '2018-07-11 08:46:58', '肥皂是怎么干这件事情的呢？肥皂是怎么干这件事情的呢？', '肥皂是怎么干这件事情的呢？', '114', '17', '0', '1', null, null, null);
INSERT INTO `question` VALUES ('23', '2018-07-11 08:46:58', '什么样的肥皂更好用一什么样的肥皂更好用一', '什么样的肥皂更好用一', '116', '16', '1', '1', null, null, null);
INSERT INTO `question` VALUES ('24', '2018-07-13 08:46:58', '那么，泡沫又是什么东西呢？那么，泡沫又是什么东西呢？', '那么，泡沫又是什么东西呢？', '115', '12', '12', '0', null, null, null);
INSERT INTO `question` VALUES ('25', '2018-07-13 08:46:59', '我们为什么要喝水？我们为什么要喝水？', '我们为什么要喝水？', '117', '10', '4', '0', null, null, null);
INSERT INTO `question` VALUES ('26', '2018-07-13 08:47:00', '可是，为什么需要呢？可是，为什么需要呢？', '可是，为什么需要呢？', '119', '16', '7', '1', null, null, null);
INSERT INTO `question` VALUES ('27', '2018-07-13 08:47:00', '可是，水难道是可以吃下去的吗？可是，水难道是可以吃下去的吗？', '可是，水难道是可以吃下去的吗？', '110', '14', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('28', '2018-07-13 08:47:01', '水能不能把房屋炸毁？水能不能把房屋炸毁？', '水能不能把房屋炸毁？', '118', '17', '4', '0', null, null, null);
INSERT INTO `question` VALUES ('29', '2018-07-13 08:47:01', '为什么会发生这样的事情呢？为什么会发生这样的事情呢？', '为什么会发生这样的事情呢？', '116', '14', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('30', '2018-07-11 08:47:02', '穿上冰鞋后为什么不能在地板上滑行？穿上冰鞋后为什么不能在地板上滑行？', '穿上冰鞋后为什么不能在地板上滑行？', '112', '19', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('31', '2018-07-11 08:47:02', '存不存在不透明的水和透明的铁？存不存在不透明的水和透明的铁？', '存不存在不透明的水和透明的铁？', '119', '18', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('32', '2018-07-12 08:47:03', '人类从什么时候开始会取火的？人类从什么时候开始会取火的？', '人类从什么时候开始会取火的？', '115', '16', '12', '1', null, null, null);
INSERT INTO `question` VALUES ('33', '2018-07-12 08:47:03', '火柴为什么可以点着火？火柴为什么可以点着火？', '火柴为什么可以点着火？', '112', '17', '7', '1', null, null, null);
INSERT INTO `question` VALUES ('34', '2018-07-12 08:47:04', '火柴是什么时候发明出来的？火柴是什么时候发明出来的？', '火柴是什么时候发明出来的？', '114', '13', '6', '1', null, null, null);
INSERT INTO `question` VALUES ('35', '2018-07-12 08:47:04', '那个时候究竟是怎样取火的呢？那个时候究竟是怎样取火的呢？', '那个时候究竟是怎样取火的呢？', '111', '17', '7', '1', null, null, null);
INSERT INTO `question` VALUES ('36', '2018-07-11 08:47:05', '为什么水无法燃烧？为什么水无法燃烧？', '为什么水无法燃烧？', '116', '12', '2', '1', null, null, null);
INSERT INTO `question` VALUES ('37', '2018-07-11 08:47:05', '你想知道为什么会这样吗？你想知道为什么会这样吗？', '你想知道为什么会这样吗？', '115', '11', '1', '0', null, null, null);
INSERT INTO `question` VALUES ('38', '2018-07-11 08:47:05', '要想得到水，需要用什么东西来进行燃烧呢？要想得到水，需要用什么东西来进行燃烧呢？', '要想得到水，需要用什么东西来进行燃烧呢？', '113', '11', '3', '1', null, null, null);
INSERT INTO `question` VALUES ('39', '2018-07-12 08:47:05', '炉子燃烧过后，劈柴到什么地方去了？炉子燃烧过后，劈柴到什么地方去了？', '炉子燃烧过后，劈柴到什么地方去了？', '119', '10', '4', '0', null, null, null);
INSERT INTO `question` VALUES ('40', '2018-07-11 08:47:06', '这捆劈柴跑到什么地方去了呢？这捆劈柴跑到什么地方去了呢？', '这捆劈柴跑到什么地方去了呢？', '119', '14', '0', '0', null, null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `Id` int(11) NOT NULL auto_increment COMMENT '��Դ���',
  `title` varchar(255) default NULL COMMENT '��Դ����',
  `description` varchar(1000) default NULL COMMENT '��Դ����',
  `format` varchar(255) default NULL COMMENT '��Դ��ʽ',
  `address` varchar(255) default NULL COMMENT '��Դ�ڷ������ϵĵ�ַ',
  `provider_id` int(11) default NULL COMMENT '��Դ�ṩ��id',
  `type` varchar(255) default NULL COMMENT '�ϴ���Դ������',
  `point` int(11) default '0' COMMENT '������Դ�Ļ���',
  `date` datetime default NULL COMMENT '��Դ�ϴ�ʱ��',
  `download_times` int(11) default '0' COMMENT '��Դ���صĴ���',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '某文件A', '这是一个测试文件', 'TXT', 'a.txt', '101', '编程', '10', '2018-07-12 15:05:45', '5');
INSERT INTO `resource` VALUES ('2', 'B', 'BB', 'AVI', 'b.avi', '101', '视频', '5', '2018-07-13 15:06:43', '3');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL auto_increment COMMENT '�û����',
  `user_name` varchar(40) default NULL COMMENT '�û�����������20�����֣�',
  `password` varchar(50) NOT NULL default '123456' COMMENT '�û����루6-24λ��',
  `gender` varchar(255) NOT NULL default 'MALE' COMMENT '�Ա�',
  `email` varchar(50) default NULL COMMENT '�û�����',
  `type` varchar(10) default 'STUDENT' COMMENT '�û���ݣ�ѧ������ʦ��',
  `reg_time` datetime default '0000-00-00 00:00:00' COMMENT 'ע��ʱ��',
  `credit` int(10) default '0' COMMENT '�û�������',
  `states` datetime default NULL COMMENT '�û�����ʱ��',
  `rank` int(2) default NULL COMMENT '�û�Ȩ�ޣ��ǲ��ǹ���Ա��',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('101', 'bba', '90af80', 'MALE', '66666@163.com', 'TEACHER', '2018-07-01 10:16:20', '20', '2018-07-06 10:16:20', null);
INSERT INTO `user` VALUES ('102', '6cfc81', '6cfc81', 'MALE', '6cfc81@163.com', 'STUDENT', '2018-07-01 10:16:20', '20', '2018-07-06 10:16:20', null);
INSERT INTO `user` VALUES ('103', 'c6e972', 'c6e972', 'MALE', 'c6e972@163.com', 'STUDENT', '2018-07-01 10:16:20', '20', '2018-07-06 10:16:20', null);
INSERT INTO `user` VALUES ('104', '057f93', '057f93', 'MALE', '057f93@163.com', 'STUDENT', '2018-07-01 10:16:20', '20', '2018-07-06 10:16:20', null);
INSERT INTO `user` VALUES ('105', '410294', '410294', 'MALE', '410294@163.com', 'STUDENT', '2018-07-01 10:16:21', '20', '2018-07-06 10:16:21', null);
INSERT INTO `user` VALUES ('106', '422b45', '422b45', 'MALE', '422b45@163.com', 'TEACHER', '2018-07-01 10:16:21', '20', '2018-07-21 10:16:21', null);
INSERT INTO `user` VALUES ('107', 'f97fb6', 'f97fb6', 'MALE', 'f97fb6@163.com', 'STUDENT', '2018-07-01 10:16:21', '20', '2018-07-06 10:16:21', null);
INSERT INTO `user` VALUES ('108', 'a6b597', 'a6b597', 'FEMALE', 'a6b597@163.com', 'STUDENT', '2018-07-01 10:16:21', '20', '2018-07-21 10:16:21', null);
INSERT INTO `user` VALUES ('109', 'dd2358', 'dd2358', 'MALE', 'dd2358@163.com', 'STUDENT', '2018-07-01 10:16:21', '20', '2018-07-06 10:16:21', null);
INSERT INTO `user` VALUES ('110', '54c739', '54c739', 'FEMALE', '54c739@163.com', 'STUDENT', '2018-07-01 10:16:21', '20', '2018-07-21 10:16:21', null);
INSERT INTO `user` VALUES ('112', '7777', '123456', 'FEMALE', '1101@126.com', 'TEACHER', '2018-07-11 14:20:36', null, null, null);
INSERT INTO `user` VALUES ('113', '6c1d50', '6c1d50', 'FEMALE', '6c1d50@163.com', 'STUDENT', '2018-07-01 22:20:58', '20', '2018-07-06 22:20:58', null);
INSERT INTO `user` VALUES ('114', '811f51', '811f51', 'MALE', '811f51@163.com', 'TEACHER', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('115', '44c202', '44c202', 'FEMALE', '44c202@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('116', 'b259f3', 'b259f3', 'MALE', 'b259f3@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('117', 'f24d64', 'f24d64', 'MALE', 'f24d64@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('118', '43efd5', '43efd5', 'MALE', '43efd5@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('119', '9e3636', '9e3636', 'FEMALE', '9e3636@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('120', '4314a7', '4314a7', 'FEMALE', '4314a7@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('121', '608b68', '608b68', 'MALE', '608b68@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('122', '029979', '029979', 'MALE', '029979@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('123', '15bb310', '15bb310', 'FEMALE', '15bb310@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('124', 'b417411', 'b417411', 'MALE', 'b417411@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('125', '8cf6812', '8cf6812', 'FEMALE', '8cf6812@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('126', 'fc47413', 'fc47413', 'FEMALE', 'fc47413@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('127', '93b6914', '93b6914', 'MALE', '93b6914@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('128', '41c7d15', '41c7d15', 'MALE', '41c7d15@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('129', '2d4b116', '2d4b116', 'MALE', '2d4b116@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('130', 'e110d17', 'e110d17', 'FEMALE', 'e110d17@163.com', 'TEACHER', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('131', 'c107318', 'c107318', 'MALE', 'c107318@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('132', 'cd4b619', 'cd4b619', 'FEMALE', 'cd4b619@163.com', 'TEACHER', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('133', '71d2f20', '71d2f20', 'MALE', '71d2f20@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-06 22:20:59', null);
INSERT INTO `user` VALUES ('134', '54e4621', '54e4621', 'MALE', '54e4621@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('135', 'f047422', 'f047422', 'MALE', 'f047422@163.com', 'STUDENT', '2018-07-01 22:20:59', '20', '2018-07-21 22:20:59', null);
INSERT INTO `user` VALUES ('136', 'def1b23', 'def1b23', 'MALE', 'def1b23@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-21 22:21:00', null);
INSERT INTO `user` VALUES ('137', 'bb61724', 'bb61724', 'MALE', 'bb61724@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('138', 'c748c25', 'c748c25', 'FEMALE', 'c748c25@163.com', 'TEACHER', '2018-07-01 22:21:00', '20', '2018-07-21 22:21:00', null);
INSERT INTO `user` VALUES ('139', '78cdc26', '78cdc26', 'MALE', '78cdc26@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('140', '0a32e27', '0a32e27', 'FEMALE', '0a32e27@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('141', '1893a28', '1893a28', 'MALE', '1893a28@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-21 22:21:00', null);
INSERT INTO `user` VALUES ('142', '4210e29', '4210e29', 'FEMALE', '4210e29@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-21 22:21:00', null);
INSERT INTO `user` VALUES ('143', '38d2830', '38d2830', 'MALE', '38d2830@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('144', 'f20d931', 'f20d931', 'FEMALE', 'f20d931@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-21 22:21:00', null);
INSERT INTO `user` VALUES ('145', '82acd32', '82acd32', 'FEMALE', '82acd32@163.com', 'TEACHER', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('146', '8488433', '8488433', 'MALE', '8488433@163.com', 'STUDENT', '2018-07-01 22:21:00', '20', '2018-07-06 22:21:00', null);
INSERT INTO `user` VALUES ('147', 'e263534', 'e263534', 'FEMALE', 'e263534@163.com', 'STUDENT', '2018-07-01 22:21:01', '20', '2018-07-06 22:21:01', null);
INSERT INTO `user` VALUES ('148', '78a5235', '78a5235', 'FEMALE', '78a5235@163.com', 'STUDENT', '2018-07-01 22:21:01', '20', '2018-07-21 22:21:01', null);
INSERT INTO `user` VALUES ('149', '8714b36', '8714b36', 'FEMALE', '8714b36@163.com', 'STUDENT', '2018-07-01 22:21:01', '20', '2018-07-06 22:21:01', null);
INSERT INTO `user` VALUES ('150', '7516437', '7516437', 'MALE', '7516437@163.com', 'STUDENT', '2018-07-01 22:21:01', '20', '2018-07-21 22:21:01', null);
