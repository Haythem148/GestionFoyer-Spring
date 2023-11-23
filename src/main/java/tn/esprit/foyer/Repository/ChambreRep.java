package tn.esprit.foyer.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Entity.Chambre;
import tn.esprit.foyer.Entity.TypeChambre;

import java.util.List;

public interface ChambreRep extends CrudRepository<Chambre,Long> {
    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> findChambresByNomUniversite(@Param("nomUniversite") String nomUniversite);




    //public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre
           // typeC) ;
    List <Chambre> findChambreByBloc_IdBlocAndTypeChambre(Long bloc_idBloc, TypeChambre typeChambre);

}
