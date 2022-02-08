package sn.pharmacie.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pharmacie")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pharmacie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", length = 25, nullable = false)
    private String nom;

    @Column(name = "quartier", length = 50, nullable = false)
    private String quartier;

    @Column(name = "ville", length = 50, nullable = false)
    private String ville;

    @Column(name = "etat", nullable = false)
    private int etat;

}
