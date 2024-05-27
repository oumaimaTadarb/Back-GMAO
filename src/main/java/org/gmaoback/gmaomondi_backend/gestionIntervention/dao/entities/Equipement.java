package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Etat;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Fournisseur;

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
    private Fournisseur fournisseur;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "idPrestataire")
    private Prestataire prestataire;

    @ManyToOne
    @JoinColumn(name = "idMachine")
    private Machine machine;

    @OneToMany(mappedBy = "equipement")
    private List<Organe> organes;

    @OneToMany(mappedBy = "equipement")
    private List<Intervention> interventions;

}

