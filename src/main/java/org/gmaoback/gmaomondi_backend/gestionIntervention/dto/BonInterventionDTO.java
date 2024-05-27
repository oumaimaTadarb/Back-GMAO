package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonInterventionDTO {
    private Long idBonIntervention;
    private Long idIntervention;
    private LocalDateTime dateDemande;
    private String classification;
    private String degreDimpact;
    private String motifIntervention;
    private LocalDateTime dateReception;
    private String typeDAnomalie;
    private String degrePriorite;
    private String causesRacines;
    private LocalDateTime dateValidation;
    private LocalTime heureDebut;
    private LocalTime heureFin;
}
