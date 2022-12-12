package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.services.IContratService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping(value = "/affectContratToEtudiant/{idContrat}/{idEtudiant}")
    @ResponseBody
    public Contrat affectContratToEtudiant( @PathVariable Integer idContrat, @PathVariable Integer idEtudiant) {
        return  iContratService.affectContratToEtudiant( idContrat, idEtudiant);

    }

    @GetMapping(value = "/nbContratsValides/{startDate}/{endDate}")
    public Integer getAllContratValides(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate ) {
        return iContratService.nbContratsValides(startDate,endDate);
    }

    @GetMapping(value = "/sumMontant/{startDate}/{endDate}")
    public Integer getMontantContratEntreDeuxDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate ) {
        return iContratService.getMontantContratEntreDeuxDate(startDate,endDate);
    }

    @GetMapping(value = "/contrats/{startDate}/{endDate}")
    public List<Contrat> getAllContratsBetweenTwoDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate ) {
        return iContratService.getContratsEntreDeuxDate(startDate,endDate);
    }
}
