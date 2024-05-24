package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleLivraisonRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.BonLivraisonRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleLivraisonDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.ArticleLivraisonService;
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
        return articleLivraisonRepository.findByBonLivraison_IdBL(idBL);
    }

    @Override
    public List<ArticleLivraison> listArticleLivraisonByIdArticle(Long idArticle) {
        return articleLivraisonRepository.findByArticle_IdArticle(idArticle);
    }

    @Override
    public ArticleLivraison getArticleLivraisonById(Long idAL) {
        return articleLivraisonRepository.findById(idAL).orElse(null);
    }

    @Override
    public List<ArticleLivraison> getArticleLivraisonbyidArticle(Long idBL, Long idArticle) {
        return articleLivraisonRepository.findByBonLivraison_idBLAndArticle_IdArticle(idBL, idArticle);
    }

    @Override
    public BonLivraison affectListArticleLivraisonToBonLivraison(Long idBL, List<ArticleLivraison> listArticleLivraison) {
        BonLivraison bonLivraison =  bonLivraisonRepository.findById(idBL).orElse(null);
        if ( bonLivraison != null) {
            bonLivraison.getArticleLivraisons().clear();
            bonLivraison.getArticleLivraisons().addAll(listArticleLivraison);
            listArticleLivraison.forEach(al -> al.setBonLivraison(bonLivraison));
            bonLivraisonRepository.save( bonLivraison);
        }
        return  bonLivraison;
    }


    @Override
    public ArticleLivraison updateArticleBonLivraison(ArticleLivraison AL) {
        return articleLivraisonRepository.save(AL);
    }

    @Override
    public void deleteArticleBonLivraisonByIdAL(Long idAL) {
        articleLivraisonRepository.deleteById(idAL);   }

    @Override
    public void deleteAllArticleBonLivraison(Long idBL) {
            List<ArticleLivraison> articles = articleLivraisonRepository.findByBonLivraison_IdBL(idBL);
            articleLivraisonRepository.deleteAll(articles);
        }

    @Override
    public ArticleLivraison convertDTO(ArticleLivraisonDTO ALDTO) {
        ArticleLivraison articleLivraison = new ArticleLivraison();
        articleLivraison.setQuantiteLivraison(ALDTO.getQuantiteLivraison());
        if (ALDTO.getIdArticle()!= null) {
            Article article = articleRepository.findById(ALDTO.getIdArticle())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Article ID: " + ALDTO.getIdArticle()));
            articleLivraison.setArticle(article);
        }
        if (ALDTO.getIdBL() != null) {
            BonLivraison bonLivraison = bonLivraisonRepository.findById(ALDTO.getIdBL())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid BonLivraison ID: " + ALDTO.getIdBL()));
            articleLivraison.setBonLivraison(bonLivraison);
        }

        return articleLivraison;
    }



}
