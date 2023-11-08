package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Universite; // Change the import statement
import tn.esprit.foyer.Repository.UniversiteRep; // Change the import statement

import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServiceImp implements IUniversiteService {

    private final UniversiteRep universiteRep;

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


}
