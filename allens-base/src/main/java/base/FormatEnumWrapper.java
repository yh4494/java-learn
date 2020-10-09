/**
 * @Description 测试类
 * @Author Allens
 * @Date 2020-09-09 14:13
 * @Version V1.0
 */
package base;

import lombok.Data;

import java.util.List;

@Data
public class FormatEnumWrapper {

    private String key;

    private String name;

    private List<FormatEnumDO> list;

}
