package org.gmaoback.gmaomondi_backend.gestionStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLivraisonDTO {
    private Long id;
    private int quantiteLivraison;
    private Long idArticle;
    private Long idBL;
    private Long idBC;
    private Long codeSapBC;
    private Long codeSapBL;
    private Long codeSapArticle;
}
