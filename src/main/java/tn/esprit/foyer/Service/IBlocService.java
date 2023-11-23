package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    boolean removeBloc (long idBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long
            idBloc) ;

}
