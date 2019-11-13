package com.revanwang.xc.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@EntityScan("com.revanwang.xc.framework.domain.cms")   // 扫描实体类
@ComponentScan(basePackages = "com.revanwang.xc.api")   // 扫描接口
@ComponentScan(basePackages = "com.revanwang.xc.manage_cms")
@SpringBootApplication
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class);
    }
}
