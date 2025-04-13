package com.example.models;

import com.example.enums.SpotType;
import lombok.Data;

@Data
public class ParkingSpot {
    String spotId;
    Boolean isAvailable;
    SpotType spotType;
    Vehicle parkedVehicle;
    Double pricePerHour;

    public ParkingSpot(String spotId, SpotType spotType, Double pricePerHour) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.isAvailable = true;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
