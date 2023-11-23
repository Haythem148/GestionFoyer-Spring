package tn.esprit.foyer.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Entity.Foyer;
import tn.esprit.foyer.Entity.Universite;
import tn.esprit.foyer.Repository.BlocRep;
import tn.esprit.foyer.Repository.FoyerRep;
import tn.esprit.foyer.Repository.UniversiteRep;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IFoyerServiceImp implements IFoyerService {

private  final FoyerRep foyerRep;
private final UniversiteRep universiteRep;
private  final BlocRep blocRep;


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

    @Override

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRep.findById(idUniversite).orElse(null);
        foyer.setUniversite(universite);
        universite.setFoyer(foyer);
       return  foyerRep.save(foyer);
    }

    @Override
    public Foyer affecterBlocsAFoyer(long idBloc, long idFoyer) {
        Bloc bloc = blocRep.findById(idBloc).orElse(null);
        Foyer foyer = foyerRep.findById(idFoyer).orElse(null);
        Set<Bloc> blocs=new HashSet<>();
        blocs.add(bloc);
        foyer.setBlocs(blocs);
        bloc.setFoyer(foyer);
        blocRep.save(bloc);
        return foyerRep.save(foyer);
    }
}
