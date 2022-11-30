package tn.esprit.projet.services;

import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Option;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

   // Ajouter seulement
    Etudiant addEtudiant (Etudiant e);

   // Ajouter et affecter:

 Etudiant updateEtudiant (Etudiant e, Integer idEtudiant);
Etudiant retrieveEtudiant(Integer idEtudiant);

void removeEtudiant(Integer idEtudiant);
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepart);
}
