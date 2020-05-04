package com.example.ribbon.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
//        SERVICE-HI对应EurekaClient（服务提供者）中的application name ，进入EurekaServer网页中可以看到。
//        这里直接写SERVICE-HI会自动转换为localhost：端口号
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name , String.class);
    }
    public String hiError(String name){
        return "hi, " + name + ", sorry, error!";
    }
}
