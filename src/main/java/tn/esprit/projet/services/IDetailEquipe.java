package tn.esprit.projet.services;

import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;

import java.util.List;

public interface IDetailEquipe {
    public DetailEquipe addDetailEquipe(DetailEquipe D) ;
    public List<DetailEquipe> getAllDE();
    public DetailEquipe getDe(Integer id);
    void removeDetailEquipe (Integer id);
    DetailEquipe updateDetailEquipe (DetailEquipe e, Integer idEquipe);
}
