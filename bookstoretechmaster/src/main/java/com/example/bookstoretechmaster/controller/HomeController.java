package com.example.bookstoretechmaster.controller;


import com.example.bookstoretechmaster.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @ResponseBody //trả về dữ liệu trong trường body
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return "This is Amazon Book Store";
    }

    @ResponseBody
    @GetMapping(value = "/about", produces = MediaType.TEXT_HTML_VALUE)
    public String getAbout() {
        return "About page";
    }

    @ResponseBody
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson() {
        return "{'books': ['Dế mèn phiêu lưu ký', 'Mắt biếc']}";
    }

    @ResponseBody
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXml() {
        return "<books><book>Dế mèn phiêu lưu ký</book><book>Dế mèn phiêu lưu ký</book></books>";
    }

    @ResponseBody
    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBooks() {
        String[] books = {"Dế mèn phiêu lưu ký", "Mắt biếc", "Thám tử conan"};
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(books);
        } catch (Exception e) {
            return "{'error':'cannot return books'}";
        }
    }

    @ResponseBody
    @GetMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCar(){
        Car car = new Car("Triton 2020", "Mitsubishi");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(car);
        }catch (Exception e){
            return "{'error': '" + e.toString() +"'}";
        }
    }
}
