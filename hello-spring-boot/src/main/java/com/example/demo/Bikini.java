package com.example.demo;

import com.example.demo.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bikini")
public class Bikini implements Outfit  {
    public void wear(){
        System.out.println("Mac bikini");
    }
}
