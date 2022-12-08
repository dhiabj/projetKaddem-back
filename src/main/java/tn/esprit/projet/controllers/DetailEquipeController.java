package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.services.IDetailEquipe;
import tn.esprit.projet.services.IEquipeService;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DetailEquipeController {
    @Autowired
    IDetailEquipe iDetailEquipe;

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe)
    {
        return iDetailEquipe.addDetailEquipe(detailEquipe);
    }

    @GetMapping("/getAllDetailEquipes")
    public List<DetailEquipe> retrieveAllDetailEquipes()
    {
        return iDetailEquipe.getAllDE();
    }

    @GetMapping("/getDEquipe/{id}")
    public DetailEquipe retrieveEquipe(@PathVariable Integer id)
    {
        return iDetailEquipe.getDe(id);
    }

    @DeleteMapping("/removeDEquipe/{id}")
    public void removeDetailEquipe(@PathVariable Integer id) {
        iDetailEquipe.removeDetailEquipe(id);
    }
    @CrossOrigin(origins ="*")
    @PutMapping("/updateDEquipe/{id}")
    public DetailEquipe updateEquipe(@RequestBody DetailEquipe e, @PathVariable Integer id) {
        return iDetailEquipe.updateDetailEquipe(e,id);
    }
}

