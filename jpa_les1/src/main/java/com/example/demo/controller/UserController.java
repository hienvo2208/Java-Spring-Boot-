package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> result = userService.getListUser();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserByID(id);
        return ResponseEntity.ok(userDto);
    }
    @ApiOperation(value = "Create user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code=400,message = "Email already exists in the system"),
            @ApiResponse(code=500,message = "Email already exists in the system")
    })
    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }
    @ApiOperation(value = "Update User", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code=400,message = "No found user"),
            @ApiResponse(code=500,message = "")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id){
        UserDto result = userService.updateUser(req, id);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Get list user with paging", response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code=500,message = "")
    })
    @GetMapping("/like-name")
    public ResponseEntity<?> getListUserLikeName(@RequestParam(required = false) Integer page) {
        int currPage;
        if (page == null) {
            currPage = 0;
        } else {
            currPage = page - 1;
        }
        Page<User> result = userService.findUserLikeName("John", currPage);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "Delete User by Id", response =String.class )
    @ApiResponses({
            @ApiResponse(code=400,message = "No user found"),
            @ApiResponse(code=500,message = "")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser( @PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete success");
    }

    @PostMapping("/find-name")
    public ResponseEntity<?> findUserByName(@RequestBody UpdateUserReq req){
        List<UserDto> result = userService.findUserByName(req.getName());
        return ResponseEntity.ok(result);
    }

}
//