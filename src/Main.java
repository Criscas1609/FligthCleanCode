import controller.FlightController;
import model.Flight;
import model.Reservation;
import model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightController flightController = new FlightController();

        System.out.println("Vuelos Disponibles:");
        flightController.showAllFlights();

        searchAndBookFlight(flightController, "Armenia", "Bogotá");

        System.out.println("Reservas del vuelo:");
        List<Flight> availableFlights = flightController.searchFlights("Armenia", "Bogotá");
        availableFlights.forEach(flight -> flight.getReservations().forEach(Reservation::showInformation));
    }

    public static void searchAndBookFlight(FlightController flightController, String origin, String destination){
        System.out.println("Busqueda de vuelo de " + origin + " a " + destination + ":");
        List<Flight> availableFlights = flightController.searchFlights(origin, destination);
        availableFlights.forEach(Flight::showInformation);

        User user = new User("Cristhian Correa", "ccorrea@cue.edu.co");

        if (!availableFlights.isEmpty()) {
            Flight flightToBook = availableFlights.get(0);
            int numberOfSeatsToBook = 1;
            flightController.makeReservation(user, flightToBook, numberOfSeatsToBook);
        } else {
            System.out.println("No hay vuelos disponibles.");
        }
    }
}
