package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Etudiant;

public interface EtudiantRep extends CrudRepository<Etudiant,Long> {
}
