package com.example.services;

import com.example.exceptions.NoAvailableSpotException;
import com.example.interfaces.SpotAllocationStrategy;
import com.example.models.ParkingLot;
import com.example.models.ParkingSpot;
import com.example.models.Ticket;
import com.example.models.Vehicle;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final NotificationService notificationService;
    private final TicketService ticketService;
    private final PaymentService paymentService;

    public ParkingService(ParkingLot parkingLot, NotificationService notificationService,
                          TicketService ticketService, PaymentService paymentService) {
        this.parkingLot = parkingLot;
        this.notificationService = notificationService;
        this.ticketService = ticketService;
        this.paymentService = paymentService;
    }

    public Ticket parkVehicle(Vehicle vehicle, SpotAllocationStrategy allocationStrategy) {
        ParkingSpot spot = allocationStrategy.findSpot(parkingLot.getFloors(), vehicle.getVehicleType());
        if (Objects.nonNull(spot)) {
            spot.assignVehicle(vehicle);
            Ticket ticket = ticketService.generateTicket(vehicle, spot);
            parkingLot.incrementBookings();
            notificationService.sendNotification("Vehicle parked. Ticket ID: " + ticket.getTicketId());
            return ticket;
        }
        throw new NoAvailableSpotException("No available spot for this vehicle type");
    }

    public Double unparkVehicle(String ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (Objects.isNull(ticket)) {
            throw new IllegalArgumentException("Invalid ticket ID");
        }
        LocalDateTime exitTime = LocalDateTime.now();
        Double amount = paymentService.calculateAmount(ticket, exitTime);
        if (paymentService.processPayment(amount)) {
            ticket.getParkingSpot().removeVehicle();
            ticketService.removeTicket(ticketId);
            parkingLot.addEarnings(amount);
            notificationService.sendNotification("Vehicle unparked. Amount: " + amount);
            return amount;
        }
        throw new IllegalStateException("Payment failed");
    }


}
