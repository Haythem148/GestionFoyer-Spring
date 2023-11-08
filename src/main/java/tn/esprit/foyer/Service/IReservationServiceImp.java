package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Reservation;
import tn.esprit.foyer.Repository.ReservationRep;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IReservationServiceImp implements IReservationService {

    private final ReservationRep reservationRep;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRep.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRep.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRep.findById(idReservation).orElse(null);
    }
}
