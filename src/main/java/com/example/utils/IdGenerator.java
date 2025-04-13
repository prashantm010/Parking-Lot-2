package com.example.utils;

import java.util.UUID;

public class IdGenerator {
    public static String generateId() {
        return String.valueOf(UUID.randomUUID());
    }
}
