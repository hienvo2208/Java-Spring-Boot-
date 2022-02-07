package com.example.sb8_ver_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
            // Request param "name" sẽ được gán giá trị vào biến String.
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            // Model là một object của spring Boot, được gán vào mọi request.
            Model model) {
        // Gán vào model giá trị name nhận được
        model.addAttribute("name", name);
        return "hello"; // trả về file hello.html cùng với thông tin trong object Model.

    }


}
