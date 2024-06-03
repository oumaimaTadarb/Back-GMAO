package org.gmaoback.gmaomondi_backend.gestionMaintenance.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GammeDTO {
    private Long idGamme;
    private String refGamme;
    private String nature;
    private String frequence;
    private Long maintenancePreventiveId;
}
