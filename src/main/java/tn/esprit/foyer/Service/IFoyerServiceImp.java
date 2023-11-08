package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Foyer;
import tn.esprit.foyer.Repository.FoyerRep;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IFoyerServiceImp implements IFoyerService {

private  final FoyerRep foyerRep;


    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>)  foyerRep.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRep.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRep.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRep.findById(idFoyer).orElse(null);
    }

    @Override
    public boolean removeFoyer(long idFoyer) {
        foyerRep.deleteById(idFoyer);
        return !foyerRep.existsById(idFoyer);
    }
}
