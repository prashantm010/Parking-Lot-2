package com.example.services;

import com.example.models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {
    public boolean processPayment(Double amount) {
        System.out.println("Processing payment of Rs. " + amount);
        return true;
    }

    public Double calculateAmount(Ticket ticket, LocalDateTime exitTime) {
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long hours = duration.toHours();
        if (hours == 0) hours = 1;
        return hours * ticket.getParkingSpot().getPricePerHour();
    }
}
