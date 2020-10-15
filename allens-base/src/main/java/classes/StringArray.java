package classes;

import topdf.model.TestPdfModel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-10 16:15
 * @Version V1.0
 */
public class StringArray {

    public static void main(String[] args) throws Exception {
        TestPdfModel testPdfModel = new TestPdfModel();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i ++) {
            Field[] fields = TestPdfModel.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!Modifier.isFinal(field.getModifiers())) {
                    Object value = field.get(testPdfModel);
                }
            }
        }
        long end   = System.currentTimeMillis();
        System.out.println(end - start);
        // String email = "yh4494@sina.com";
        // String[][] a = {{ email }};
        // System.out.println(a[0][0]);
    }

}
