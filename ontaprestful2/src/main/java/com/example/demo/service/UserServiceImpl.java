package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    static List<User> users = new ArrayList<>();


    static {
        users.add(new User(1, "Thân Thị Hạnh", "thanhanh3179@gmail.com", "085545512", "null", "31793179"));
        users.add(new User(2, "Võ Đức Hiển", "hachiko3179", "0858187868", "null", "31793179"));
    }


    @Override
    public List<UserDto> getListUser() {
        List<UserDto> list = new ArrayList<>();
        for (User user : users) {
            list.add(UserMapper.toUserDto(user));
        }
        return list;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (id == user.getId()) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("Not found account");
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // Check email:
        for (User user : users) {
            if (req.getEmail().contains(user.getEmail())) {
                throw new DuplicateRecordException("Email already exists in the system");
            }
        }
        // Convert req to user
        User user = UserMapper.toUser(req);
        user.setId(users.size() + 1);
        users.add(user);
        // Return UserDto
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UpdateUserReq req) {
        for (User user : users) {
            // check id
            if (user.getId() == id) {
                if (!req.getEmail().equals(user.getId())) {
                    for (User user1 : users) {
                        if (user1.getEmail().equals(req.getEmail())) {
                            throw new DuplicateRecordException("New email is already in the system.");
                        }
                    }
                    user.setName(req.getName());
                    user.setPhone(req.getPhone());
                    user.setPassword(req.getPassword());
                    user.setAvatar(req.getAvatar());
                    return UserMapper.toUserDto(user);
                }
            }
        }
        throw new NotFoundException("Not found id.");
    }

    @Override
    public boolean deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        throw new NotFoundException("Not found user 404 ");
    }


}
