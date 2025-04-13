package com.example.models;

import com.example.enums.UserRole;
import lombok.Data;

@Data
public class User {
    String name;
    UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }
}
