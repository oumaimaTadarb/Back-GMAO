package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
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

    private String etat;
    private Long idPersonne;

     private List<Long> articleSortieIds;

}
