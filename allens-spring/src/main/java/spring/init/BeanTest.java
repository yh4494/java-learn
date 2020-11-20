package spring.init;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.web.servlet.HandlerAdapter;
import server.ServerInitializer;

import java.util.stream.Stream;

public class BeanTest {

    public static void main(String[] args) {
         // BeanFactoryPostProcessor
         // BeanPostProcessor
         // InstantiationAwareBeanPostProcessorAdapter
         // BeanFactoryAware
         // BeanNameAware
         // InitializingBean
         // DisposableBean
         // InstantiationAwareBeanPostProcessorAdapter
         // HandlerAdapter
         // BeanPostProcessor
         // Resource
         // AbstractResource
         // ClassPathResource
         // XmlBeanFactory


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ServerInitializer.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);

        // this.autoConfigurations = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, this.beanClassLoader);
    }

}
