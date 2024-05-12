package service;

import model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {

    List<Flight> searchFlights(String origin, String destination);
    void createFlight(String originPlace, String destinationPlace, Date departureTime, Date arrivalTime, int availableSeats);

    void showAllFlights();
}
