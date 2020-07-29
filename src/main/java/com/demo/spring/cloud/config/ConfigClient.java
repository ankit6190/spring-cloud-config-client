package com.demo.spring.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClient {

    @Value("${user.name}")
    private String user;

    @Value("${user.password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

    @GetMapping(
            value = "/whoami",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami() {
        return String.format("Hello!  You're %s and password %s...\n", user, password);
    }
}
