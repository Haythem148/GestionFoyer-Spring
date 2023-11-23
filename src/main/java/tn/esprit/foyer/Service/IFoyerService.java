package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer addFoyer (Foyer f);
    public Foyer updateFoyer (Foyer f);
    public Foyer retrieveFoyer (long idFoyer);
    public boolean removeFoyer (long idFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
    public Foyer affecterBlocsAFoyer(long idBloc,long idFoyer);
}
