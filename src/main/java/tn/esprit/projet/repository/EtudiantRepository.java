package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Option;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    List<Etudiant> findAllByDepartement_IdDepart(Integer idDepart) ;
    Etudiant findByNomEAndPrenomE(String nomE, String prenomE) ;


   // Etudiant save(Etudiant e, Option o);
}
