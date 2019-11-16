package com.revanwang.xc.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FreemarkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreemarkerApplication.class);
    }
}
