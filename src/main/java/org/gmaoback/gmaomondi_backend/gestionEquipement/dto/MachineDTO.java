package org.gmaoback.gmaomondi_backend.gestionEquipement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineDTO {
    private Long idMachine;
    private String designation;
    private LocalDateTime dateMiseEnService;
    private String descriptionTechnique;
    private Long fournisseurId;
    private Long ligneId;
    private List<Long> equipementIds;
}
