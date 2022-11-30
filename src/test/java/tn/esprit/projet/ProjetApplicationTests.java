package tn.esprit.projet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.projet.repository.EtudiantRepository;

@SpringBootTest
class ProjetApplicationTests {

    @Autowired
    private EtudiantRepository etudRep;


    @Test
    void contextLoads() {
    }

}
