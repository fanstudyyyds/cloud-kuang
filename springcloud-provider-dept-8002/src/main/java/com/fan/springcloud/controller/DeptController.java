package com.fan.springcloud.controller;

import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return deptService.queryById( id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @RequestMapping("/dept/hh")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("getServices>>>>>"+services);
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getServiceId());
        }
        return this.client;
    }

}
