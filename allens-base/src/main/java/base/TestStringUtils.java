package base;

import org.apache.commons.lang.StringUtils;

public class TestStringUtils {

    public static void main(String[] args) {
        String a = "中国农业银行深圳华南城支行,黄娟娟 中国银行莆田市石庭支行,张忠炎 中国农业银行广州美博城支行,戴吉昌 交通银行-上海青浦支行,宋德锋 宁波农行,黄四菊招商银行深圳分行地铁大厦支行,中国农业银行深圳市分行,张松炜 中国银行,宋飞亚 工商银行,周青雅 上海浦东发展银行,许梅宁 中国银行秦皇岛市长江道支行,戴日荣 徽商银行南山支行,王建平 农行常州星港支行,朱文静 招商银行深圳分行文锦渡支行,徐迎华 青岛银行浙江路支行,王明强 北京银行（济南历城支行）,杨剑萍 中国银行福州福屿支行,牛云辉 深圳招商银行文锦渡支行,李玉妹-中国工商银行-瑞安塘下支行,吴超超 --宁波银行,邱妙玲中国银行,马国旭---农业银行,张拱照-建行珠海市三灶支行,王品-农村商业银行,许晓敏,贝如意-招行银行深圳松岗支行,工商银行上海分行昆明路支行,周丹红深圳分行文锦渡支行,黄文海-中国银行广州番禺龙穴岛支行,金洁-中国银行,邱林慧 招商银行百丈支行,巴明 武汉市汉口火车站支行 农业银行,何光 中国银行,招商银行 郭芯言,邱小锐-中国工商银行珠海御景支行,牛和成 农行芦潮港支行,邹爱茗 招商银行深圳前海分行,周旭龙 中信银行,刘慧青 招商银行,梁金连 从化支行招商银行,吴翠银 中国银行深圳龙华支行营业部,梁钱幸 工行开平市水口二支行,雷杰--中国银行,杨浩 中国农业银行合肥龙岗支行,王丹丹 农业银行,周金湖 中国银行,毛芳 招商银行,中国建设银行,范小彬 中国农业银行惠州三环支行,中国银行福州融侨锦江支行,芦秀莲中国银行禹城支行,刘泽驹 中国工商银行东莞厚街支行,陈瑞莲 招商银行东莞营业部,建行深圳分行,陈佳莹招商银行,邱培彬-中国银行广东省潮州市枫溪支行,李剑涛中国银行深圳文锦渡支行,朱国利 中国农业银行,刘晓丽----招商银行,雷娟娟---中国农业银行义乌分行,林邦伟 工行潮州分行营业部,毕研问中国农业银行股份有限公司青岛黄河中路支行,中国银行,徐大伟 中国农业银行济南软件园分理处,李路桢 中国银行宁波滨江支行,张宜瑜-中国银行深圳分行文锦渡支行,陈小凤 中国银行,农行 深圳市莲塘支行,李真---建行德州经济开发支行,黄晓云-陈书各私账中国农业银行古镇华廷支行,陈佳-中国建设银行宁波鄞州支行,詹勋杰 招商银行,中国农业银行佛山市南海区九江青平支行,肖哲-中国银行 深圳布吉支行,郑嘉明-农业银行 海曙解放支行,刘倩兰山区农村合作银行(南坊支行),谢清清-招商银行广州淘金支行,冷雪霜 中国农业银行，广东省东莞市厚街桥头仙桥分理处,李成标 中国农业银行西樵支行,招商银行 邓利群,李佳婷 招商银行,徐涛 招行一卡通,李爽 邮政银行,权风生--中国农业银行临清支行,厦门市嘉林 招商银行青岛分行市南支行,廖先贵-招商银行上海外高桥保税区支行,柴金坤 中国民生银行,陈群锋 建行厦门湖里支行,农业银行,中国银行,卢宇玲 中国银行,招商银行---颜金强,中国农业银行广州增城福和支行,建设银行青岛市南支行---杨凯,颜冰璐 中国银行,杨双微--中国农业银行,工商银行,招商银行,胡柳艳 中国银行,谢彩云-中国银行,刘华中国银行罗湖支行,梁健槐 中国工商银行江门江华支行,黄晓云中国银行,招商银行深圳文锦渡支行 孙丽琴,雷绍忠 中国农业银行浦江城西支行,李少兵-中国银行,苏银萍 中国银行南春支行（广东省潮州市）,张文高 中国民生银行股份有限公司成都双流支行,黄代照 宁波农行彩虹支行,工商银行八卦岭支行,李维燕 中国建设银行上海黄渡支行,苏樟忠 工商银行,张凯 中国农业银行,朱嬿 工商银行,中国建设银行宁波鄞州支行,黄秀丰中国银行深圳市分行,陈少雄 中国银行珠海朝阳支行,江苏常熟农村商业银行股份有限公司营业部,陈明良-中国农业银行义乌解放支行,中信银行荔湾支行,农业银行,邬婷婷 中国银行 东山支行,张超 中国农业银行,余海浪 中国银行 文锦渡支行,中国银行 蔡艳,中国银行上海莘松支行,王志远建设银行宁波支行,中国银行阳江市石湾路支行,黄丽芝 光大银行，广东省广州市天河区东圃支行,中国农行---宜春经济开发区支行,宛闪耀--中国银行文锦渡支行,广州新市支行,华夏银行青岛江山南路支行,赵华华 招商银行深圳市东门支行,中国银行天津宾水道支行,王卫平 浙江温岭农村合作银行箬横支行,中国银行,鲁小毛 招商银行文锦渡支行,钟莹莹-中国银行深圳市龙华支行,章军玲-中国建设银行 芝英支行,谢宁-宁波银行江北支行 招商银行,杨炜镔 中国银行广州番禺支行,广州城西支行,李政 中国银行广州市东园支行,王焕 中国工商银行,林怡柔-中国工商银行股份有限公司汕头达濠支行,程伟-招商银行上海分行东大名支行,胡剑莉 招行,叶云燕 中国工商银行,平安银行 黄革清,詹锦湖 中国银行 深圳东乐支行,中国工商银行肇庆鼎湖支行,高雪招商银行南城支行,罗雅静 招商银行,招商银行翠竹支行,郝清辉-中国农业银行,朱怀冰--深圳工行龙岗支行,李昌明 招商银行,于江涛-招商银行深圳向西支行,招商银行洋河支行,付枚科 新都区三河支行,青岛银行,陈明良-中国建设银行义乌孝子祠支行,梁文睿 工商银行,汪芳慧芸 招商银行,林海 中国建设银行股份有限公司 上海江苏路支行,李雪 招商银行文锦渡支行,李思勇-中国银行广州桂花岗支行,陈玉霞 中国工商银行,林丽琼 招商银行厦门镇海支行,招商银行,中信银行江苏省南京市江宁分行,梁生----中国农行,徐州云龙湖支行 项文忠,兴业银行 佛山普君支行,刘淑娴-中国银行,戴越霄-招商银行盐田支行,陈东鹏-深圳农业银行,建设银行江西南昌市进贤支行--樊保国,朱宝英 中国建设银行世昌支行,易宇鹏 中国银行,广州市海珠区新港中农业支行,侯豫涛 -中国银行,陈世恩 中国银行,郑江霞 中国农业银行股份有限公司厦门杏林支行,宋成 招商银行 宁波海曙支行,张兴川 招商银行,董丽娜,叶伟麟 江门招商银行,朱露露 中国银行,于发梅---中国农行,戴贞 上海银行,李伟 建设银行深圳福永分行,杨超 兴业银行深圳市分行,招商银行深圳分行笋岗支行--朱耀永,中国农行--穆建华,孙祥斌 中国光大银行北仑支行,中国银行深圳梅林支行,江淑娇-农行乐清市柳市支行,东大名支行---蒋丽,农业银行江苏省无锡市阳山支行,齐耀普 招商银行深圳分行金丰城支行,高文涛 中国民生银行广州白云支行,中国银行深圳分行,吕俊-中国建设银行成都铁道支行成都理工学院储蓄所,邢梅林--中国银行,中国银行-----钟毅,王术国 中国银行天津春风路支行,中国工商银行深圳市分行,陈苏平-深圳中国银行深圳支行,丁优惠-中国工商银行,石其胜 建设银行漕冲支行,广发银行武汉光谷支行,张小丽—中国工商银行,中国农业银行厦门分行西柯支行,张英 中国农业银行股份有限公司肇庆高新支行,招商银行---麦颖弟,张清瑜-工商银行,李科平 中国农业银行-余姚支行,民生银行深圳坂田支行,江南农村商业银行庙桥支行,高超 中国农业银行股份有限公司天津浦口道支行,范建飞 农业银行,杨诗兴 农行,江颖婕 中国银行深圳分行,谢金丹 中国银行大学城北支行,陈勇 招商银行,华贸 招商银行南京分行营业部,许维乐 中国银行,唐亮 招商银行,庞蓓蕾---招商银行 东莞西城支行,吴坤 农行北仑区支行营业部,周志聪 中国银行深圳文锦渡支行,王雅娜 中国银行揭阳揭东新亨支行,郑清福 中国银行泉州分行笋江支行,农行北仑之行,张友群 招商银行,吴坤 泰隆商业银行北仑区支行,郑理挺 交通银行-水心支行,黄耀武 中山市农业银行古镇支行,舒小平 中国农业银行瑞安宾阳支行,李伟 中国工商银行新城支行,高宏祥 农业银行深圳盐田支行,竺林丽 中国银行,任超 中国农业银行股份有限公司乐清柳市支行,林青霞---中国农行银行 瑞安市塘下镇塘川支行,冯杰 中国农业银行深圳福永支行,蔡堪俊 中山市港口镇镇政府对面建设银行（港口支行）,冉路 招商银行文锦渡支行,聂利萍 中国工商银行 宁波江东支行,蒋晓琴 中国农业银行深圳龙华支行,杨姗姗,农行许昌市毓秀路分理处,谢正威 中国农业银行,张月裕 建设银行,曹勤 中国建设银行,陈斌 中国工商银行唐山路支行,张基新 兴业银行厦门支行,中国建设银行,刘松青 深圳招商银行创维大厦支行,苏杭 平安银行,蔡顺得 中国农业银行汕头市分行澄海市支行营业部,中国工商银行,陈璐 中国银行,厦门农业银行集美支行,工商银行皇岗支行,张赞阳 工商银行富华支行,李玉娟兴业银行厦门思明区分行,中国农业银行,蓝燕玲 中国银行雁鸣支行,招商银行 深圳分行文锦渡支行,鲍莹 中国工商银行砚瓦池支行,李玉姣 中国银行,李小雪 中国农业银行盐山东城支行,沈静 中国建设银行上海曹路支行,招行深圳向西支行,余建中 中国银行布吉支行,中国农业银行义乌分行东方支行,招商银行,孙思国 建设银行,中国建设银行五星支行,中国工商银行东莞分行凤岗支行,李举星 浦发银行青岛福州路支行,詹嘉玲-招商银行,建行无锡梅村支行,黄文海 中国银行广州番禺龙穴岛支行,詹嘉玲 招商银行,高乐丹 中国农业银行浙江省义乌支行,朱授兴 工商银行杭州市解放路支行,李梅 广西南宁凤翔支行,廖建勇 招商银行,左敏 中国工商银行福虹支行,蒋梅芳 中国农业银行德兴支行,王保岭 中国邮政储蓄银行,常凤伟 招商银行,浦发银行浦吉支行,廖李惠 中国银行,胡春章 山东省青岛市经济技术开发区支行崇明岛西路分理处,吕晨梦 中国银行,邹成 中国农业银行佛山南海九江支行,招商银行文锦渡支行,叶林华 农行瑞安万松支行,工商银行古镇分行华庭分理处,经露 中国银行句容支行营业部,建设银行股份有限公司厦门分行翔安支行,陈佳娜 - 中国银行,山小燕中国银行青岛西海岸新区支行,许翠梅 中国银行,中国银行,唐升平 中国银行深圳观澜支行,农业银行江西省南昌市进贤县民和镇支行,董杭 招商银行";
        String c = "中国农业银行深圳华南城支行,黄娟娟 中国银行莆田市石庭支行,张忠炎 中国农业银行广州美博城支行";
        String b = StringUtils.substring(a, 0 , 200);
        String d = StringUtils.substring(c, 0 , 200);

        System.out.println(b);
        System.out.println(d);
    }

}