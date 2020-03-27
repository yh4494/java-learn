package base;

public class StaticTest {

    private static Integer name = 0;

    public static void main(String[] args) {
        if (name == 0) {
            name = 1;
            System.out.println(name);
        }
    }

}
