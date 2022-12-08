package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Contrat;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {


    public List<Contrat> findByArchiveIsFalse();

    public List<Contrat> findByArchiveIsFalseAndDateFinContrat(LocalDate localDate);


}
