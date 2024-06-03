package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.ArticleLivraisonDTO;

import java.util.List;

public interface ArticleLivraisonService {
    List<ArticleLivraison> listArticleLivraisonByIdBL(Long idBL);
    List<ArticleLivraison>listArticleLivraisonByIdArticle(Long idArticle);
    ArticleLivraison getArticleLivraisonById(Long idAL);
    List<ArticleLivraison>getArticleLivraisonbyidArticle(Long idBL,Long idArticle);
    BonLivraison affectListArticleLivraisonToBonLivraison(Long idBL, List<ArticleLivraison>listArticleLivraison);
    ArticleLivraison updateArticleBonLivraison(ArticleLivraison AL);
    void deleteArticleBonLivraisonByIdAL(Long idAL);
    void deleteAllArticleBonLivraison(Long ibL);
    ArticleLivraison convertDTO(ArticleLivraisonDTO ALDTO);
}
