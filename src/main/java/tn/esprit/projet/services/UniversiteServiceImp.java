package tn.esprit.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteServiceImp implements IUniversiteService{
@Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u, Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        universite.setNomUniv(u.getNomUniv());
        return universiteRepository.save(universite);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u   = universiteRepository.findById(idUniversite).get();
        Departement departement = departementRepository.findById(idDepartement).get();
        u.getListDep().add(departement);
        universiteRepository.save(u);
    }
}
