package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleDTO {
    private Long idArticle;
    private Long codeSapArticle;
    private String designation;
    private String emplacementPhysique;
    private int stockMin;
    private int stockMax;
    private int stockSecurite;
    private int stockDisponible;
    private String donneeTechnique;
    private String refFournisseur;

    private Long idFamille;


}
