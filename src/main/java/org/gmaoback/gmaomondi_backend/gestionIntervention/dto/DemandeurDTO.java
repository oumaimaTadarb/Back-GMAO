package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeurDTO {
    private Long idDemandeur;
    private String nom;
    private String specialite;
    private List<Long> interventionIds;
}

