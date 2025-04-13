package com.example.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLot {
    String lotName;
    List<ParkingFloor> floors;
    List<EntryGate> entryGates;
    List<ExitGate> exitGates;
    private double dailyEarnings;
    private int dailyBookings;


    public ParkingLot(String lotName) {
        this.lotName = lotName;
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.dailyBookings = 0;
        this.dailyEarnings = 0;
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.add(floor);
    }

    public void addEntryGate(EntryGate entryGate) {
        this.entryGates.add(entryGate);
    }

    public void addExitGate(ExitGate exitGate) {
        this.exitGates.add(exitGate);
    }

    public void addEarnings(double amount) {
        this.dailyEarnings += amount;
    }

    public void incrementBookings() {
        this.dailyBookings++;
    }
}
