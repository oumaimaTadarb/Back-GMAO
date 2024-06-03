package org.gmaoback.gmaomondi_backend.gestionStock.services.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSortieDTO {
    private Long idSortie;
    private Long idArticleSortie;
    private int quantite;
    private String usage;
    private String commentaire;
    private Long idArticle;
    private Long CodeSap;//get from article
    private String designation ;// get from article
    private String donneeTechnique;// get from article
}
