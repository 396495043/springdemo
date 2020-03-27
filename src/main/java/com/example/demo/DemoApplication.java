package com.example.demo;

import com.example.demo.exception.ErrorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
@Import(ErrorConfig.class)
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @RequestMapping("/tt")
    String home() {
        return "Hello World!";
    }
}
