package org.gmaoback.gmaomondi_backend.gestionMaintenance.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    private Long idMaintenance;
    private Long organeId;
    private Long personneId;
}
