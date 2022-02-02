package com.example.sp8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Đây là nơi tiếp nhận các request từ phía client.
@Controller
public class WebController {
    // Đón nhận request GET
    @GetMapping("/")
    public String index() {
        return "index"; // Trả về file index.html
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
