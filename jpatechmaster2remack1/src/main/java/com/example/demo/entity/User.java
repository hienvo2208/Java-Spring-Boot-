package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name ="full_name")
    private String name;

    @Column(name ="email", unique = true)
    private String email;

    @Column(name ="phone")
    private String phone;

    @Column(name ="avatar")
    private String avatar;

    @Column(name ="password")
    private String password;

    @Column(name ="birthday")
    private Date birthday;

    @Column(name ="role")
    private String role;


}
