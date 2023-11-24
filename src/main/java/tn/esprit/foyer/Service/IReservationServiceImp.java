package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.foyer.Entity.*;
import tn.esprit.foyer.Repository.*;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class IReservationServiceImp implements IReservationService {

    private final ReservationRep reservationRep;
    private final FoyerRep foyerRep;
    private  final EtudiantRep etudiantRep;
    private  final ChambreRep chambreRep;
private  final BlocRep blocRep;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRep.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRep.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRep.findById(idReservation).orElse(null);
    }
    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        LocalDate startDate =LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate endDate =LocalDate.of(LocalDate.now().getYear(),12,31);
        Assert.isTrue(reservationRep.existsByEtudiantsCinAndAnneeUniversiteBetween(cinEtudiant,startDate,endDate),"You have reservation !!");
        Chambre chambre =chambreRep.findById(idChambre).orElseThrow(() -> new IllegalArgumentException("No chambre found by id "+idChambre));
        Etudiant etudiant=etudiantRep.findEtudiantByCin(cinEtudiant);
        String id = chambre.getNumChambre()+"-"+chambre.getBloc().getNomBloc()+"-"+LocalDate.now().getYear();
        Reservation reservation = reservationRep.findById(id).orElse(
                Reservation.builder()
                        .anneeUniversite(LocalDate.now())
                        .estValide(true)
                        .etudiants(new ArrayList<Etudiant>()).build()
        );
        Assert.isTrue(reservation.isEstValide(),"room not available");
        reservation.getEtudiants().add(etudiant);

        if(!chambre.getReservations().contains(reservation)) {
           reservation= reservationRep.save(reservation);

            chambre.getReservations().add(reservation);
        }


        switch (chambre.getTypeChambre()){
            case SIMPLE -> reservation.setEstValide(false);
            case DOUBLE -> {if(reservation.getEtudiants().size()==2){reservation.setEstValide(false);}}
            case TRIPLE -> {if(reservation.getEtudiants().size()==3){reservation.setEstValide(false);}}
        }



       return reservation;
    }

}
