package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Etudiant;
import tn.esprit.foyer.Repository.EtudiantRep;

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
    public Etudiant addEtudiants(Etudiant etudiant) {
        return etudiantRep.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRep.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRep.findById(idEtudiant)
                .orElseThrow(() -> new IllegalArgumentException("No etudiant found with this id: " + idEtudiant));
    }

    @Override
    public boolean removeEtudiant(long idEtudiant) {
        etudiantRep.deleteById(idEtudiant);
        return !etudiantRep.existsById(idEtudiant);
    }
}