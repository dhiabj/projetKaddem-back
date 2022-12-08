package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("etudiant")
    private Set<Equipe> listEquipes = new HashSet<>();
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set <Contrat> listContrat = new HashSet<>();



}
