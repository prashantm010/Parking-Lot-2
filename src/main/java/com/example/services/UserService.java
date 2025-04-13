package com.example.services;

import com.example.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
        System.out.println("User registered: " + user.getName());
    }

    public User getUser(String name) {
        return users.get(name);
    }

    public void removeUser(String name) {
        users.remove(name);
        System.out.println("User removed: " + name);
    }
}