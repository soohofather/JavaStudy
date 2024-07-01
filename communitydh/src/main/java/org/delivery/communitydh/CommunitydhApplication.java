package org.delivery.communitydh;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunitydhApplication {

    public static void main(String[] args) {

        // Load .env file
        Dotenv dotenv = Dotenv.load();

        // Set environment variables
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(CommunitydhApplication.class, args);


    }

}
