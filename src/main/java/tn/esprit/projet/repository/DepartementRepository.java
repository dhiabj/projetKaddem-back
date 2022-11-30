package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {


}
