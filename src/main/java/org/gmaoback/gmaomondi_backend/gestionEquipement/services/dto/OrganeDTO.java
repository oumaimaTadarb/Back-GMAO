package org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto;

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
    private String bloc;
    private String descriptionTechnique;
    private Long fournisseurId;
    private Long equipementId;
    private Long prestataireId;
    private List<Long> articleIds;
}
