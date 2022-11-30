package tn.esprit.projet.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne
    private Equipe Equipe ;
}
