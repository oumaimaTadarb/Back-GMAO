package org.gmaoback.gmaomondi_backend.gestionStock.services;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleLivraisonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
