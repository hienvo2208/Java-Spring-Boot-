package com.example.sb3;

import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
@Repository
public class GirlRepositoryImpl implements GirlRepository {
    @Override
    public Girl getGirlByName(String name) {
        // Ví dụ ở đây là database đã trả về.
        // Một cô giá với tên đúng như tham số.

        // Trường hợp thực tế phải dùng query trong csdl
        return new Girl(name);
    }
}
