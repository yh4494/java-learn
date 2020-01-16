package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class StreamTest {

    interface a {

    }

    public static void test1 () {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Optional<Integer> result = list.stream().reduce(Integer::sum);
        System.out.println(result);
    }

    public static void test2 () {
        System.out.println(2147483647 + 1 < 2147483647);
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(3);
//        list.add("some");
//        int i = 0;
//        for (String u : list) {
//            System.out.println("for" + i ++);
//        }
//        i = 0;
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("while" + i ++);
//        }
        test2();
    }

}
