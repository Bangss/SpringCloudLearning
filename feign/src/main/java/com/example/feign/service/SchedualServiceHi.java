package com.example.feign.service;

import com.example.feign.controller.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//通过@ FeignClient（“服务名”），来指定调用哪个服务
@FeignClient(value = "service-hi" , fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne( @RequestParam(value = "name") String name );
}