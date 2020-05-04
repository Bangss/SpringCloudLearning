package com.example.feign.controller;

import com.example.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne ( String name ) {
        return "sorry, " + name;
    }
}
