package com.example.strategies;

import com.example.enums.VehicleType;
import com.example.interfaces.SpotAllocationStrategy;
import com.example.models.ParkingFloor;
import com.example.models.ParkingSpot;

import java.util.List;

public class CheapestSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            List<ParkingSpot> spots = floor.getAvailableSpots(vehicleType).stream()
                    .sorted((s1, s2) -> Double.compare(s1.getPricePerHour(), s2.getPricePerHour()))
                    .toList();
            if (!spots.isEmpty()) {
                return spots.get(0);
            }
        }
        return null;
    }
}