package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

int countByNiveau(Niveau niveau);

}
