package com.fan.springcloud.service;

import com.fan.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)//,fallbackFactory = DeptClientServiceFallbackFactory.class
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept);

    @RequestMapping("/dept/list")
    public List<Dept> queryAll();

}
