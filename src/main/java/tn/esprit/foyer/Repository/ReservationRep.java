package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Reservation;

public interface ReservationRep extends CrudRepository<Reservation,Long> {
}
