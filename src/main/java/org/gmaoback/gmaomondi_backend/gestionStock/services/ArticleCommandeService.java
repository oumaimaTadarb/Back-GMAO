package org.gmaoback.gmaomondi_backend.gestionStock.services;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleCommandeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleCommandeService {
    List<ArticleCommande> listArticlesCommmandeByIdBC(Long idBC);
    List<ArticleCommande>listArticlesCommandeByIdArticle(Long idArticle);
    ArticleCommande getArticleCommandeById(Long idAC);
    List<ArticleCommande>getArticlecommandebyidArticle(Long idBC,Long idArticle);
    BonCommande affectListArticleCommandeToBonCommande(Long idBC,List<ArticleCommande>listArticleCommande);
    ArticleCommande updateArticleBonCommande(ArticleCommande AC);
    void deleteArticleBonCommandeByIdAC(Long idAC);
    void deleteAllArticleCommandeofBonCommande(Long idBC);
    ArticleCommande convertDTO(ArticleCommandeDTO ACDTO);

}
