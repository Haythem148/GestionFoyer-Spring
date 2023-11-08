package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Repository.BlocRep;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IBlocServiceImp implements IBlocService {

    private final BlocRep blocRep;


    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRep.findAll();
    }



    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRep.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRep.save(b);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRep.findById(idBloc).orElse(null);
    }

    @Override
    public boolean removeBloc(long idBloc) {
        blocRep.deleteById(idBloc);
        return !blocRep.existsById(idBloc);
    }
}
