package org.gmaoback.gmaomondi_backend.gestionMaintenance.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Personne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @ManyToOne
    @JoinColumn(name = "idOrgane")
    private Organe organe;

    @ManyToOne
    @JoinColumn(name = "idPersonne")
    private Personne personne;
}
