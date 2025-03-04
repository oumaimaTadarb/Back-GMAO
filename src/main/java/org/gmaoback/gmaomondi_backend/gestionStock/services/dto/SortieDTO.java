package org.gmaoback.gmaomondi_backend.gestionStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortieDTO {

    private Long idSortie;
    private LocalDateTime dateDemande;
    private LocalDateTime dateValidation;
    private String commentaire;
    private String document;

    private EtatSortie etat;
    private Long idPersonne;

     private List<Long> articleSortieIds;

}
