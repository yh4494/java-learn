package test;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.util.ReflectionUtils;
import model.BusinessFeeStandardParam;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-29 14:25
 * @Version V1.0
 */
@Service("happy")
public class Some {

    private static List<Field> some;

    @ApiModelProperty("hello")
    private String someone;

    public static void main(String[] args) {
        some = ReflectionUtils.getDeclaredFields(BusinessFeeStandardParam.class);
        some.forEach(e -> {
            ApiModelProperty s = e.getAnnotation(ApiModelProperty.class);
            if (s != null) System.out.println(String.format("// %s", s.value()));
            System.out.println(String.format("@Field(\"%s\")", e.getName()));
            System.out.println(String.format("private String %s;", e.getName()));
            System.out.println();
        });
    }

}
