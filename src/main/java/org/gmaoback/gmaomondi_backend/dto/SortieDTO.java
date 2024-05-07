package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortieDTO {

    private Long idSortie;
    private Date dateDemande;
    private Date dateValidation;
    private String commentaire;
    private String document;

    private String etat; // Enum as String for easier handling in JSON etc.
    private Long personneId; // Include only the ID to minimize data load

    // List of ArticleSortie IDs or DTOs, depending on the depth of data needed
    private List<Long> articleSortieIds;

}
