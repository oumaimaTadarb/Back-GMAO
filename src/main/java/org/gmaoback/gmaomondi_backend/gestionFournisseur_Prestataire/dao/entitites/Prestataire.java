package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PrestataireService")
public class Prestataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestataire")
    private Long idPrestataire  ;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @OneToMany
    private List<Equipement> equipements;
}
