package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

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
    private Long organeId;
}
