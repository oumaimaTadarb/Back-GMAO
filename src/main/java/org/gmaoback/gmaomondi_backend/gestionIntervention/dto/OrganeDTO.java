package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganeDTO {
    private Long idOrgane;
    private String designation;
    private String descriptionTechnique;
    private Long idFournisseur;
    private Long idEquipement;
    private Long idPrestataire;
    private List<Long> articlesIds;
}
