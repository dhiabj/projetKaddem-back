package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.repository.UniversiteRepository;
import tn.esprit.projet.services.IUniversiteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping("/Universites")
    public List<Universite> retrieveAllUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversite/{idUniversite}")
    public Universite updateUniversite(@RequestBody Universite u, @PathVariable Integer idUniversite) {
        return iUniversiteService.updateUniversite(u,idUniversite);
    }

    @GetMapping("/universite/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable Integer idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite);
    }

    @DeleteMapping("/removeUniversite/{idUniversite}")
    public void removeUniversite( @PathVariable Integer idUniversite) {
        iUniversiteService.removeUniversite(idUniversite);
    }

    @PostMapping("/assignUD/{idUniversite}/{idDepartement}")
    public void  assignUniversiteToDepartement(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement")Integer idDepartement){
        iUniversiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
}
