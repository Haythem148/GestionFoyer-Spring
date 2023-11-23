package tn.esprit.foyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.Entity.Foyer;
import tn.esprit.foyer.Repository.FoyerRep;
import tn.esprit.foyer.Service.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("foyer")
@RequiredArgsConstructor

public class FoyerController {
   final IFoyerService iFoyerService;
@PostMapping
Foyer addFoyer(@RequestBody Foyer f){
    return iFoyerService.addFoyer(f);
}
@PutMapping
    Foyer updateFoyer(@RequestBody Foyer f){
    return iFoyerService.updateFoyer(f);
}
@GetMapping("{idFoyer}")
Foyer retrieveFoyer(@PathVariable long idFoyer){
    return iFoyerService.retrieveFoyer(idFoyer);
}
@GetMapping
    List<Foyer> retrieveAllFoyers(){
    return iFoyerService.retrieveAllFoyers();
}
@DeleteMapping("{idFoyer}")
boolean removeFoyer(long idFoyer){
    return iFoyerService.removeFoyer(idFoyer);
}
@PostMapping("{idUniversite}")
Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long idUniversite){
    return iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);

}
@PutMapping("{idFoyer}/{idBloc}")
    public Foyer affecterBlocsAFoyer(@PathVariable long idBloc,@PathVariable long idFoyer){
    return iFoyerService.affecterBlocsAFoyer(idBloc,idFoyer);
}
}
