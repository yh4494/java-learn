package config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-22 14:16
 * @Version V1.0
 */
public class AllensSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] { RedConfig.class.getName() };
    }
}
