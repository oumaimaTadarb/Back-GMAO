package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entities.ArticleLivraison;
import org.gmaoback.gmaomondi_backend.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleLivraisonRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonLivraisonRepository;
import org.gmaoback.gmaomondi_backend.dto.ArticleCommandeDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLivraisonImpl implements ArticleLivraisonService {

    @Autowired
    private ArticleLivraisonRepository articleLivraisonRepository;
    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<ArticleLivraison> listArticleLivraisonByIdBL(Long idBL) {
        return null;
    }

    @Override
    public List<ArticleLivraison> listArticleLivraisonByIdArticle(Long idArticle) {
        return null;
    }

    @Override
    public ArticleLivraison getArticleLivraisonById(Long idAL) {
        return null;
    }

    @Override
    public List<ArticleLivraison> getArticleLivraisonbyidArticle(Long idBL, Long idArticle) {
        return null;
    }

    @Override
    public BonLivraison affectListArticleLivraisonToBonLivraison(Long idBL, List<ArticleLivraison> listArticleLivraison) {
        return null;
    }

    @Override
    public ArticleLivraison updateArticleBonLivraison(ArticleLivraison AL) {
        return null;
    }

    @Override
    public void deleteArticleBonLivraisonByIdAL(Long idAL) {

    }

    @Override
    public void deleteAllArticleBonLivraison(Long idAL) {

    }

    @Override
    public ArticleLivraison convertDTO(ArticleCommandeDTO ALDTO) {
        return null;
    }
}
