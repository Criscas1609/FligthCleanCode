package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    private String originPlace;
    private String destinationPlace;
    private Date departureTime;
    private Date arrivalTime;
    private int availableSeats;
    private List<Reservation> reservations = new ArrayList<>();

    public Flight(String originPlace, String destinationPlace, Date departureTime, Date arrivalTime, int availableSeats) {
        this.originPlace = originPlace;
        this.destinationPlace = destinationPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public double getPricePerSeat() {
        return 100000;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void updateAvailableSeats(int numberOfSeats) {
        availableSeats -= numberOfSeats;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void showInformation(){
        System.out.println("------------------");
        System.out.println("Origen: "+ originPlace);
        System.out.println("Destino: "+ destinationPlace);
        System.out.println("Fecha de salida: "+ departureTime);
        System.out.println("Fecha de llegada: "+ arrivalTime);
        System.out.println("Sillas disponibles: "+ availableSeats);
        System.out.println("------------------");
    }
}
