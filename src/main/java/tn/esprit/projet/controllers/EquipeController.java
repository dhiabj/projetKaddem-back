package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.services.IEquipeService;

import java.util.List;

@RestController
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;
//localhost:9090/addEquipe
    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe equipe)
    {
        return iEquipeService.addEquipe(equipe);
    }

    @GetMapping("/getEquipe/{id}")
    public Equipe retrieveEquipe(@PathVariable Integer id)
    {
        return iEquipeService.retrieveEquipe(id);
    }
    @GetMapping("/getAllEquipes")
    public List<Equipe> retrieveAllEquipes()
    {
        return iEquipeService.retrieveAllEquipes();
    }

    @DeleteMapping("/removeEquipe/{idEquipe}")
    public void removeEquipe(@PathVariable Integer idEquipe) {
        iEquipeService.removeEquipe(idEquipe);
    }

@PutMapping("/updateEquipe/{idEquipe}")
    public Equipe updateEquipe(@RequestBody Equipe e, @PathVariable Integer idEquipe) {
        return  iEquipeService.updateEquipe(e,idEquipe);
    }

}
