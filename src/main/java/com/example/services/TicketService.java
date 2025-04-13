package com.example.services;

import com.example.models.ParkingSpot;
import com.example.models.Ticket;
import com.example.models.Vehicle;
import com.example.utils.IdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    Map<String, Ticket> tickets = new HashMap<>();

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        String ticketId = IdGenerator.generateId();
        Ticket ticket = new Ticket(ticketId, spot, vehicle);
        tickets.put(ticketId, ticket);
        return ticket;
    }

    public Ticket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }

    public void removeTicket(String ticketId) {
        tickets.remove(ticketId);
    }

    public List<Ticket> getAllTickets() {
        return tickets.values().stream().toList();
    }
}
