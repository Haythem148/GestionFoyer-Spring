package tn.esprit.foyer.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Entity.Chambre;
import tn.esprit.foyer.Repository.BlocRep;
import tn.esprit.foyer.Repository.ChambreRep;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return blocRep.findById(idBloc)
                .orElseThrow(() -> new IllegalArgumentException("No bloc found with this id: " + idBloc));
    }

    @Override
    public boolean removeBloc(long idBloc) {
        blocRep.deleteById(idBloc);
        return !blocRep.existsById(idBloc);
    }

    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRep.findById(idBloc)
                .orElseThrow(() -> new IllegalArgumentException("No bloc found with this id: " + idBloc));
        Set<Chambre> chambres = new HashSet<>();
        for (Long id : numChambre) {
            Chambre chambre = chambreRep.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("No chambre found with this id: " + id));
            chambres.add(chambre);
            chambre.setBloc(bloc);
        }
        bloc.setChambres(chambres);
        chambreRep.saveAll(chambres);
        return bloc;
    }


}