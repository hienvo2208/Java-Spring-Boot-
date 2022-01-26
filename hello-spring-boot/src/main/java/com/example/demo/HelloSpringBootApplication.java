package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        System.out.println("Simple Bean Example: " + simpleBean.toString());
    }

}
