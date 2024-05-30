package org.gmaoback.gmaomondi_backend.gestionMaintenance.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class MaintenanceCorrectiveDTO {
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
    private Long equipementId;
}
