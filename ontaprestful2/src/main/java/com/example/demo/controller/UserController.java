package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.model.request.UploadFile;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.*;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/upload";

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get list user", response = UserDto.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 500, message = "")
    })
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> result = userService.getListUser();
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Get user info by id", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "No user found"),
            @ApiResponse(code = 500, message = "")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }


    @ApiOperation(value = "Create user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Email already exits in the system"),
            @ApiResponse(code = 500, message = "")
    })
    @PostMapping("")
    public ResponseEntity<?> creteUser(@Valid @RequestBody CreateUserReq req) {
        UserDto userDto = userService.createUser(req);
        return ResponseEntity.ok(req);
    }

    @ApiOperation(value = "Update User", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Email already exits in the system"),
            @ApiResponse(code = 500, message = "")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDto result = userService.updateUser(id, req);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Delete User", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "404- No use found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@Valid @PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete success");
    }

    @ApiOperation(value = "Upload file", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 500, message="Internal Server Error"),
            @ApiResponse(code = 400, message="Bad request")
    })
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute("uploadForm") UploadFile form) {
        // Create folder to save file if not exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        MultipartFile fileData = form.getFileData();
        String name = fileData.getOriginalFilename();
        if (name != null && name.length() > 0) {
            try {
                // Create file
                File serverFile = new File(UPLOAD_DIR + "/" + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                stream.close();
                return ResponseEntity.ok("/file/"+name);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when uploading");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}
