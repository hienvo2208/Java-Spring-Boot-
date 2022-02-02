package com.example.sp5;

import com.example.sp5.other.OtherGirl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"com.example.sp5.other","com.example.sp5"})
public class Sp5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Sp5Application.class, args);
        try {
            Girl girl = context.getBean(Girl.class);
            System.out.println("Bean: " + girl.toString());
        } catch (Exception e) {
            System.out.println("Bean khong ton tai.");
        }

        try {
            OtherGirl otherGirl = context.getBean(OtherGirl.class);
            System.out.println("Bean: " + otherGirl.toString());
        } catch (Exception e) {
            System.out.println("Bean khong ton tai.");
        }
    }

}
