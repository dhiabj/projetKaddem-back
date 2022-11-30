package tn.esprit.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Universite;
import tn.esprit.projet.repository.DepartementRepository;
import tn.esprit.projet.repository.EtudiantRepository;
import tn.esprit.projet.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class DepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    IEtudiantService iEtudiantService;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d, Integer idDepart) {
        Departement departement = departementRepository.findById(idDepart).orElse(null);
        departement.setNomDepart(d.getNomDepart());
        return departementRepository.save(departement);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        //System.out.println(u.getDepartements());
        return u.getListDep();

    }


}
