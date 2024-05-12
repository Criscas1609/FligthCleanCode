package service.impl;

import model.Flight;
import model.User;
import model.Reservation;
import service.ReservationService;


public class ReservationServiceImpl implements ReservationService {

    @Override
    public void makeReservation(User user, Flight flight, int numberOfSeats) {
        if (flight.hasAvailableSeats()) {
            double totalPrice = numberOfSeats * flight.getPricePerSeat();
            Reservation reservation = new Reservation(user, flight, numberOfSeats, totalPrice);
            flight.addReservation(reservation);
            flight.updateAvailableSeats(numberOfSeats);
            reservation.showInformation();
        } else {
            System.out.println("No hay suficientes asientos disponibles para realizar la reserva.");
        }
    }
}
