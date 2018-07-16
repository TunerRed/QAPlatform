/*
Navicat MySQL Data Transfer

Source Server         : LocalConnection
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : qasite

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2018-07-16 08:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `Id` int(11) NOT NULL auto_increment,
  `content` varchar(1000) default '',
  `replier_id` int(11) default NULL,
  `question_id` int(11) default NULL,
  `state` int(11) default '0',
  `time1` datetime NOT NULL default '2018-01-01 00:00:00',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '我们忘了一件重要的东西，如果没有它的话，我们就洗什么东西都洗不干净', '118', '1', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('2', '那么，这究竟是什么东西呢？', '111', '1', '0', '2018-07-14 20:54:52');
INSERT INTO `answer` VALUES ('3', '如果我们洗衣服或者洗澡的时候不使用肥皂，那总归是洗不干净的', '112', '1', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('4', '对于污垢来说，肥皂是它们的天敌', '112', '1', '0', '2018-07-15 20:54:52');
INSERT INTO `answer` VALUES ('5', '就比如说烟炱吧，它就特别难清洗掉', '111', '1', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('6', '烟炱是十分微小的炭粒，它的边缘凹凸不平', '118', '1', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('7', '如果这样的小炭粒落在皮肤的凹纹里，就很难把它弄出来了', '117', '1', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('8', '当然是泡沫多的好用。由此可见，肥皂好不好用的关键在于泡沫。', '116', '3', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('9', '你仔细地观察它一下', '112', '4', '0', '2018-07-16 20:54:52');
INSERT INTO `answer` VALUES ('10', '它全部都是由小肥皂泡组成的，外面是包着一层水膜的小空气球', '117', '4', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('11', '把烟炱抓住并带走的正是这些泡泡', '113', '4', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('12', '烟炱的小颗粒沾在这些泡沫的泡泡上，要想把它们冲走就不难了', '112', '4', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('13', '工厂把矿物从废石里面洗出来用的也是这种方法', '110', '4', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('14', '矿物和废石在水中都是会下沉的', '113', '4', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('15', '可是，假如把它们磨碎了，放在泡沫里，它们就不会下沉了', '112', '4', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('16', '不要小看那些小泡泡，它们有着很强的力量，可以把矿物和废石的小颗粒全都带到上面来', '115', '4', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('17', '这个时候，选择就开始了', '118', '4', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('18', '由于废石的颗粒无法长时间沾在泡泡上，所以就会沉到桶底去', '115', '4', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('19', '而矿物的颗粒却不会下沉', '117', '4', '0', '2018-07-14 20:54:53');
INSERT INTO `answer` VALUES ('20', '这样一来，桶的表面就会漂浮着一层矿物，那就很容易撇出来了', '110', '4', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('21', '这又是一个简单得不能再简单的问题了', '110', '5', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('22', '问题如此简单，就好像不需要问一样', '115', '5', '0', '2018-07-16 20:54:53');
INSERT INTO `answer` VALUES ('23', '可是，一旦提出这个问题，十个人当中只有一个人知道我们为什么要喝水', '115', '5', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('24', '你会回答：我们喝水，那是因为我们需要水。', '115', '5', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('25', '人活着就要一刻不停地饮水，补充水分是人体必需的。', '116', '6', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('26', '你呵一口气到冰冷的玻璃上，玻璃就会模糊，上面布满了小水滴。', '111', '6', '0', '2018-07-15 20:54:53');
INSERT INTO `answer` VALUES ('27', '那么，这些水滴是从哪里来的呢？是从你身体里来的。', '119', '6', '0', '2018-07-14 20:54:53');
INSERT INTO `answer` VALUES ('28', '另外，天热的时候，你的身体会出汗。汗液是从哪里来的呢？也是你的身体。', '117', '6', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('29', '既然你一直在消耗水和流失水，所以你就应该随时去补充它', '118', '6', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('30', '一个人在24小时之内会流失掉整整12杯水', '114', '6', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('31', '所以，他至少应该喝下或者吃下这么多的水', '111', '6', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('32', '在肉里、蔬菜里、面包里——在任何一种食物中，水分都要比固体物质多得多', '117', '7', '0', '2018-07-16 20:54:54');
INSERT INTO `answer` VALUES ('33', '肉里面的水分要比固体物质多一倍，而黄瓜里几乎全都是水分', '111', '7', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('34', '再来说说你身体里的水分吧，它和新鲜黄瓜里所含的水分几乎一样多', '115', '7', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('35', '假如你的体重是40千克，那么其中的35千克都是水分，而固体物质只有5千克', '114', '7', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('36', '成人的身体中所含的水分要少一些，大约是体重的四分之三。', '110', '7', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('37', '你或许会问：“那为什么人不会淌一地板的水，就像果子冻那样？”', '112', '7', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('38', '奥妙在于东西是由什么构成的，其他的倒并不怎么重要', '110', '7', '0', '2018-07-16 20:54:54');
INSERT INTO `answer` VALUES ('39', '不错，最重要的就是它是由什么构成的', '113', '7', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('40', '从表面上看来，水是无害的东西', '110', '8', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('41', '然而，却时常发生这样的事情：水像火药那样爆炸起来', '113', '8', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('42', '火药算什么！如果你不善于对付水的话，它比火药还要危险二十倍', '110', '8', '0', '2018-07-14 20:54:54');
INSERT INTO `answer` VALUES ('43', '有一次，水炸毁了一座五层的大楼，二十三人不幸遇难。', '111', '8', '0', '2018-07-15 20:54:54');
INSERT INTO `answer` VALUES ('44', '这座大楼的底层有一个大锅炉，锅炉里面的水足有一池塘那么多。', '113', '9', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('45', '锅炉在工作的时候，里面的水沸腾之后，蒸汽便通过管道来到了蒸汽机里面', '110', '9', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('46', '有一次，锅炉工忘记按时添水了，于是锅炉里面的水就变得越来越少', '113', '9', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('47', '可炉子这时还在继续燃烧着，炉壁也被烧得通红，可锅炉工却并没有意识到这一点，一下子就把水灌到了烧得通红的锅炉里', '119', '9', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('48', '可是，你知道的，把水浇到火红的钢铁上会出现什么情况，它会瞬间全部转化为蒸汽', '112', '9', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('49', '这里也发生了同样的事情，水一下子全都变成了蒸汽，锅炉里面贮存的蒸汽太多了，由于经受不住巨大的压力，所以就炸裂了', '115', '9', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('50', '此外，德国还发生过更为严重的事故：有一次，二十二个蒸汽锅同时爆炸，把周围的房屋全部炸毁了', '119', '9', '0', '2018-07-15 20:54:55');
INSERT INTO `answer` VALUES ('51', '蒸汽锅的碎片甚至飞到了距离爆炸地点半公里以外的地方', '111', '9', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('52', '我问一个孩子：“为什么穿上冰鞋之后也不能在地板上滑行？”', '114', '10', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('53', '他回答我说：“因为冰又硬又滑，地板却没有那么硬，也不怎么滑。”', '110', '10', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('54', '可是，你知道的，有一种石板地，也是又硬又滑的，可在这种地面上仍然不能滑行。', '119', '10', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('55', '当我们溜冰的时候，冰在冰刀的压力下融化了，在冰与冰刀之间出现了一层水', '111', '10', '0', '2018-07-15 20:54:55');
INSERT INTO `answer` VALUES ('56', '如果没有这层水的话，在冰上滑行就跟在地板上滑行一样困难了', '117', '10', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('57', '水就如同机器里的润滑剂一样，可以有效地减轻冰刀与冰之间的摩擦', '115', '10', '0', '2018-07-15 20:54:55');
INSERT INTO `answer` VALUES ('58', '冰川能够从雪山上滑下来，也是这个缘故', '118', '10', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('59', '在冰的重压之下，它的下层融化了，所以冰川就会顺着山坡滑下来，就像你穿上冰鞋在溜冰场上滑行一样', '115', '10', '0', '2018-07-16 20:54:55');
INSERT INTO `answer` VALUES ('60', '每个人都会说水是透明的', '111', '11', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('61', '然而，实际上只有薄层的水才是透明的', '112', '11', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('62', '海洋的底层是漆黑一团的，因为阳光无法穿透那么厚层的水', '111', '11', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('63', '而且，并不仅仅只有水是这样——任何物质取一薄层都是透明的，厚层的便不透明了', '115', '11', '0', '2018-07-15 20:54:55');
INSERT INTO `answer` VALUES ('64', '比方说一块透明无色的玻璃，如果你从它的边缘去观察，这块玻璃也变得不透明无色了', '113', '11', '0', '2018-07-14 20:54:55');
INSERT INTO `answer` VALUES ('65', '不久之前，一位科学家制作了一块铁片，厚度只有十万分之一毫米', '119', '11', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('66', '这块铁片便如同玻璃一样透明，并且几乎是完全无色的', '111', '11', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('67', '把它放在书页上，可以轻而易举地看到最小字号的字', '118', '11', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('68', '冬天的夜晚，劈柴在炉子里噼啪作响', '117', '12', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('69', '你看着炉子里的火苗，很容易就想到许许多多奇异的东西，比如说被烈火焚烧的城市和被包围的城堡', '113', '12', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('70', '劈柴的爆裂声就如同炮火的轰鸣声一样，而火舌就好像是沿着城墙跑的士兵', '117', '12', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('71', '在古代的时候，人们认为火里面住着掌管火的神灵——火壁虎', '110', '12', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('72', '也有人认为火本身就是神灵，并且建造庙宇来供奉它', '110', '12', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('73', '这样的庙宇中点着供奉给火神的灯，几百年都不会熄灭。', '115', '12', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('74', '在这个世界上，点长明灯是最古老的风俗之一', '115', '12', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('75', '早在几万年之前，人类还不会取火', '113', '12', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('76', '实际上，人们不是取火，而是觅火，就如同现代人寻觅宝石一样', '119', '12', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('77', '这就难怪人们当时珍惜火就像珍惜宝石一样了', '112', '12', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('78', '假如它熄灭了，就再也没有其他地方可以找到火了', '115', '12', '0', '2018-07-14 20:54:56');
INSERT INTO `answer` VALUES ('79', '你知道的，人们那时候还不会取火呢', '112', '12', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('80', '原始人并不具备我们这样的工具。他们既没有锯，也没有刨子。', '114', '13', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('81', '他们用尖利的石块或骨头来代替锯和刨子', '118', '13', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('82', '所以，用这样的工具干活是绝对不会轻松的', '116', '13', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('83', '为了让木头发热并且着起火来，他们不得不长时间地刮着、擦着', '114', '13', '0', '2018-07-15 20:54:56');
INSERT INTO `answer` VALUES ('84', '或许正是这个方法才让人们想到：摩擦生火', '119', '13', '0', '2018-07-16 20:54:56');
INSERT INTO `answer` VALUES ('85', '如果想要让木头着起火来，必须先要让它发热得很厉害', '112', '13', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('86', '由此可见，两根小木棍必须要摩擦很久才行', '110', '13', '0', '2018-07-14 20:54:57');
INSERT INTO `answer` VALUES ('87', '发明火柴并不是很久以前的事情', '115', '14', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('88', '1933年，第一家火柴工厂刚好一百岁', '117', '14', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('89', '在此之前，人们取火都使用其他的方法', '110', '14', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('90', '一百多年前，人们的口袋里放着的并不是火柴盒，而是一只小盒子，里面装着三样奇怪的东西：一小块钢铁，一块不大的石头和一小块像海绵一样的东西', '113', '14', '0', '2018-07-14 20:54:57');
INSERT INTO `answer` VALUES ('91', '假如你问这些东西都是什么，他们就会告诉你，那个铁块是火镰，那块石头是火石，而那个像海绵一样的东西则是火绒', '117', '14', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('92', '这整整一堆东西就相当于一根火柴！', '112', '14', '0', '2018-07-16 20:54:57');
INSERT INTO `answer` VALUES ('93', '一个衣着华丽的胖家伙，嘴里叼着一根长长的烟管儿', '110', '15', '0', '2018-07-16 20:54:57');
INSERT INTO `answer` VALUES ('94', '他一只手握着火镰，另一只手拿着火石和火绒', '111', '15', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('95', '他用火镰去敲击火石', '112', '15', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('96', '没有任何效果！他又试了一次，火镰上面迸出了火星，可却并没有把火绒点燃', '114', '15', '0', '2018-07-15 20:54:57');
INSERT INTO `answer` VALUES ('97', '最后，当打到第四次或者第五次的时候，火绒才被点燃了', '119', '15', '0', '2018-07-16 20:54:57');
INSERT INTO `answer` VALUES ('98', '说句实在话，这就像一个打火机一样', '114', '15', '0', '2018-07-14 20:54:57');
INSERT INTO `answer` VALUES ('99', '打火机里面也有一块小小的石头，那就是火石；也有一个小小的铁轮，那就是火镰；而那个浸透汽油的灯芯则是火绒', '110', '15', '0', '2018-07-14 20:54:57');
INSERT INTO `answer` VALUES ('100', '很多物质遇到强热之后就会燃烧，少量物质甚至稍微加热就会着火', '114', '16', '0', '2018-07-14 20:54:58');
INSERT INTO `answer` VALUES ('101', '可是也有些东西不管你怎么点都不会燃烧', '110', '16', '0', '2018-07-15 20:54:58');
INSERT INTO `answer` VALUES ('102', '其实，这与灰烬不会燃烧是一样的道理。', '111', '17', '0', '2018-07-16 20:54:58');
INSERT INTO `answer` VALUES ('103', '氢气，就是用来灌气球和飞艇的那种气体。', '118', '18', '0', '2018-07-14 20:54:58');
INSERT INTO `answer` VALUES ('104', '当然，现在也可以用另外一种气体来灌飞艇，那就是氦气。', '116', '18', '0', '2018-07-14 20:54:58');
INSERT INTO `answer` VALUES ('105', '氦气不会燃烧，所以飞艇飞行的时候没有安全隐患。', '110', '18', '0', '2018-07-14 20:54:58');
INSERT INTO `answer` VALUES ('106', '你从杂物间抱来一捆重重的劈柴，把它们丢在炉子旁边', '115', '19', '0', '2018-07-16 20:54:58');
INSERT INTO `answer` VALUES ('107', '这捆劈柴又大又结实，散发着香气，好像屋子里搬来了一棵圣诞树一样', '114', '19', '0', '2018-07-14 20:54:58');
INSERT INTO `answer` VALUES ('108', '把炉子点起火来，过一两个小时，你再来看，那堆劈柴已经不剩什么了', '117', '19', '0', '2018-07-15 20:54:58');
INSERT INTO `answer` VALUES ('109', '只在地板上留下了一块融雪的痕迹，炉膛内有一小撮灰', '110', '19', '0', '2018-07-16 20:54:58');

-- ----------------------------
-- Table structure for laberl
-- ----------------------------
DROP TABLE IF EXISTS `laberl`;
CREATE TABLE `laberl` (
  `Id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default 'new type',
  `fa_label` varchar(255) default NULL,
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
  `Id` int(11) NOT NULL auto_increment,
  `time1` datetime default '2018-01-01 00:00:00',
  `description` varchar(1000) default '',
  `title` varchar(255) default NULL,
  `ariser_id` int(11) default NULL,
  `points` int(10) default '0',
  `answers` int(11) default '0',
  `states` int(2) default '0',
  `label1` varchar(255) default NULL,
  `label2` varchar(255) default NULL,
  `label3` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '2018-07-18 20:54:51', '人们是如何使用肥皂泡的？人们是如何使用肥皂泡的？', '人们是如何使用肥皂泡的？', '116', '19', '7', '1', null, null, null);
INSERT INTO `question` VALUES ('2', '2018-07-16 20:54:52', '肥皂是怎么干这件事情的呢？肥皂是怎么干这件事情的呢？', '肥皂是怎么干这件事情的呢？', '117', '17', '0', '1', null, null, null);
INSERT INTO `question` VALUES ('3', '2018-07-18 20:54:52', '什么样的肥皂更好用一什么样的肥皂更好用一', '什么样的肥皂更好用一', '111', '13', '1', '1', null, null, null);
INSERT INTO `question` VALUES ('4', '2018-07-16 20:54:52', '那么，泡沫又是什么东西呢？那么，泡沫又是什么东西呢？', '那么，泡沫又是什么东西呢？', '110', '13', '12', '1', null, null, null);
INSERT INTO `question` VALUES ('5', '2018-07-18 20:54:53', '我们为什么要喝水？我们为什么要喝水？', '我们为什么要喝水？', '111', '10', '4', '0', null, null, null);
INSERT INTO `question` VALUES ('6', '2018-07-17 20:54:53', '可是，为什么需要呢？可是，为什么需要呢？', '可是，为什么需要呢？', '114', '14', '7', '0', null, null, null);
INSERT INTO `question` VALUES ('7', '2018-07-16 20:54:54', '可是，水难道是可以吃下去的吗？可是，水难道是可以吃下去的吗？', '可是，水难道是可以吃下去的吗？', '110', '11', '8', '1', null, null, null);
INSERT INTO `question` VALUES ('8', '2018-07-18 20:54:54', '水能不能把房屋炸毁？水能不能把房屋炸毁？', '水能不能把房屋炸毁？', '114', '15', '4', '1', null, null, null);
INSERT INTO `question` VALUES ('9', '2018-07-18 20:54:54', '为什么会发生这样的事情呢？为什么会发生这样的事情呢？', '为什么会发生这样的事情呢？', '116', '10', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('10', '2018-07-16 20:54:55', '穿上冰鞋后为什么不能在地板上滑行？穿上冰鞋后为什么不能在地板上滑行？', '穿上冰鞋后为什么不能在地板上滑行？', '110', '17', '8', '0', null, null, null);
INSERT INTO `question` VALUES ('11', '2018-07-18 20:54:55', '存不存在不透明的水和透明的铁？存不存在不透明的水和透明的铁？', '存不存在不透明的水和透明的铁？', '111', '17', '8', '1', null, null, null);
INSERT INTO `question` VALUES ('12', '2018-07-18 20:54:56', '人类从什么时候开始会取火的？人类从什么时候开始会取火的？', '人类从什么时候开始会取火的？', '113', '11', '12', '0', null, null, null);
INSERT INTO `question` VALUES ('13', '2018-07-18 20:54:56', '火柴为什么可以点着火？火柴为什么可以点着火？', '火柴为什么可以点着火？', '112', '19', '7', '0', null, null, null);
INSERT INTO `question` VALUES ('14', '2018-07-18 20:54:57', '火柴是什么时候发明出来的？火柴是什么时候发明出来的？', '火柴是什么时候发明出来的？', '111', '16', '6', '1', null, null, null);
INSERT INTO `question` VALUES ('15', '2018-07-16 20:54:57', '那个时候究竟是怎样取火的呢？那个时候究竟是怎样取火的呢？', '那个时候究竟是怎样取火的呢？', '118', '13', '7', '0', null, null, null);
INSERT INTO `question` VALUES ('16', '2018-07-17 20:54:58', '为什么水无法燃烧？为什么水无法燃烧？', '为什么水无法燃烧？', '112', '10', '2', '1', null, null, null);
INSERT INTO `question` VALUES ('17', '2018-07-16 20:54:58', '你想知道为什么会这样吗？你想知道为什么会这样吗？', '你想知道为什么会这样吗？', '117', '19', '1', '1', null, null, null);
INSERT INTO `question` VALUES ('18', '2018-07-17 20:54:58', '要想得到水，需要用什么东西来进行燃烧呢？要想得到水，需要用什么东西来进行燃烧呢？', '要想得到水，需要用什么东西来进行燃烧呢？', '118', '12', '3', '1', null, null, null);
INSERT INTO `question` VALUES ('19', '2018-07-16 20:54:58', '炉子燃烧过后，劈柴到什么地方去了？炉子燃烧过后，劈柴到什么地方去了？', '炉子燃烧过后，劈柴到什么地方去了？', '111', '15', '4', '0', null, null, null);
INSERT INTO `question` VALUES ('20', '2018-07-18 20:54:58', '这捆劈柴跑到什么地方去了呢？这捆劈柴跑到什么地方去了呢？', '这捆劈柴跑到什么地方去了呢？', '114', '17', '0', '1', null, null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `description` varchar(1000) default NULL,
  `format` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `provider_id` int(11) default NULL,
  `type` varchar(255) default NULL,
  `point` int(11) default '0',
  `date` datetime default '2018-01-01 00:00:00',
  `download_times` int(11) default '0',
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
  `Id` int(11) NOT NULL auto_increment,
  `user_name` varchar(40) default NULL,
  `password` varchar(50) NOT NULL default '123456',
  `gender` varchar(255) NOT NULL default 'MALE',
  `email` varchar(50) default NULL,
  `type` varchar(10) default 'STUDENT',
  `reg_time` datetime default '2018-01-01 00:00:00',
  `credit` int(10) default '20',
  `states` datetime default NULL,
  `rank` int(2) default NULL,
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
INSERT INTO `user` VALUES ('111', 'aaaaa', 'aaaaa', 'MALE', 'aaaaa@163.com', 'STUDENT', '2018-07-12 20:59:25', '10', '2018-06-26 20:59:36', '1');
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
