package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Classification;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Impact;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Priorite;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.TypeDAnomalie;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntervention")
    private Long idIntervention ;

    @Column(name="dateDemande")
    private LocalDateTime dateDemande;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification", length = 100)
    private Classification classification ;

    @Enumerated(EnumType.STRING)
    @Column(name = "degreDimpact", length = 100)
    private Impact degreDimpact ;

    @Column(name = "motifIntervention", length = 100)
    private String motifIntervention;

    @Column(name="dateReception")
    private LocalDateTime dateReception;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeDAnomalie", length = 100)
    private TypeDAnomalie typeDAnomalie ;

    @Enumerated(EnumType.STRING)
    @Column(name = "degrePriorite", length = 100)
    private Priorite degrePriorite;

    @Column(name = "causesRacines", length = 100)
    private String causesRacines;

    @Column(name="dateValidation")
    private Date dateValidation;

    @Column(name="heureDebut")
    private LocalTime heureDebut;

    @Column(name="heureFin")
    private LocalTime heureFin;

    @ManyToOne
    @JoinColumn(name = "idEquipement", referencedColumnName = "idEquipement")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "idIntervenant", referencedColumnName = "idIntervenant")
    private Intervenant intervenant;

    @ManyToOne
    @JoinColumn(name = "idDemandeur", referencedColumnName = "idDemandeur")
    private Demandeur demandeur;


}

