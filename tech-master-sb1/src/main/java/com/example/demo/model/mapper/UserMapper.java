package com.example.demo.model.mapper;

import com.example.demo.Entity.User;
import com.example.demo.model.dto.UserDto;

public class UserMapper {
    public static UserDto userDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        return tmp;
    }
}
