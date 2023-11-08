package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Foyer;

public interface FoyerRep extends CrudRepository<Foyer,Long> {
}
