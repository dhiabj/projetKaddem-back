package tn.esprit.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.repository.DetailEquipeRepository;
import tn.esprit.projet.repository.EquipeRepository;

import java.util.List;

@Service
public class DetailEquipeService implements IDetailEquipe{
    @Autowired
    DetailEquipeRepository detailEquipeRepository;
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe D) {
        return detailEquipeRepository.save(D);
    }

    @Override
    public List<DetailEquipe> getAllDE() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe getDe(Integer id){ return detailEquipeRepository.findById(id).orElse(null);}

    @Override
    public void removeDetailEquipe (Integer id){
        detailEquipeRepository.deleteById(id);

    }
    @Override
    public DetailEquipe updateDetailEquipe (DetailEquipe e, Integer id){
        DetailEquipe de= detailEquipeRepository.findById(id).orElse(null);
        de.setSalle(e.getSalle());
        de.setThematique(e.getThematique());
        return detailEquipeRepository.save(de);


    }
}
