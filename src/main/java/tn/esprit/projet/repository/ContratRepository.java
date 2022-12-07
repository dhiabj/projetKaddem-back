package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Contrat;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {


    public List<Contrat> findByArchiveIsFalse();

    public List<Contrat> findByArchiveIsFalseAndDateFinContrat(LocalDate localDate);

    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
    List<Contrat> findContratBetweenTwoDates(LocalDate startDate, LocalDate endDate);


}
