package java8.next;

import java.util.function.Function;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-29 14:43
 * @Version V1.0
 */
public class MainTest {

    private boolean test1 (DispatchNext dispatchNext) {
        return dispatchNext.next();
    }

    private boolean test() {
        System.out.println("hello stranger!");
        return false;
    }

    private boolean test2 () {
        System.out.println("we know each other");
        return true;
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        if (!mainTest.test1(mainTest::test)) {
            System.out.println("I don't want to be bak!");
            return;
        }
        if (mainTest.test1(mainTest::test2)) {
            System.out.println("be my girl friend!");
        }
    }

}
