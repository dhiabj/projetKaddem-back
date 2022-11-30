package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Integer> {
}
