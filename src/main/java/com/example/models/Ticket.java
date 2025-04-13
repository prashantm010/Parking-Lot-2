package com.example.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime entryTime;

    public Ticket(String ticketId, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
    }
}
