package com.fan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${spring.application.name}")
    private String application;
    @Value("${eureka.client.server-url.defaultZone}")
    private String eurekaserver;
    @Value("${server.port}")
    private String port;


    @RequestMapping("/config")
    public String a() {
        return application + "\t" + eurekaserver + "\t" + port;
    }

}
