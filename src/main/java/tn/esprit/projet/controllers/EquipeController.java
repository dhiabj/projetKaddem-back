package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.repository.EquipeRepository;
import tn.esprit.projet.services.IEquipeService;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;

    @Autowired
    EquipeRepository equipeRepository;
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

@PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return  iEquipeService.updateEquipe(e);
    }
    @GetMapping("/upgradeEquipe")
    public void faireEvoluerEquipes()
    {
        iEquipeService.faireEvoluerEquipes();
    }

    @GetMapping("/getEtudiantsByEquipe/{idEquipe}")
    public List<Etudiant> getEtudiantsByEquipe(@PathVariable Integer idEquipe) {
        return iEquipeService.getEtudiantsByEquipe(idEquipe);
    }

    @GetMapping("/countByNiveau/{niveau}")
    public int countByNiveau(@PathVariable Niveau niveau)
    {
        return equipeRepository.countByNiveau(niveau);
    }
    }
