package com.revanwang.xc.govern;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GovernApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernApplication.class);
    }
}
