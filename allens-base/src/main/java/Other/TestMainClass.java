package Other;

import com.alibaba.fastjson.JSON;

public class TestMainClass {

    public static void main(String[] args) {
        TestPojo testPojo = new TestPojo();
        testPojo.setName("some");

        Object o = "";
        o = testPojo;

        System.out.println(JSON.toJSON(o));
    }

}
