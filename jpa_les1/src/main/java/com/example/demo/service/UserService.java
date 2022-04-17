package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();
    public UserDto getUserByID(int id);
    public UserDto createUser(CreateUserReq req);
    public UserDto updateUser(UpdateUserReq req, int id);
    public Page<User> findUserLikeName(String name, int page);
    public void deleteUser(int id);
    public List<UserDto> findUserByName(String name);




}
