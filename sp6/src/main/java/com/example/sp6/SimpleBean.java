package com.example.sp6;

public class SimpleBean {
    private String username;

    public SimpleBean(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "This is a simple bean, name: " + username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
