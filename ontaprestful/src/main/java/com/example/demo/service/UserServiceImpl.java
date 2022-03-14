package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.sun.jdi.request.DuplicateRequestException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();


    static {
        users.add(new User(1, "Than Thi Hanh", "thanhanh3179@gmail.com", "0858187868", "image1", "voduchien"));
        users.add(new User(2, "Vo Duc Hien", "hachiko3179@gmail.com", "0858187868", "image2", "voduchien"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User khong toi tai trong he thong");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // Check email exits
        for (User user : users) {
            if (user.getEmail().equals(req.getEmail())) {
                throw new DuplicateRequestException("Email already exists in the system");
            }
        }
        // Convert CreateUserReq -> User
        User user = UserMapper.toUser(req);
        user.setId(users.size() + 1);
        // Insert user
        users.add(user);
        return UserMapper.toUserDto(user);

    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        for (User user : users) {
            if (user.getId() == id) {
                if (!user.getEmail().equals(req.getEmail())) {
                    // check new email exits
                    for (User tmp : users) {
                        if (tmp.getEmail().equals(req.getEmail())) {
                            throw new DuplicateRequestException("new email already exists in the system");
                        }
                    }
                    user.setEmail(req.getEmail());
                }
                user.setName(req.getName());
                user.setPhone(req.getPhone());
                user.setAvatar(req.getAvatar());
                user.setPassword(req.getPassword());
                return UserMapper.toUserDto(user);
            }

        }
        throw new NotFoundException("No user found");
    }

    @Override
    public Boolean deleteUser(int id) {
        for(User user: users){
            if(id==user.getId()){
                users.remove(user);
                return true;
            }
        }
        throw new NotFoundException("No User found");
    }


}
