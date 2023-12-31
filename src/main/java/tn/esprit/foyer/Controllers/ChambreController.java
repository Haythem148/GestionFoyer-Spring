package tn.esprit.foyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.Entity.Chambre;
import tn.esprit.foyer.Entity.TypeChambre;
import tn.esprit.foyer.Service.IChambreService;

import java.util.List;

@RestController
@RequestMapping("chambres")
@RequiredArgsConstructor
public class ChambreController {

    private final IChambreService iChambreService;

    @GetMapping
    public List<Chambre> retrieveAllChambres() {
        return iChambreService.retrieveAllChambres();
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return iChambreService.addChambre(chambre);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return iChambreService.updateChambre(chambre);
    }

    @GetMapping("{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {
        return iChambreService.retrieveChambre(idChambre);
    }
    @GetMapping("/getbyUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(String nomUniversite){
        return iChambreService.getChambresParNomUniversite(nomUniversite);
    }
    @GetMapping("/getbyidBloc/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc,@PathVariable TypeChambre typeC){
        return iChambreService.getChambresParBlocEtType(idBloc,typeC);
    }
}
