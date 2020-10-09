package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        List<String> b = new ArrayList<>();
        b.add("2");
        List<String> c = new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        System.out.println(c);

        List<String> empty = new ArrayList<>();
        List<String> tem = empty.stream().collect(Collectors.toList());
        System.out.println(tem);
    }

}
