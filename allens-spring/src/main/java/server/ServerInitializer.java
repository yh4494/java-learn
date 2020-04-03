package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"spring.*", "config"})
public class ServerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerInitializer.class, args);
    }

}
