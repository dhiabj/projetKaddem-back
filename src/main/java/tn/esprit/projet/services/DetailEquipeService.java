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

    @Override
    public Integer getNbrThematiqueLangue() {
     int nbr = (int) detailEquipeRepository.findAll().stream().filter(
             de-> de.getThematique().toString()=="LANGUE"
     ).count();
        return  nbr;
    }

    @Override
    public Integer getNbrThematiqueScience() {
        int nbr = (int) detailEquipeRepository.findAll().stream().filter(
                de-> de.getThematique().toString()=="SCIENTIFIQUE"
        ).count();
        return  nbr;
    }
    @Override
    public Integer getNbrThematiqueMaths() {
        int nbr = (int) detailEquipeRepository.findAll().stream().filter(
                de-> de.getThematique().toString()=="MATHEMATIQUE"
        ).count();
        return  nbr;
    }
    @Override
    public Integer getNbrThematiqueHistoire() {
        int nbr = (int) detailEquipeRepository.findAll().stream().filter(
                de-> de.getThematique().toString()=="HISTOIRE"
        ).count();
        return  nbr;
    }
}
