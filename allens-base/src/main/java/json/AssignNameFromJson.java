package json;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-27 13:31
 * @Version V1.0
 */
public class AssignNameFromJson {

    private static String jsonStr = "[\n" +
            "        {\n" +
            "            \"id\":1,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/CY\",\n" +
            "            \"name\":\"CY TO CY\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":2,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/CFS\",\n" +
            "            \"name\":\"CY TO CFS\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":3,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/DOOR\",\n" +
            "            \"name\":\"CY TO DOOR\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":4,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/FO\",\n" +
            "            \"name\":\"CY TO FO\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":5,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/HOOK\",\n" +
            "            \"name\":\"CY TO HOOK\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":6,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/LO\",\n" +
            "            \"name\":\"CY TO LO\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":7,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/TACKLE\",\n" +
            "            \"name\":\"CY TO TACKLE\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":8,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/CY\",\n" +
            "            \"name\":\"CFS TO CY\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":9,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/CFS\",\n" +
            "            \"name\":\"CFS TO CFS\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":10,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/DOOR\",\n" +
            "            \"name\":\"CFS TO DOOR\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":11,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/CY\",\n" +
            "            \"name\":\"DOOR TO CY\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":12,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/CFS\",\n" +
            "            \"name\":\"DOOR TO CFS\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":13,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/DOOR\",\n" +
            "            \"name\":\"DOOR TO DOOR\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":14,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/RAMP\",\n" +
            "            \"name\":\"CY TO RAMP\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":15,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/FO\",\n" +
            "            \"name\":\"CFS TO FO\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":16,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/DDU\",\n" +
            "            \"name\":\"CFS TO DDU\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":17,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CFS/DDP\",\n" +
            "            \"name\":\"CFS TO DDP\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":18,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/DDU\",\n" +
            "            \"name\":\"CY TO DDU\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":19,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"CY/DDP\",\n" +
            "            \"name\":\"CY TO DDP\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":20,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/HOOK\",\n" +
            "            \"name\":\"DOOK TO HOOK\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":21,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/TACKLE\",\n" +
            "            \"name\":\"DOOR TO TACKLE\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":22,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/RAMP\",\n" +
            "            \"name\":\"DOOR TO RAMP\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":23,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/DDU\",\n" +
            "            \"name\":\"DOOR TO DDU\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":24,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/DDP\",\n" +
            "            \"name\":\"DOOR TO DDP\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":25,\n" +
            "            \"orgId\":\"-1\",\n" +
            "            \"code\":\"DOOR/FO\",\n" +
            "            \"name\":\"DOOR TO FO\",\n" +
            "            \"nature\":\"1\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"-1\",\n" +
            "            \"createUserName\":\"系统\",\n" +
            "            \"createDate\":\"2017-12-27 11:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":106,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"2\",\n" +
            "            \"name\":\"22\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2018-12-12 11:16:01\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-02-13 17:54:25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":108,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1544879482\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2018-12-15 21:09:24\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2018-12-15 21:10:46\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1033,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1547088017\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-01-10 10:38:11\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-01-10 10:39:32\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1035,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1548058574\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-01-21 16:15:34\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-01-21 16:17:05\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1036,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1548297791\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-01-24 10:42:33\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-01-24 10:44:02\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1037,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1550456537\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-02-18 10:19:58\",\n" +
            "            \"updateUserId\":\"100002246\",\n" +
            "            \"updateUserName\":\"周亮-集团总部\",\n" +
            "            \"updateDate\":\"2019-06-24 10:10:10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1039,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"YSTK-JT\",\n" +
            "            \"name\":\"YSTK-JT\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100001560\",\n" +
            "            \"createUserName\":\"静静-集团\",\n" +
            "            \"createDate\":\"2019-02-27 14:05:04\",\n" +
            "            \"updateUserId\":\"100001560\",\n" +
            "            \"updateUserName\":\"静静-集团\",\n" +
            "            \"updateDate\":\"2019-02-27 14:05:04\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1040,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1551433934\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-01 17:49:53\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-01 17:51:14\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1042,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1551773611\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-05 16:11:08\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-05 16:12:30\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1044,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1552229877\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002148\",\n" +
            "            \"createUserName\":\"集团-俞森\",\n" +
            "            \"createDate\":\"2019-03-10 22:57:23\",\n" +
            "            \"updateUserId\":\"100002148\",\n" +
            "            \"updateUserName\":\"集团-俞森\",\n" +
            "            \"updateDate\":\"2019-03-10 22:58:40\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1046,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1553667655\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-27 14:21:30\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-27 14:21:30\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1047,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1553670194\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-27 15:03:51\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-27 15:03:51\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1048,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1553670435\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-27 15:06:35\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-27 15:07:20\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1049,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1553671219\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-27 15:19:40\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-27 15:20:24\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1051,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"1553677862\",\n" +
            "            \"name\":\"AUTO运输条款\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002156\",\n" +
            "            \"createUserName\":\"集团生产赵丹丹\",\n" +
            "            \"createDate\":\"2019-03-27 17:10:20\",\n" +
            "            \"updateUserId\":\"100002156\",\n" +
            "            \"updateUserName\":\"集团生产赵丹丹\",\n" +
            "            \"updateDate\":\"2019-03-27 17:11:52\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1066,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"testss\",\n" +
            "            \"name\":\"testss\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002246\",\n" +
            "            \"createUserName\":\"周亮-集团总部\",\n" +
            "            \"createDate\":\"2019-06-21 15:34:02\",\n" +
            "            \"updateUserId\":\"100002246\",\n" +
            "            \"updateUserName\":\"周亮-集团总部\",\n" +
            "            \"updateDate\":\"2019-06-21 15:35:10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1068,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"test071003\",\n" +
            "            \"name\":\"测试071003\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002250\",\n" +
            "            \"createUserName\":\"集团谢陵欢\",\n" +
            "            \"createDate\":\"2019-07-10 10:50:13\",\n" +
            "            \"updateUserId\":\"100002250\",\n" +
            "            \"updateUserName\":\"集团谢陵欢\",\n" +
            "            \"updateDate\":\"2019-07-10 10:53:56\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1069,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"test071002\",\n" +
            "            \"name\":\"测试071002\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002250\",\n" +
            "            \"createUserName\":\"集团谢陵欢\",\n" +
            "            \"createDate\":\"2019-07-10 10:54:44\",\n" +
            "            \"updateUserId\":\"100002250\",\n" +
            "            \"updateUserName\":\"集团谢陵欢\",\n" +
            "            \"updateDate\":\"2019-07-10 10:54:44\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1070,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"test071001\",\n" +
            "            \"name\":\"测试071001\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002250\",\n" +
            "            \"createUserName\":\"集团谢陵欢\",\n" +
            "            \"createDate\":\"2019-07-10 22:44:29\",\n" +
            "            \"updateUserId\":\"100002250\",\n" +
            "            \"updateUserName\":\"集团谢陵欢\",\n" +
            "            \"updateDate\":\"2019-07-10 22:44:29\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\":1081,\n" +
            "            \"orgId\":\"100000029\",\n" +
            "            \"code\":\"CY TO CY\",\n" +
            "            \"name\":\"CY - CY\",\n" +
            "            \"nature\":\"2\",\n" +
            "            \"isEnable\":\"1\",\n" +
            "            \"createUserId\":\"100002148\",\n" +
            "            \"createUserName\":\"集团-俞森\",\n" +
            "            \"createDate\":\"2020-03-13 00:30:30\",\n" +
            "            \"updateUserId\":\"100002148\",\n" +
            "            \"updateUserName\":\"集团-俞森\",\n" +
            "            \"updateDate\":\"2020-03-13 00:47:53\"\n" +
            "        }\n" +
            "    ]";


    public static void main(String[] args) {
        List<Map> o = JSON.parseArray(jsonStr, Map.class);
        for (Map s : o) {
            System.out.print(String.format("%s ", s.get("code")));
        }
    }

}
