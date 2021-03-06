package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "author",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name ="book_id")
    )
    private List<User> author;
}
