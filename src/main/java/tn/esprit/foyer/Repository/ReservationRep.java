package tn.esprit.foyer.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.foyer.Controllers.ReservationController;
import tn.esprit.foyer.Entity.Reservation;

public interface ReservationRep extends CrudRepository<Reservation,Long> {



    @Query("SELECT r FROM Reservation r WHERE r.idReservation LIKE CONCAT('%', :numChambre, '%')")
    Reservation findByChambre(@Param("numChambre") long numChambre);
    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.idReservation = :idReservation")
    long getNumberReservation(@Param("idReservation") String idReservation);
}
