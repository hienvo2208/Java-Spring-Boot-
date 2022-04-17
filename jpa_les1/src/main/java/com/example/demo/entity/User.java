package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name ="full_name", unique = true)
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name ="phone")
    private String phone;

    @Column(name="avatar")
    private String avatar;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String role;

    public void setFullName(String abc) {
    }

    public void setIdentityCard(IdentityCard idc) {
    }
}
