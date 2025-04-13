package com.example;

import com.example.enums.SpotType;
import com.example.enums.UserRole;
import com.example.enums.VehicleType;
import com.example.models.*;
import com.example.services.*;
import com.example.strategies.CheapestSpotAllocationStrategy;
import com.example.strategies.NearestSpotAllocationStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService(ticketService);
        PaymentService paymentService = new PaymentService();
        NotificationService notificationService = new NotificationService();

        User admin = new User("Admin", UserRole.ADMIN);
        userService.registerUser(admin);

        ParkingLot lot = new ParkingLot("MallLot");
        ParkingService parkingService = new ParkingService(lot, notificationService, ticketService, paymentService);

        try {
            ParkingFloor floor1 = new ParkingFloor(1);
            floor1.addSpot(new ParkingSpot("F1-C1", SpotType.CAR, 20.0));
            floor1.addSpot(new ParkingSpot("F1-C2", SpotType.CAR, 20.0));
            floor1.addSpot(new ParkingSpot("F1-C3", SpotType.CAR, 15.0));
            floor1.addSpot(new ParkingSpot("F1-B1", SpotType.BIKE, 10.0));

            adminService.addNewFloor(lot, floor1, admin);
            adminService.addEntryGate(lot, new EntryGate(1), admin);
            adminService.addExitGate(lot, new ExitGate(1), admin);

            // Register customer and use parking service
            User customer1 = new User("Rajesh", UserRole.CUSTOMER);
            userService.registerUser(customer1);

            Vehicle vehicle1 = new Vehicle("UP21BY9008", VehicleType.CAR, customer1);
            Ticket ticket1 = parkingService.parkVehicle(vehicle1, new NearestSpotAllocationStrategy());

            System.out.println("Vehicle parked at spot: " + ticket1.getParkingSpot().getSpotId());
            System.out.println("Ticket ID: " + ticket1.getTicketId());

            double fee = parkingService.unparkVehicle(ticket1.getTicketId());
            System.out.println("Parking fee paid: Rs. " + fee);

            // Register customer and use parking service
            User customer2 = new User("Expo", UserRole.CUSTOMER);
            userService.registerUser(customer2);

            Vehicle vehicle3 = new Vehicle("UP21BY9009", VehicleType.CAR, customer1);
            Ticket ticket3 = parkingService.parkVehicle(vehicle3, new CheapestSpotAllocationStrategy());

            System.out.println("Vehicle parked at spot: " + ticket3.getParkingSpot().getSpotId());
            System.out.println("Ticket ID: " + ticket3.getTicketId());

            Vehicle vehicle2 = new Vehicle("UP21BY9010", VehicleType.CAR, customer1);
            Ticket ticket2 = parkingService.parkVehicle(vehicle2, new CheapestSpotAllocationStrategy());

            System.out.println("Vehicle parked at spot: " + ticket2.getParkingSpot().getSpotId());
            System.out.println("Ticket ID: " + ticket2.getTicketId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        reportService.generateReport(lot);
    }
}