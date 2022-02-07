package com.example.sb9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @GetMapping("/profile")
    public String profile(Model model) {
        // Tạo thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("name", "Võ Đức Hiển"));
        profile.add(new Info("nickname", "hachiko3179"));
        profile.add(new Info("gmail", "thanhanh3179@gmail.com"));
        profile.add(new Info("mylove", "Thân Thị Hạnh"));
        // đưa thông tin vào Model
        model.addAttribute("hachiko",profile);
        return "profile";
    }


}
