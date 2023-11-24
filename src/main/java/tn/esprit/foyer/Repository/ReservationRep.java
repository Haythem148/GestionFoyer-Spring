package tn.esprit.foyer.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.foyer.Controllers.ReservationController;
import tn.esprit.foyer.Entity.Etudiant;
import tn.esprit.foyer.Entity.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ReservationRep extends CrudRepository<Reservation,String> {



    boolean existsByEtudiantsCinAndAnneeUniversiteBetween(Long etudiants_cin, LocalDate startDate, LocalDate endDate);
}
