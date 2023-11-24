package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiants (Etudiant etudiant);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    boolean removeEtudiant(long idEtudiant);
}
