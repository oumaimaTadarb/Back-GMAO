package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "demandeur")
public class Demandeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDemandeur")
    private Long idDemandeur ;
    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "specialite", length = 100)
    private String specialite;
    @OneToMany(mappedBy = "demandeur")
    private List<Intervention> interventions = new ArrayList<>();

}
