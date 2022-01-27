package com.example.sb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sb3Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Sb3Application.class, args);
        GirlService girlService = context.getBean(GirlService.class);
        Girl girl = girlService.getRandomGirl();
        System.out.println(girl);
    }

}
