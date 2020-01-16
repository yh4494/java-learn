package java.spring.utils;

import spring.model.TestModel1;
import spring.model.TestModel2;
import org.springframework.beans.BeanUtils;

public class TestBeanUtils {

    public static void main(String[] args) {
        TestModel1 testModel1 = new TestModel1();
        testModel1.setAge(10);
        TestModel2 testModel2 = new TestModel2();
        BeanUtils.copyProperties(testModel1, testModel2);
        testModel1.setName("name");

        System.out.println(testModel2);
        System.out.println(testModel1);
    }

}
