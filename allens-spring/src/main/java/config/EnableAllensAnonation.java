package config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
public @interface EnableAllensAnonation {
}
