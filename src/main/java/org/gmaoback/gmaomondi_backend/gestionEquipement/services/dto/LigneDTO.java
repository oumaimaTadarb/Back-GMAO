package org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneDTO {
    private Long idLigne;
    private String nom;
    private List<Long> machineIds;
}
