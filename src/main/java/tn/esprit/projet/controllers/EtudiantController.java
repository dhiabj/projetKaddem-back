package tn.esprit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Option;
import tn.esprit.projet.repository.EtudiantRepository;
import tn.esprit.projet.services.IEtudiantService;

import java.util.List;

@RestController
public class EtudiantController {

    @Autowired
    IEtudiantService iEtudiantService;

    @GetMapping("/Etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {

        return iEtudiantService.addEtudiant(e);
    }



    @PutMapping("/updateEtudiant/{idEtudiant}")
    public Etudiant updateEtudiant(@RequestBody Etudiant e, @PathVariable Integer idEtudiant) {
        return iEtudiantService.updateEtudiant(e,idEtudiant);
    }

    @GetMapping("/etudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable Integer idEtudiant) {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    public void removeEtudiant(@PathVariable Integer idEtudiant) {
        iEtudiantService.removeEtudiant(idEtudiant);

    }

    @PostMapping("/assignED/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId)
    {
this.iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PostMapping("/addAndAssignEEC/{idContrat}/{idEquipe}")
    public void  addAndAssignEtudiantToEquipeAndContract(@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe")Integer idEquipe,@RequestBody Etudiant e){
        iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @GetMapping(value = "/etudiants/departments/{departmentId}")
    @ResponseBody
    public List<Etudiant> getAllEtudiantsbyDepartmentId(@PathVariable("departmentId")Integer departmentId) {
        return iEtudiantService.getEtudiantsByDepartement(departmentId) ;
    }

}
