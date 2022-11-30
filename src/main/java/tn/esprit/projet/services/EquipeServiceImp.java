package tn.esprit.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.repository.EquipeRepository;

import java.util.List;

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
        return equipeRepository.findAll();
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe updateEquipe(Equipe e, Integer idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        equipe.setNomEquipe(e.getNomEquipe());
        equipe.setNiveau(e.getNiveau());
        return  equipeRepository.save(equipe);
    }


}
