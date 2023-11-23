package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Entity.Chambre;

import java.util.List;

public interface BlocRep extends CrudRepository<Bloc,Long> {

}
