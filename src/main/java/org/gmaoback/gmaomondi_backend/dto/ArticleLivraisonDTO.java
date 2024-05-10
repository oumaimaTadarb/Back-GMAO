package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLivraisonDTO {
    private Long id;
    private int quantiteLivraison;
    private Long articleId;
    private Long bonLivraisonId;
    private Long idBonCommande;
}
