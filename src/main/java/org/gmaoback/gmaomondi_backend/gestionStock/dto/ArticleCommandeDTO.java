package org.gmaoback.gmaomondi_backend.gestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommandeDTO {
    private Long id;
    private Long idBC;
    private Long codeSapBC;
    private Long idArticle;
    private int quantiteCommande;
    private String designation ;
    private Long CodeSapArticle;
    private String donneeTechnique;
    private double prixUnitaire;

}
