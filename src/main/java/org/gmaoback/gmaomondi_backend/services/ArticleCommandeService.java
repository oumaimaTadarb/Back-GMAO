package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.ArticleCommande;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;
import org.gmaoback.gmaomondi_backend.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.dto.ArticleCommandeDTO;
import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleCommandeService {
    List<ArticleCommande> listArticlesCommmandeByIdBC(Long idBC);
    List<ArticleCommande>listArticlesCommandeByIdArticle(Long idArticle);
    ArticleCommande getArticleCommandeById(Long idAC);
    List<ArticleCommande>getArticlecommandebyIdbcandidArticle(Long idBC,Long idArticle);
    BonCommande affectListArticleCommandeToBonCommande(Long idBC,List<ArticleCommande>listArticleCommande);
    ArticleCommande updateArticleBonCommande(ArticleCommande AC);
    void deleteArticleBonCommandeByIdAC(Long idAC);
    void deleteAllArticleCommandeofBonCommande(Long idBC);
    ArticleCommande convertDTO(ArticleCommandeDTO ACDTO);

}
