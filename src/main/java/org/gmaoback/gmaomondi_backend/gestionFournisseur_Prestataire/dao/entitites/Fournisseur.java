package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFournisseur")
    private Long idFournisseur;

    @Column(name = "codeSapFr")
    private Long  codeSapFr;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "adresse", length = 100)
    private String adresse;

    @OneToMany(mappedBy = "fournisseur")
    private List<Equipement> equipements;

    @OneToMany(mappedBy = "fournisseur")
    private List<Machine> machines;

    @OneToMany(mappedBy = "fournisseur")
    private List<Organe> organes;

    @OneToMany(mappedBy = "fournisseur")
    private List<Article> articles;


}
