package tn.esprit.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;
    @ManyToMany(mappedBy = "listEquipes")
    private Set<Etudiant> listEtud;
    @OneToOne
    private DetailEquipe detailEquipe;


}
