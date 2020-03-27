package spring.model;

import org.springframework.beans.BeanUtils;

public class MainTestClass {

    public static void main(String[] args) {
        TestModel1 testModel1 = new TestModel1();
        testModel1.setAge(10);

        TestModel1 testModel2 = new TestModel1();
        testModel2.setName("name");

        BeanUtils.copyProperties(testModel1, testModel2);
        System.out.println(testModel2);
    }

}
