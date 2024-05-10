package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDemandeDTO {
    private Long id;
    private int quantiteCommande;
    private Long articleId;
    private Long idBonCommande;
}
