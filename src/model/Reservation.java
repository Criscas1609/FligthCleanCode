package model;

import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private Flight flight;

    private int numberOfSeats;
    private LocalDateTime reservationDate;
    private double totalPrice;

    public Reservation(User user, Flight flight, int numberOfSeats, double totalPrice) {
        this.user = user;
        this.flight = flight;
        this.numberOfSeats = numberOfSeats;
        this.reservationDate = LocalDateTime.now();
        this.totalPrice = totalPrice;
    }

    public void showInformation(){
        System.out.println("------------------");
        System.out.println("Cliente: " + user.getFullName());
        System.out.println("Fecha de la reserva: " + reservationDate);
        System.out.println("Cantidad de sillas: " + numberOfSeats);
        System.out.println("Precio total: " + totalPrice);
        System.out.println("Vuelo:");
        flight.showInformation();

    }

}
