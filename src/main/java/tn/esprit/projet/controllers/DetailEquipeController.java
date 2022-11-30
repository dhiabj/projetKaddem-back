package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.services.IDetailEquipe;
import tn.esprit.projet.services.IEquipeService;

import java.util.List;

@RestController
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
}
