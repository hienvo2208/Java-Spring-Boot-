package com.example.demo.model.mapper;

import com.example.demo.Entity.User;
import com.example.demo.model.dto.UserDto;

public class UserMapper {
    public static UserDto userDto(User user) {
        UserDto tmp = new UserDto();
        tmp.getId();
        tmp.getName();
        tmp.getEmail();
        return tmp;
    }
}
