package com.fan.springcloud.controller;

import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptConsumerController {
    @Autowired
    private DeptClientService service = null;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        System.out.println("11111111111111");
        return this.service.queryAll();
    }

}
