package base;

import java.util.ArrayList;
import java.util.List;

enum TestEnum implements FormatEnum {
    TEST1("1", "中文名称1"),
    TEST2("2", "中文名称2")
    ;

    private String key;

    private String value;

    TestEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<FormatEnumDO> assignToFormatDTO() {
        List<FormatEnumDO> formatEnumDTOS = new ArrayList<>();
        for (TestEnum testEnum : TestEnum.values()) {
            FormatEnumDO formatEnumDTO = new FormatEnumDO();
            formatEnumDTO.setKey(testEnum.getKey());
            formatEnumDTO.setValue(testEnum.getValue());
            formatEnumDTOS.add(formatEnumDTO);
        }
        return formatEnumDTOS;
    }
}
