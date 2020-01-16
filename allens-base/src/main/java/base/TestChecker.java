package base;

import org.apache.commons.lang.StringUtils;

public class TestChecker {

    public static void main(String[] args) {
        // 测试检验方法
        String s = "somea23184";
        // System.out.println(s.substring(0, 6));
        System.out.println(StringUtils.substring(s, 0, 6));
    }
}
