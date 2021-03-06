package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Than Thi Hanh", "thanhanh3179@gmail.com", "08555455"));
        users.add(new User(2, "Vo Duc Hien", "hachiko3179", "thanthihanh"));
        users.add(new User(3, "Vo Phuong Thao", "hachiko3179", "null"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.userDto(user));
        }
        return result;
    }
}
