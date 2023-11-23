package tn.esprit.foyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.Entity.Reservation;
import tn.esprit.foyer.Service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService iReservationService;

    @GetMapping
    public List<Reservation> retrieveAllReservations() {
        return iReservationService.retrieveAllReservation();
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservationService.updateReservation(reservation);
    }

    @GetMapping("{idReservation}")
    public Reservation retrieveReservation(@PathVariable Long idReservation) {
        return iReservationService.retrieveReservation(idReservation);
    }
    @PostMapping("{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idChambre,@PathVariable long cinEtudiant){
        return  iReservationService.ajouterReservation(idChambre, cinEtudiant);
    }
}
