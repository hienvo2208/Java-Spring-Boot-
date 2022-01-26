package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class Dress {
   public int size;
   public Dress(){}

    public Dress(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
