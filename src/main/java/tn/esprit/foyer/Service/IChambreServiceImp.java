package tn.esprit.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entity.Chambre;
import tn.esprit.foyer.Entity.TypeChambre;
import tn.esprit.foyer.Repository.ChambreRep;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IChambreServiceImp implements IChambreService {

    private final ChambreRep chambreRep;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRep.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRep.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRep.save(chambre);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRep.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRep.findChambresByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRep.findChambreByBloc_IdBlocAndTypeChambre(idBloc,typeC);
    }
}
