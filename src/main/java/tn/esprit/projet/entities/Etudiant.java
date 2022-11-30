package tn.esprit.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Etudiant {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Setter(AccessLevel.NONE)
       private int idEtudiant;
    private  String prenomE;
    private  String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    private Set<Equipe> listEquipes = new HashSet<>();
    @OneToMany(mappedBy = "etudiant")
    private Set <Contrat> listContrat = new HashSet<>();



}
