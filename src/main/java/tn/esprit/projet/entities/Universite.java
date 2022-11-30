package tn.esprit.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Universite {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Setter(AccessLevel.NONE)
    private int idUniv;
    private String nomUniv;
    @OneToMany
    private Set<Departement> listDep;

}
