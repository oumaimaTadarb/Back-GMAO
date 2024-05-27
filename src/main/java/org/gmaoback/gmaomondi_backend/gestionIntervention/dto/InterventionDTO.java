package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterventionDTO {
    private Long idIntervention;
    private LocalDateTime dateDemande;
    private String classification;
    private String degreDimpact;
    private String motifIntervention;
    private LocalDateTime dateReception;
    private String typeDAnomalie;
    private String degrePriorite;
    private String causesRacines;
    private Date dateValidation;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    private Long idEquipement;
    private Long idIntervenant;
    private Long idDemandeur;

}
