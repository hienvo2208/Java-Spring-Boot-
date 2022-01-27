package com.example.sb3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public Girl getRandomGirl() {
        String name = randomGirlName(10);
        // Gọi xuống tầng repository để query lấy một cô gái tên là "name" trong  database.
        return girlRepository.getGirlByName(name);
    }

    private String randomGirlName(int length) {
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }
}
