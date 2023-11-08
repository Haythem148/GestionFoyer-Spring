package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
}
