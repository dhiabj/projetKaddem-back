package tn.esprit.projet.services;

import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;

public interface IEquipeService {
    public Equipe addEquipe(Equipe equipe);
    public Equipe retrieveEquipe(Integer id);
    List<Equipe> retrieveAllEquipes();
    void removeEquipe (Integer idEquipe);
    Equipe updateEquipe (Equipe e);
    void faireEvoluerEquipes();
    List<Etudiant> getEtudiantsByEquipe (Integer idEquipe);
}
