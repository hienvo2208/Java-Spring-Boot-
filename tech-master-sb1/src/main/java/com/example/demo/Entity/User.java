package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
}
