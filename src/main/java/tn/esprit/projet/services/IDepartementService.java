package tn.esprit.projet.services;

import tn.esprit.projet.entities.Departement;

import java.util.List;
import java.util.Set;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);
 Departement updateDepartement (Departement d, Integer idDepart);
 Departement retrieveDepartement(Integer idDepart);
 public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);


}
