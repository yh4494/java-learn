package spring.mapperstruct;

import model.BusinessFeeStandardParam;
import model.TestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BaseMapping {

    /**
     * 映射同名属性
     */
    @Mapping(target = "typeSome", source = "type")
    TestModel sourceToTarget(BusinessFeeStandardParam businessFeeStandardParam);

}
