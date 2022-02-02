package com.example.sp6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sp6Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Sp6Application.class, args);
		SimpleBean simpleBean = context.getBean(SimpleBean.class);
		System.out.println("Simple bean: "+simpleBean.toString());
	}

}
