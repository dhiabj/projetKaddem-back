package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @JsonIgnore
    @ManyToMany(mappedBy = "listEquipes")
    private Set<Etudiant> listEtud;
    @OneToOne
    private DetailEquipe detailEquipe;


}
