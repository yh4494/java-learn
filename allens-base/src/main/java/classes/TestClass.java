package classes;

import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import topdf.model.TestPdfModel;

import java.util.List;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-11-02 13:54
 * @Version V1.0
 */
public class TestClass <T> {

    void save(T some) {
//        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
//        System.out.println();
//        Class cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        System.out.println(cls);

        Equator equator = new GetterBaseEquator();
        TestPdfModel user1 = new TestPdfModel();
        user1.setName("some");
        user1.setFrom("fromSome");
        TestPdfModel user2 = new TestPdfModel();
        user2.setName("some");
        user2.setFrom("from");
        // 判断属性是否完全相等
        boolean result = equator.isEquals(user1, user2);
        System.out.println(result);
        // 获取不同的属性
        List<FieldInfo> diff = equator.getDiffFields(user1, user2);
        System.out.println(diff);
    }

    public static void main(String[] args) {
        TestClass<String> testClass = new TestClass<>();
        testClass.save("");
    }

}
