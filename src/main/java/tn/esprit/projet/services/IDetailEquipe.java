package tn.esprit.projet.services;

import tn.esprit.projet.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipe {
    public DetailEquipe addDetailEquipe(DetailEquipe D) ;
    public List<DetailEquipe> getAllDE();
}
