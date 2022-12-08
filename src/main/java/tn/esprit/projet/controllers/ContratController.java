package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.services.IContratService;

import java.util.Date;
import java.util.List;

@RestController
public class ContratController {

    @Autowired
    IContratService iContratService;

    @GetMapping("/Contrats")
   public List<Contrat> retrieveAllContrats()
    {
        return iContratService.retrieveAllContrats();
    }

    @PostMapping("/addContrat")
   public Contrat addContrat (@RequestBody Contrat ce)
    {
        return iContratService.addContrat(ce);
    }
    @PutMapping("/updateContrat/{idContrat}")
   public Contrat updateContrat (@RequestBody Contrat ce, @PathVariable Integer idContrat )
    {
        return iContratService.updateContrat(ce, idContrat);

    }

    @GetMapping("/Contrat/{idContrat}")
   public Contrat retrieveContrat (@PathVariable Integer idContrat)
    {
        return iContratService.retrieveContrat(idContrat);

    }

    @DeleteMapping("/removeContrat/{idContrat}")
   public void removeContrat(@PathVariable Integer idContrat)
    {
        iContratService.removeContrat(idContrat);

    }

    @PutMapping(value = "/affectContratToEtudiant/{nomE}/{prenomE}")
    @ResponseBody
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable String nomE, @PathVariable String prenomE) {
        return  iContratService.affectContratToEtudiant(c, nomE, prenomE);

    }

    @GetMapping(value = "/nbContratsValides")
    @ResponseBody
    public int getAllContratValides(@RequestBody Date d1, @RequestBody Date d2 ) {
        return iContratService.nbContratsValides(d1,d2);
    }
}
