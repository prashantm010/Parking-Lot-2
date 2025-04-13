package com.example.services;

import com.example.enums.UserRole;
import com.example.models.*;

public class AdminService {
    public void addNewFloor(ParkingLot lot, ParkingFloor floor, User user) throws IllegalAccessException {
        if (user.getRole() != UserRole.ADMIN) {
            throw new IllegalAccessException("Only admins can add floors.");
        }
        System.out.println("Floor " + floor.getFloorNo() + " added to " + lot.getLotName());
        lot.addFloor(floor);
    }

    public void addEntryGate(ParkingLot lot, EntryGate entryGate, User user) throws IllegalAccessException {
        if (user.getRole() != UserRole.ADMIN) {
            throw new IllegalAccessException("Only admins can add floors.");
        }
        System.out.println("Entry gate " + entryGate.getGateNo() + " added.");
        lot.addEntryGate(entryGate);
    }

    public void addExitGate(ParkingLot lot, ExitGate exitGate, User user) throws IllegalAccessException {
        if (user.getRole() != UserRole.ADMIN) {
            throw new IllegalAccessException("Only admins can add floors.");
        }
        System.out.println("Exit gate " + exitGate.getGateNo() + " added.");
        lot.addExitGate(exitGate);
    }
}
