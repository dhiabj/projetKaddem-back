package tn.esprit.projet.services;

import tn.esprit.projet.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public Equipe addEquipe(Equipe equipe);
    public Equipe retrieveEquipe(Integer id);
    List<Equipe> retrieveAllEquipes();
    void removeEquipe (Integer idEquipe);
    Equipe updateEquipe (Equipe e, Integer idEquipe);
}
