package com.example.demo.service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public List<User> getListUser();
}
