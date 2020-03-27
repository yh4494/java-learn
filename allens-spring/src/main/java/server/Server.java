package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"spring.service", "config"})
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class);
    }

}
