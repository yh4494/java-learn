package config;

import org.springframework.context.annotation.Import;

/**
 * @Description 普通类
 * @Author      Allens
 * @Date        2020-10-22 14:15
 * @Version     V1.0
 */
// @Import 可以传入四种类型：普通类、配置类、ImportSelector 的实现类，ImportBeanDefinitionRegistrar 的实现类。具体如文档注释中描述：
@Import(AllensSelector.class)
@EnableAllensAnonation
public class AllensConfiguration {
}
