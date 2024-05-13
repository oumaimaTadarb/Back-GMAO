package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.ArticleDemande;
import org.gmaoback.gmaomondi_backend.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.dto.ArticleDemandeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleDemandeService {
    List<ArticleDemande> listArticleDemandeByIdDA(Long idDA);
    List<ArticleDemande>listArticleDemandeByIdArticle(Long idArticle);
    ArticleDemande getArticleCommandeById(Long idAD);
    List<ArticleDemande>getArticleDemandebyidArticle(Long idDA,Long idArticle);
    DemandeAchat affectListArticleCommandeToDemandeAchat(Long idDA, List<ArticleDemande>listArticleDemande);
    ArticleDemande updateArticleDemandeAchat(ArticleDemande AD);
    void deleteArticleDemandeAchatByIdAD(Long idAD);
    void deleteAllArticleCommandeofBonCommande(Long idDA);
    ArticleDemande convertDTO(ArticleDemandeDTO ADDTO);}

