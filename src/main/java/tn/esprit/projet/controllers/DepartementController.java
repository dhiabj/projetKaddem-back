package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.services.IDepartementService;

import java.util.List;
import java.util.Set;

@RestController
public class DepartementController {

    @Autowired
    IDepartementService iDepartementService;

@GetMapping("/Departements")
    public List<Departement> retrieveAllDepartements() {
        return iDepartementService.retrieveAllDepartements();
    }

@PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement d) {
        return iDepartementService.addDepartement(d);
    }

@PutMapping("/updateDepartement/{idDepart}")
    public Departement updateDepartement(@RequestBody Departement d, @PathVariable Integer idDepart) {
        return iDepartementService.updateDepartement(d,idDepart);
    }

@GetMapping("/Departement/{idDepart}")
    public Departement retrieveDepartement(@PathVariable Integer idDepart) {
        return iDepartementService.retrieveDepartement(idDepart);
    }

    @GetMapping(value = "/departments/{idUniversite}")
    @ResponseBody
    public Set<Departement> getAllEtudiantsbyDepartmentId(@PathVariable("idUniversite")Integer idUniversite) {
        return iDepartementService.retrieveDepartementsByUniversite(idUniversite) ;
    }
}
