package tn.esprit.projet.services;

import tn.esprit.projet.entities.Contrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IContratService {
   public List<Contrat> retrieveAllContrats();

   public Contrat addContrat (Contrat ce);
   public Contrat updateContrat (Contrat ce, Integer idContrat);
   public Contrat retrieveContrat (Integer idContrat);
    public void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant ( Integer idContrat, Integer idEtudiant);

    Integer nbContratsValides(LocalDate startDate, LocalDate endDate);
    Integer getMontantContratEntreDeuxDate(LocalDate statDate, LocalDate endDate);
    List<Contrat> getContratsEntreDeuxDate(LocalDate statDate, LocalDate endDate);

    public void retrieveAndUpdateStatusContrat();
}
