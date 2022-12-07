package tn.esprit.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.repository.EquipeRepository;

import javax.persistence.Temporal;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipeServiceImp implements IEquipeService {
    @Autowired
    EquipeRepository equipeRepository;
    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe retrieveEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
       // System.out.println(equipeRepository.countByNiveau(Niveau.JUNIOR));
        return equipeRepository.findAll();

    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {

        return  equipeRepository.save(e);
    }


    @Transactional
    //@Scheduled(cron = "*/20*****")
    @Override
    public void faireEvoluerEquipes() {

        this.retrieveAllEquipes().stream()
                .filter(this::needToUpgrade)
                .filter(equipe -> !equipe.getNiveau().equals(Niveau.EXPERT))
                .forEach(equipe -> {
                    switch (equipe.getNiveau())
                    {
                        case JUNIOR:equipe.setNiveau(Niveau.SENIOR); break;
                        case SENIOR:equipe.setNiveau(Niveau.EXPERT);break;
                    }
                });

    }

    @Override
    public List<Etudiant> getEtudiantsByEquipe(Integer idEquipe) {
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        return new ArrayList<>( equipe.getListEtud());


    }

    public boolean needToUpgrade(Equipe equipe)
    {
        //LocalDate date1= LocalDate.now();
       // LocalDate date2= LocalDate.of(2020, 1, 8);
       // System.out.println(ChronoUnit.YEARS.between(date1,date2));

        int nbContrats= equipe.getListEtud().stream()
                .map(Etudiant::getListContrat)
                .flatMap(Set::stream)
                .filter(contrat -> contrat.getArchive().equals(false) &&
                        ChronoUnit.YEARS.between(  contrat.getDateDebutContrat(),contrat.getDateFinContrat())>1)
                .map(Contrat::getEtudiant)
                .distinct()
                .collect(Collectors.toSet())
                .size();
        System.out.println(nbContrats);
        System.out.println(nbContrats>2);
        return  nbContrats>2;
    }


}
