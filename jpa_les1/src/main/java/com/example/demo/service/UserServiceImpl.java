package com.example.demo.service;

import com.example.demo.entity.User;

import com.example.demo.exception.InternalServerException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserByID(int id) {
        UserDto userDto = UserMapper.toUserDto(userRepository.getById(id));
        return userDto;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // check email exists in the system.
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new InternalServerException("Email is ready in system");
        }
        user = userRepository.save(UserMapper.toUser(req));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        // check ID
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }
        User updateUser = UserMapper.toUser(req, id);
        try {
            userRepository.save(updateUser);
        } catch (Exception e) {
            throw new InternalServerException("Database error. Can't update user");
        }
        return UserMapper.toUserDto(updateUser);
    }

    @Override
    public Page<User> findUserLikeName(String name, int page) {
        Page<User> rs = userRepository.findUserByName(name, PageRequest.of(page, 10, Sort.by("id").descending()));
        return rs;
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new InternalServerException("Data base error. Can't delete User");
        }
    }

    @Override
    public List<UserDto> findUserByName(String name) {
        List<User> users = userRepository.findUserByName(name);
        if (users == null ){
            throw new NotFoundException("No found user in the system");
        }
        List<UserDto> result = new ArrayList<>();
        for(User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

}
