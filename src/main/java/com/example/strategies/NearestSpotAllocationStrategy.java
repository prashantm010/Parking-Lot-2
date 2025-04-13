package com.example.strategies;

import com.example.enums.VehicleType;
import com.example.interfaces.SpotAllocationStrategy;
import com.example.models.ParkingFloor;
import com.example.models.ParkingSpot;

import java.util.List;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            List<ParkingSpot> spots = floor.getAvailableSpots(vehicleType);
            if (!spots.isEmpty()) {
                return spots.get(0); // return first available
            }
        }
        return null;
    }
}