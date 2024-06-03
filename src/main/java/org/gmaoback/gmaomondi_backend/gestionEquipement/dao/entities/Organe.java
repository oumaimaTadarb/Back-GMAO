package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.dao.entitites.Fournisseur;
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
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "idEquipement")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "idPrestataire")
    private Prestataire prestataire;

    @OneToMany(mappedBy = "organe")
    private List<Article> articles;


}
