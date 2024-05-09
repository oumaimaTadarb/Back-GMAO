package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommandeDTO {
    private Long id;
    private int quantiteCommande;
    private Long idArticle;
    private Long bonCommandeId;
}
