package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionEquipement.enums.Etat;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "equipement")
public class Equipement  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipement ")
    private Long idEquipement  ;

    @Column(name = "zone")
    private String zone;

    @Column(name = "designation")
    private String designation;

    @Column(name = "descriptionTechnique", length = 500)
    private String descriptionTechnique;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    @JsonIgnore
    private Fournisseur fournisseur;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "idPrestataire")
    @JsonIgnore
    private Prestataire prestataire;

    @ManyToOne
    @JoinColumn(name = "idMachine")
    @JsonIgnore
    private Machine machine;

    @OneToMany(mappedBy = "equipement")
    @JsonIgnore
    private List<Organe> organes;


}

