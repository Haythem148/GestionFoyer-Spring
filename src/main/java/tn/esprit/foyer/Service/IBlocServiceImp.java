package tn.esprit.foyer.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Entity.Chambre;
import tn.esprit.foyer.Entity.Universite;
import tn.esprit.foyer.Repository.BlocRep;
import tn.esprit.foyer.Repository.ChambreRep;

import java.util.*;

@Service
@RequiredArgsConstructor
public class IBlocServiceImp implements IBlocService {

    private final BlocRep blocRep;
    private final ChambreRep chambreRep;


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


    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRep.findById(idBloc).orElse(null);
        Set<Chambre> chambres = new HashSet<>();
        for(Long id : numChambre) {
            chambres.add(chambreRep.findById(id).orElse(null));
            chambreRep.findById(id).orElse(null).setBloc(bloc);
            chambreRep.saveAll(chambres);
        }
        bloc.setChambres(chambres);
        return bloc;
    }
}

