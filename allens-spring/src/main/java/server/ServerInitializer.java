package server;

import config.StartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"spring.*", "config"})
// @Import 可以传入四种类型：普通类、配置类、ImportSelector 的实现类，
@Import(StartupListener.class)
public class ServerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerInitializer.class, args);
    }

}
