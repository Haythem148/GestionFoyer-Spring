package tn.esprit.foyer.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Foyer;
import tn.esprit.foyer.Entity.Universite; // Change the import statement
import tn.esprit.foyer.Repository.FoyerRep;
import tn.esprit.foyer.Repository.UniversiteRep; // Change the import statement

import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServiceImp implements IUniversiteService {

    private final UniversiteRep universiteRep;
    private final FoyerRep foyerRep;

    @Override
    public List<Universite> retrieveAllUniversities() { // Change the method name
        return (List<Universite>) universiteRep.findAll();
    }

    @Override
    public Universite updateUniversite(Universite universite) { // Change the method name and parameter
        return universiteRep.save(universite);
    }

    @Override
    public Universite addUniversite(Universite universite) { // Change the method name and parameter
        return universiteRep.save(universite);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) { // Change the method name
        return universiteRep.findById(idUniversite).orElse(null);
    }

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer=foyerRep.findById(idFoyer).orElse(null);
        Universite universite=universiteRep.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        return  universite;

    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRep.findById(idUniversite).orElse(null);
       universite.setFoyer(null);
       return universite;

    }


}
