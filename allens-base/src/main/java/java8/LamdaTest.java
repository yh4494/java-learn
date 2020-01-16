package java8;

import java.util.ArrayList;
import java.util.List;

public class LamdaTest {

    @FunctionalInterface
    interface Hello {
        void run(String name);
    }

    @FunctionalInterface
    interface Test {
        Boolean test(Integer i);
    }

    interface Result {
        String result();
    }

    public static void some (Hello hello) {
        System.out.println("hello");
        hello.run("name");
    }

    public static Result returnResult (Result result) {
        return result;
    }

    public static Boolean judgeGreatThan (Test test, Integer i) {
        return test.test(i);
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("--------");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.forEach(System.out::println);
//        list.stream().parallel().sorted();
//
        new Thread(() -> System.out.println("+++++++++++++++++=")).start();
//        some((here) -> {
//            System.out.println(here + "=========");
//        });

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.forEach(e -> {
            if (judgeGreatThan((i) -> {
                    if (i > 2) return true;
                    return false;
                }, e)) {
                System.out.println(e);
            }
        });

        integers.forEach($ -> {
            if (judgeGreatThan((i) -> {
                if (i < 2) return true; return false;
            }, $)) {
                System.out.println($);
            }
        });

    }

}
