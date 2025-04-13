package com.example.models;

import com.example.enums.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingFloor {
    Integer floorNo;
    List<ParkingSpot> parkingSpotList;

    public ParkingFloor(Integer floorNo) {
        this.floorNo = floorNo;
        this.parkingSpotList = new ArrayList<>();
    }

    public void addSpot(ParkingSpot parkingSpot) {
        this.parkingSpotList.add(parkingSpot);
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType) {
        return parkingSpotList.stream()
                .filter(spot -> spot.getSpotType().toString().equals(vehicleType.toString()))
                .filter(ParkingSpot::getIsAvailable)
                .toList();
    }
}
