package com.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SocialmediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialmediaApplication.class, args);
    }

}
