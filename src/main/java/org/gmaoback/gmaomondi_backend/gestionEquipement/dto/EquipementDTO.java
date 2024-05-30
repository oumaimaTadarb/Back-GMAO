package org.gmaoback.gmaomondi_backend.gestionEquipement.dto;

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
    private Long fournisseurId;
    private String etat;
    private Long prestataireId;
    private Long machineId;
    private List<Long> organeIds;
}
