package service;

import model.Flight;
import model.User;

public interface ReservationService {

   void makeReservation(User user, Flight flight, int numberOfSeats);

}
