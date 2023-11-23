package tn.esprit.foyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.Entity.Universite;
import tn.esprit.foyer.Service.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("universites")
@RequiredArgsConstructor
public class UniversiteController {

    private final IUniversiteService iUniversiteService;

    @GetMapping
    public List<Universite> retrieveAllUniversites() {
        return iUniversiteService.retrieveAllUniversities();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return iUniversiteService.addUniversite(universite);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite universite) {
        return iUniversiteService.updateUniversite(universite);
    }

    @GetMapping("{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite);
    }
    @PutMapping("{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer,@PathVariable String nomUniversite){
        return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }
    @PutMapping("{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite){
        return iUniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }


}
