package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.dao.entitites.Fournisseur;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMachine")
    private Long idMachine;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "dateMiseEnService")
    private LocalDateTime dateMiseEnService;

    @Column(name = "descriptionTechnique", length = 500)
    private String descriptionTechnique;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany
    @JoinColumn(name = "machine")
    private List<Equipement> equipements;

    @ManyToOne
    @JoinColumn(name = "idLigne")
    private Ligne ligne;
}
