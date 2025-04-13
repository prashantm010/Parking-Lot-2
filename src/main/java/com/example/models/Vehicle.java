package com.example.models;

import com.example.enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    String vehicleNo;
    VehicleType vehicleType;
    User user;

    public Vehicle(String vehicleNo, VehicleType vehicleType, User user) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.user = user;
    }
}
