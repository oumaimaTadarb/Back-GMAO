package org.gmaoback.gmaomondi_backend.gestionMaintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenancePreventiveDTO extends MaintenanceDTO{
    private List<Long> gammeIds;
}
