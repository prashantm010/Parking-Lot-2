package com.example.services;

import com.example.models.ParkingFloor;
import com.example.models.ParkingLot;
import com.example.models.Ticket;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportService {
    private final TicketService ticketService;

    public void generateReport(ParkingLot lot) {
        System.out.println("Report for Parking Lot: " + lot.getLotName());
        for (ParkingFloor floor : lot.getFloors()) {
            System.out.println("Floor " + floor.getFloorNo());
        }

        System.out.println("\nCurrently Parked Vehicles:");
        for (Ticket ticket : ticketService.getAllTickets()) {
            System.out.println("Vehicle: " + ticket.getVehicle().getVehicleNo() + ", Spot: " + ticket.getParkingSpot().getSpotId());
        }

        System.out.println("\nTotal Daily Earnings: Rs. " + lot.getDailyEarnings());
        System.out.println("Total Daily Bookings: " + lot.getDailyBookings());
    }
}
