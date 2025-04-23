package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.study.springboot.entity") // ✅ 여기에 주목!
public class SemiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SemiApplication.class, args);
    }
}
