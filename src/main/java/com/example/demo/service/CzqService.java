package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.example.other")
public class CzqService {
    @Value("${czqtest}")
    private  String czqtest ;
    public String test() {
        //Resource resource = new ClassPathResource("applicationContext.xml");
        return "czq"  + czqtest ;
    }
}
