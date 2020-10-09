package xmlparser;

import xmlparser.request.CusDetail;
import xmlparser.request.CustomerRootElement;
import xmlparser.request.User;
import xmlparser.utils.XMLUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        // 创建需要转换的对象
        /*
        User user = new User(1, "Steven", "@sun123", new Date(), 1000.0);
        CusDetail createCrmCustomers = new CusDetail(
                "CN", "票结", "宁波总部一号", "完美客商", "PERFACT", "1111111",
                "22222", "直客");
        CustomerRootElement customerRootElement = new CustomerRootElement(createCrmCustomers, "123", "456", "789", "11111", "11111");
        System.out.println("---将对象转换成string类型的xml Start---");
        // 将对象转换成string类型的xml
        String str = XMLUtil.convertToXml(customerRootElement);
        // 输出
        System.out.println(str);
        */

        /*
        System.out.println("---将对象转换成string类型的xml End---");
        System.out.println();
        System.out.println("---将String类型的xml转换成对象 Start---");
        User userTest = (User) XMLUtil.convertXmlStrToObject(User.class, str);
        System.out.println(userTest);
        System.out.println("---将String类型的xml转换成对象 End---");
        */
    }


}
