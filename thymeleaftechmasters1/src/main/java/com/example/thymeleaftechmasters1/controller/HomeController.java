package com.example.thymeleaftechmasters1.controller;

import com.example.thymeleaftechmasters1.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Đọc giá trị từ application.properties
    @Value("${spring.application.name}")
    private String appName;
    static final String APP_NAME = "appName";
    static final String BOOKS = "books";

    @GetMapping(value = "/")
    public String getHome(Model model) {
        model.addAttribute(APP_NAME, appName);
        return "home";
    }

    @GetMapping(value = "/about")
    public String getAbout(Model model) {
        model.addAttribute(APP_NAME, appName);
        return "about";
    }

    @GetMapping(value = "/book")
    public String getBook(Model model) {
        String[] bookCollection = {"Giang phap tai Bac my", "Giang phap tai Uc", "Giảng pháp tại Đài Loan"};
        model.addAttribute("books", bookCollection);
        model.addAttribute(APP_NAME, appName);
        return "book";
    }

    @GetMapping(value = "/books")
    public String getBook2(Model model) {
        Book[] bookCollection = {
                new Book(1, "Chuyển Pháp Luân", "Lý Hồng Chí"),
                new Book(2, "Pháp Luân Công", "Lý Hồng Chí")
        };
        model.addAttribute("books",bookCollection);
        model.addAttribute(APP_NAME,appName);
        return "book2";
    }
    // Trả về books là mảng của đối tượng kiểu book, thêm ảnh cho từng sách.
    @GetMapping(value = "/book3")
    public String getBook3(Model model){
        Book[] bookCollection ={
          new Book(1,"Cafe cùng Tony", "Tony"),
                new Book(2,"Dế Mèn Phiêu Lưu ký", "Tô Hoài")

        };
        model.addAttribute(BOOKS, bookCollection);
        model.addAttribute(appName, appName);
        return "book3";
    }

    // Trả về books là mảng của đối tượng kiểu Books, thêm ảnh cho từng sách, CSS đẹp.
    @GetMapping(value = "/book4")
    public String getBook4(Model model){
        Book[] bookCollection ={
                new Book(1, "Cafe cùng Tony", "Tony"),
                new Book(2, "Dế Mèn Phiêu Lưu Ký", "Tô Hoài")
        };
        model.addAttribute(BOOKS,bookCollection);
        model.addAttribute(APP_NAME,appName);
        return "book4";
    }


}
