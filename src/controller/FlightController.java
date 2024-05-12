package controller;

import model.Flight;
import model.User;
import service.FlightService;
import service.ReservationService;
import service.impl.FlightServiceImpl;
import service.impl.ReservationServiceImpl;

import java.util.Date;
import java.util.List;

public class FlightController {
    private final FlightService flightService;
    private final ReservationService reservationService;

    public FlightController() {
        this.flightService = new FlightServiceImpl();
        this.reservationService = new ReservationServiceImpl();
    }

    public List<Flight> searchFlights(String origin, String destination) {
        return flightService.searchFlights(origin, destination);
    }

    public void makeReservation(User user, Flight flight, int numberOfSeats) {
        reservationService.makeReservation(user, flight, numberOfSeats);
    }

    public void createFlight(String originPlace, String destinationPlace, Date departureTime, Date arrivalTime, int availableSeats) {
        flightService.createFlight(originPlace, destinationPlace, departureTime, arrivalTime, availableSeats);
    }

    public void showAllFlights(){
        flightService.showAllFlights();
    }
}
