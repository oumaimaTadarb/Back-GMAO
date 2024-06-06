package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organe")
public class Organe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrgane")
    private Long idOrgane;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "descriptionTechnique", length = 500)
    private String descriptionTechnique;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    @JsonIgnore
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "idEquipement")
    @JsonIgnore
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "idPrestataire")
    @JsonIgnore
    private Prestataire prestataire;

    @OneToMany(mappedBy = "organe")
    @JsonIgnore
    private List<Article> articles;

    @Column(name = "bloc", length = 100)
    private String bloc;

}
