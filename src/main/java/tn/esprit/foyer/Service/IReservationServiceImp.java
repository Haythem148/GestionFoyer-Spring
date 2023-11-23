package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRep.findById(idReservation).orElse(null);
    }
    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRep.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRep.findEtudiantByCin(cinEtudiant);
        Bloc bloc = blocRep.findById(chambre.getBloc().getIdBloc()).orElse(null);
        Reservation chambreReserve = reservationRep.findByChambre(idChambre);
        Reservation res =reservationRep.findById(Long.valueOf(String.valueOf(chambre.getNumChambre())+"-"+ bloc.getIdBloc() +"-"+ LocalDate.now().getYear())).orElse(null);
        if(res==null) {
            res = new Reservation();
            res.setAnneeUniversite(LocalDate.of(LocalDate.now().getYear(), 11, 22));
            res.setIdReservation(String.valueOf(chambre.getNumChambre()) + "-" + bloc.getIdBloc() + "-" + LocalDate.now().getYear()
            );
        }
        if(chambreReserve == null || chambreReserve.getAnneeUniversite().getYear() < LocalDate.now().getYear() ){
            if(chambre.getTypeChambre() == TypeChambre.SIMPLE){
                res.setEstValide(false);
            }
            else {
                res.setEstValide(true);
            }
            chambre.getReservations().add(res);
            if (res.getEtudiants()==null)
            {
                Set<Etudiant>etudiants=new HashSet<>();
                etudiants.add(etudiant);
                res.setEtudiants(etudiants);
            }
            else {
                res.getEtudiants().add(etudiant);
            }
            reservationRep.save(res);
            chambreRep.save(chambre);
        } else if (res.getAnneeUniversite().getYear() < LocalDate.now().getYear()) {
            if(chambre.getTypeChambre() == TypeChambre.SIMPLE){
                res.setEstValide(false);
            } else {
                res.setEstValide(true);
            }
            reservationRep.save(res);
        } else {
            if(res.getEstValide()){
                if(reservationRep.getNumberReservation(res.getIdReservation()) ==  1 && chambre.getTypeChambre() == TypeChambre.DOUBLE){
                    res.setEstValide(false);
                    reservationRep.save(res);
                } else if(reservationRep.getNumberReservation(res.getIdReservation()) == 1 && chambre.getTypeChambre() == TypeChambre.TRIPLE){
                    res.setEstValide(true);
                    reservationRep.save(res);
                }else{
                    res.setEstValide(false);
                }
                if (res.getEtudiants()==null)
                {
                    Set<Etudiant> etudiants=new HashSet<>();
                    etudiants.add(etudiant);
                    res.setEtudiants(etudiants);
                }
                else {
                    res.getEtudiants().add(etudiant);
                }
                reservationRep.save(res);
            }
        }
        return  res ;
    }

}
