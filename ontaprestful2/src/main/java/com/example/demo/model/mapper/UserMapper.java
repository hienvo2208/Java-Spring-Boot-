package com.example.demo.model.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setName(user.getName());
        tmp.setId(user.getId());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        return tmp;
    }

    public static User toUser(CreateUserReq userReq) {
        User tmp = new User();
        tmp.setName(userReq.getName());
        tmp.setEmail(userReq.getEmail());
        tmp.setPhone(userReq.getPhone());
        tmp.setPassword(userReq.getPassword());
        return tmp;
    }
}
