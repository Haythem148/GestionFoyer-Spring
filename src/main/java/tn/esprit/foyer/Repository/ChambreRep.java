package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Chambre;

public interface ChambreRep extends CrudRepository<Chambre,Long> {
}
