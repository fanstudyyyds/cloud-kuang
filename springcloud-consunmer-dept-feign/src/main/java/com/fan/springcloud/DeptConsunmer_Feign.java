package com.fan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.fan.springcloud"})
@ComponentScan("com.fan.springcloud")
public class DeptConsunmer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsunmer_Feign.class,args);
    }
}
