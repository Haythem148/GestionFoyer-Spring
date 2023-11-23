package tn.esprit.foyer.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.foyer.Entity.Universite;

public interface UniversiteRep extends CrudRepository<Universite,Long> {
    public Universite findByNomUniversite(String nomUniversite);
}
