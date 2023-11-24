package tn.esprit.foyer.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Foyer;
import tn.esprit.foyer.Entity.Universite;
import tn.esprit.foyer.Repository.FoyerRep;
import tn.esprit.foyer.Repository.UniversiteRep;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServiceImp implements IUniversiteService {

    private final UniversiteRep universiteRep;
    private final FoyerRep foyerRep;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRep.findAll();
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRep.save(universite);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRep.save(universite);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRep.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("No university found with this id: " + idUniversite));
    }

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRep.findById(idFoyer)
                .orElseThrow(() -> new IllegalArgumentException("No foyer found with this id: " + idFoyer));
        Universite universite = universiteRep.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        return universite;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRep.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("No university found with this id: " + idUniversite));
        universite.setFoyer(null);
        return universite;
    }
}