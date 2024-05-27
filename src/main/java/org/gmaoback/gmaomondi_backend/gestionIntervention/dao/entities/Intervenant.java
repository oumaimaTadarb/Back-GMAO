package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntervenant")
    private Long idIntervenant ;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "specialite", length = 100)
    private String specialite;

    @OneToMany(mappedBy = "intervenant")
    private List<Intervention> interventions;

}
