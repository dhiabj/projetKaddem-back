package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDepart;
    private String nomDepart;
    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private Set <Etudiant> listEtud;



}
