package org.gmaoback.gmaomondi_backend.gestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDemandeDTO {
    private Long id;
    private Long idDA;
    private Long codeSapDA;
    private double prixUnitaire;
    private int quantiteDemande;
    private Long idBC;
    private Long idArticle;
    private String donneeTechnique;
    private String designation;
    private Long codeSapArticle;

}
