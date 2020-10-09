/**
 * @Description 测试类
 * @Author Allens
 * @Date 2020-09-09 13:17
 * @Version V1.0
 */
package base;

import java.util.List;
import java.util.Map;

public class EnumUtils {

    public static List<FormatEnumDO> convertEnumToLists (FormatEnum formatEnum) {
        return formatEnum.assignToFormatDTO();
    }

    /**
     * 生成FormatWrapper
     * @param formatEnum
     * @return
     */
    public static FormatEnumWrapper generateFormatWrapper (String key, String name, FormatEnum formatEnum) {
        FormatEnumWrapper enumWrapper = new FormatEnumWrapper();
        enumWrapper.setList(convertEnumToLists(formatEnum));
        enumWrapper.setName(name);
        enumWrapper.setKey(key);
        return enumWrapper;
    }

    public static void main(String[] args) {
        System.out.println(generateFormatWrapper("1", "侧首", TestEnum.TEST1));
    }

}
