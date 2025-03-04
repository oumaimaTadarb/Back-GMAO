package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ligne")
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLigne")
    private Long idLigne;

    @Column(name = "nom", length = 100)
    private String nom;

    @OneToMany
    @JoinColumn(name = "idLigne")
    @JsonIgnore
    private List<Machine> machines;

}
