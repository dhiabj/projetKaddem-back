package tn.esprit.projet.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.repository.ContratRepository;
import tn.esprit.projet.repository.EtudiantRepository;
import tn.esprit.projet.util.HelperClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ContratServiceImp implements IContratService {

    @Autowired /*field injection*/
    ContratRepository contratRepository;


    private EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();



    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce, Integer idContrat) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        contrat.setDateFinContrat(ce.getDateFinContrat());
        contrat.setDateDebutContrat(ce.getDateDebutContrat());
        contrat.setArchive(ce.getArchive());
        contrat.setSpecialite(ce.getSpecialite());
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant  etudiant = etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        int sommeContratActive = 0;
        sommeContratActive = (int) etudiant.getListContrat().stream().filter(c->c.getArchive()).count();
        if(sommeContratActive <5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        }
        return contratRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> listeallcontrats = contratRepository.findAll();

        return ( int ) listeallcontrats.stream().filter(c-> !c.getArchive()).count();
    }

    @Transactional
    //use this annotation to commit all managed entities without using the save function ""contartRepository.save(..).""
    public void archiveAllExpiredContracts(){
        contratRepository.findByArchiveIsFalseAndDateFinContrat(LocalDate.now()).stream()
                .forEach(contrat -> contrat.setArchive(true));
    }
    @Override
    public void retrieveAndUpdateStatusContrat() {
        /*
        //Archive all exprired contracts
        this.archiveAllExpiredContracts();

        contratRepository.findByArchiveIsFalse()
                .stream()
                .filter(contrat -> HelperClass.getDate(LocalDate.now(),contrat.getDateFinContrat())<16)
                .forEach(contrat -> System.out.println("le contrat de l'etudiant"+contrat.getEtudiant().getNomE()+"va exprirer"));
   */ }
}
