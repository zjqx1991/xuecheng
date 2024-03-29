package com.revanwang.xc.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@EntityScan("com.revanwang.xc.framework.domain.cms")   // 扫描实体类
@ComponentScan(basePackages = "com.revanwang.xc.api")   // 扫描接口
@ComponentScan(basePackages = "com.revanwang.xc.manage_cms")    //扫描本工程
@ComponentScan(basePackages = "com.revanwang.xc.framework") //扫描common工程
@SpringBootApplication
@EnableDiscoveryClient
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class);
    }
}
