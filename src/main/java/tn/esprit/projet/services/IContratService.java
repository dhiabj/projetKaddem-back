package tn.esprit.projet.services;

import tn.esprit.projet.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
   public List<Contrat> retrieveAllContrats();

   public Contrat addContrat (Contrat ce);
   public Contrat updateContrat (Contrat ce, Integer idContrat);
   public Contrat retrieveContrat (Integer idContrat);
    public void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    Integer nbContratsValides(Date startDate, Date endDate);

    public void retrieveAndUpdateStatusContrat();
}
