package com.fan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//Configuration ====spring applicationcontext.xml

    //配置负载均衡实现RibbonTemplate
    //AvailabilityFilteringRule 会先过滤调跳闸，访问故障的服务，对剩下的轮循
    //RoundRobinRule 轮循
    //RandomRule 随机

    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
