package com.example.enums;

public enum SpotType {
    BIKE, CAR, TRUCK, ELECTRIC, HANDICAPPED;

    public static SpotType fromString(String type) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return BIKE;
            case "CAR":
                return CAR;
            case "TRUCK":
                return TRUCK;
            case "ELECTRIC":
                return ELECTRIC;
            case "HANDICAPPED":
                return HANDICAPPED;
            default:
                throw new IllegalArgumentException("Unknown spot type: " + type);
        }
    }
}
