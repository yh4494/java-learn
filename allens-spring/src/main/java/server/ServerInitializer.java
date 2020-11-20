package server;

import config.StartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 标识一个类作为 SpringBoot 的配置类，它可以是Spring原生的 @Configuration 的一种替换方案，目的是这个配置可以被自动发现。
 * 应用应当只在主启动类上标注 @SpringBootConfiguration，大多数情况下都是直接使用 @SpringBootApplication。
 * 搜索算法从包含测试的程序包开始工作，直到找到带有 @SpringBootApplication 或 @SpringBootConfiguration 标注的类。只要您以合理的方式对代码进行结构化，通常就可以找到您的主要配置。
 */
@SpringBootApplication(scanBasePackages = {"spring.*", "config"})
// @Import 可以传入四种类型：普通类、配置类、ImportSelector 的实现类，
// 也解释了为什么 SpringBoot 的启动器一定要在所有类的最外层。
/**
 * 启用Spring-ApplicationContext的自动配置，并且会尝试猜测和配置您可能需要的Bean。通常根据您的类路径和定义的Bean来应用自动配置类。例如，如果您的类路径上有 tomcat-embedded.jar，则可能需要 TomcatServletWebServerFactory （除非自己已经定义了 ServletWebServerFactory 的Bean）。
 * 使用 @SpringBootApplication 时，将自动启用上下文的自动配置，因此再添加该注解不会产生任何其他影响。
 * 自动配置会尝试尽可能地智能化，并且在您定义更多自定义配置时会自动退出（被覆盖）。您始终可以手动排除掉任何您不想应用的配置（如果您无法访问它们，请使用 excludeName() 方法），您也可以通过 spring.autoconfigure.exclude 属性排除它们。自动配置始终在注册用户自定义的Bean之后应用。
 * 通常被 @EnableAutoConfiguration 标注的类（如 @SpringBootApplication）的包具有特定的意义，通常被用作“默认值”。例如，在扫描@Entity类时将使用它。通常建议您将 @EnableAutoConfiguration（如果您未使用 @SpringBootApplication）放在根包中，以便可以搜索所有包及子包下的类。
 * 自动配置类也是常规的Spring配置类。它们使用 SpringFactoriesLoader 机制定位（针对此类）。通常自动配置类也是 @Conditional Bean（最经常的情况下是使用 @ConditionalOnClass 和 @ConditionalOnMissingBean 标注）。
 */
@Import(StartupListener.class)
public class ServerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerInitializer.class, args);
    }

}
