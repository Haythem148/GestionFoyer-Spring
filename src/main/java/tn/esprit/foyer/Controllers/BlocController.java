package tn.esprit.foyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.Entity.Bloc;
import tn.esprit.foyer.Service.IBlocService;

import java.util.List;

@RestController
@RequestMapping("blocs")
@RequiredArgsConstructor
public class BlocController {

    private final IBlocService iBlocService;

    @GetMapping
    public List<Bloc> retrieveAllBlocs() {
        return iBlocService.retrieveBlocs();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return iBlocService.addBloc(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return iBlocService.updateBloc(bloc);
    }

    @GetMapping("{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("{idBloc}")
    public boolean removeBloc(@PathVariable long idBloc) {
       return iBlocService.removeBloc(idBloc);
    }
}
