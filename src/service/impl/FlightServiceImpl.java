package service.impl;

import model.Flight;
import service.FlightService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    @Override
    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> flights = createSampleFlights();
        return flights.stream()
                .filter(flight -> flight.getOriginPlace().equals(origin))
                .filter(flight -> flight.getDestinationPlace().equals(destination))
                .filter(Flight::hasAvailableSeats)
                .collect(Collectors.toList());
    }

    @Override
    public void createFlight(String originPlace, String destinationPlace, Date departureTime, Date arrivalTime, int availableSeats) {
        Flight newFlight = new Flight(originPlace, destinationPlace, departureTime, arrivalTime, availableSeats);
        newFlight.showInformation();
    }

    @Override
    public void showAllFlights() {
        List<Flight> flights = createSampleFlights();
        flights.forEach(Flight::showInformation);
    }

    private List<Flight> createSampleFlights() {
        List<Flight> flights = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            flights.add(new Flight("Armenia", "Bogotá", sdf.parse("2024-05-15 08:00"), sdf.parse("2024-05-15 10:00"), 100));
            flights.add(new Flight("Bogotá", "Armenia", sdf.parse("2024-05-15 12:00"), sdf.parse("2024-05-15 14:00"), 100));
            flights.add(new Flight("Pereira", "Cartagena", sdf.parse("2024-05-16 09:00"), sdf.parse("2024-05-16 11:00"), 100));
            flights.add(new Flight("Bogotá", "Pereira", sdf.parse("2024-05-17 10:00"), sdf.parse("2024-05-17 12:00"), 100));
            flights.add(new Flight("Cartagena", "Bogotá", sdf.parse("2024-05-18 14:00"), sdf.parse("2024-05-18 16:00"), 100));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
