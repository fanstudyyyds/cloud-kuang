package com.fan.springcloud.service;

import com.fan.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("服务降级了").setDb_souter("服务降级了");
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
