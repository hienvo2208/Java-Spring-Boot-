package com.example.demo.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping("")
    public RequestEntity<?> getListUser(){
        return null;
    }

    @PostMapping("")
    public RequestEntity<?> createUser(){
        return null;
    }

    @PutMapping("/{id}")
    public RequestEntity<?> updateUser(){
        return null;
    }

    @DeleteMapping("/{id}")
    public RequestEntity<?> deleteUser(){
        return null;
    }
}
