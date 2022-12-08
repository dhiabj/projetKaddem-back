package tn.esprit.projet.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.*;
import tn.esprit.projet.repository.ContratRepository;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.repository.EquipeRepository;
import tn.esprit.projet.repository.EtudiantRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServiceImp implements IEtudiantService{
    @Autowired
   private  EtudiantRepository etudiantRepository;

   private DepartementRepository departementRepository;
   private ContratRepository contratRepository;
   private EquipeRepository equipeRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }



    @Override
    public Etudiant updateEtudiant(Etudiant e, Integer idEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        etudiant.setNomE(e.getNomE());
        etudiant.setPrenomE(e.getPrenomE());
        etudiant.setOption(e.getOption());
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant etudiant= etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement= departementRepository.findById(departementId).orElse(null);
        if (etudiant!=null && departement!=null)
        {
            etudiant.setDepartement(departement);
            etudiantRepository.save(etudiant);
        }

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        e.getListContrat().add(contrat);
        e.getListEquipes().add(equipe);
        etudiantRepository.save(e);
        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        System.out.println(e.getListContrat());

        return e ;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepart) {
        return etudiantRepository.findAllByDepartement_IdDepart(idDepart);
    }
}
