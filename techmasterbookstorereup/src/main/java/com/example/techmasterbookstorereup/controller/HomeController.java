package com.example.techmasterbookstorereup.controller;

import com.example.techmasterbookstorereup.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return "This is my book store";
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
    @GetMapping(value = "/xml", produces = MediaType.TEXT_HTML_VALUE)
    public String getXml() {
        return "<books><book>Dế mèn phiêu lưu ký</book><book>Mắt biếc</book></books>";
    }

    @ResponseBody
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBooks() {
        String[] book = {"Chuyen Phap Luan", "Phap Luan Cong", "Giang phap tai My Quoc"};
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(book);
        } catch (Exception e) {
            return "{'error': 'cannot return books'}";
        }
    }
    @ResponseBody
    @GetMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCar(){
        Car car = new Car("Mercedes","Damler");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(car);
        } catch (Exception e) {
            return "{'error': 'cannot return cars'}";
        }
    }
}
