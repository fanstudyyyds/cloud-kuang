package com.fan.springcloud.controller;

import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("用户不存在");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname(id+"没有对应信息").setDb_souter("no this 没有这个 in mysql");
    }

}
