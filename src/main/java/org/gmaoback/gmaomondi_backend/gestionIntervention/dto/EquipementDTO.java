package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipementDTO {
    private Long idEquipement;
    private String zone;
    private String designation;
    private String descriptionTechnique;
    private Long idFournisseur;
    private String etat;
    private Long idPrestataire;
    private Long idMachine;
    private List<Long> organesIds;
    private List<Long> interventionsIds;
}
