package tn.esprit.projet.services;

import tn.esprit.projet.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u, Integer idUniversite);
   Universite retrieveUniversite (Integer idUniversite);
   void removeUniversite (Integer idUniversite);

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
