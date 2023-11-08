package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Etudiant;
import tn.esprit.foyer.Repository.EtudiantRep;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IEtudiantServiceImp implements IEtudiantService {

    private final EtudiantRep etudiantRep;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRep.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        List<Etudiant> savedEtudiants = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            savedEtudiants.add(etudiantRep.save(etudiant));
        }
        return savedEtudiants;
    }



    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRep.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRep.findById(idEtudiant).orElse(null);
    }

    @Override
    public boolean removeEtudiant(long idEtudiant) {
        etudiantRep.deleteById(idEtudiant);
        return !etudiantRep.existsById(idEtudiant);
    }
}
