package org.gmaoback.gmaomondi_backend.gestionMaintenance.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "planing")
public class Planing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaning;

//    @OneToMany(mappedBy = "planing")
//    private List<Maintenance> maintenances;
}
