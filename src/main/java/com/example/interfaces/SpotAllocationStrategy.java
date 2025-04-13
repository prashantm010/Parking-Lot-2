package com.example.interfaces;

import com.example.enums.VehicleType;
import com.example.models.ParkingFloor;
import com.example.models.ParkingSpot;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType);
}