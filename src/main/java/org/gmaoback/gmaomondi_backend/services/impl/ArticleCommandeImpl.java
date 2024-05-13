package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleCommande;
import org.gmaoback.gmaomondi_backend.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.repositories.*;
import org.gmaoback.gmaomondi_backend.dto.ArticleCommandeDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCommandeImpl implements ArticleCommandeService {
    @Autowired
    private ArticleCommandeRepository articleCommandeRepository;

    @Autowired
    private BonCommandeRepository bonCommandeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleCommande> listArticlesCommmandeByIdBC(Long idBC) {
        return articleCommandeRepository.findByBonCommande_IdBC(idBC);
    }

    @Override
    public List<ArticleCommande> listArticlesCommandeByIdArticle(Long idArticle) {
        return articleCommandeRepository.findByArticle_IdArticle(idArticle);
    }

    @Override
    public ArticleCommande getArticleCommandeById(Long idAC) {
        return articleCommandeRepository.findById(idAC).orElse(null);
    }

    @Override
    public List<ArticleCommande> getArticlecommandebyidArticle(Long idBC, Long idArticle) {
        return articleCommandeRepository.findByBonCommande_idBCAndArticle_IdArticle(idBC, idArticle);
    }

    @Override
    public BonCommande affectListArticleCommandeToBonCommande(Long idBC, List<ArticleCommande> listArticleCommande) {
        BonCommande bonCommande = bonCommandeRepository.findById(idBC).orElse(null);
        if (bonCommande != null) {
            bonCommande.getArticleCommande().clear();
            bonCommande.getArticleCommande().addAll(listArticleCommande);
            listArticleCommande.forEach(ac -> ac.setBonCommande(bonCommande));
            bonCommandeRepository.save(bonCommande);
        }
        return bonCommande;
    }

    public ArticleCommande updateArticleBonCommande(ArticleCommande AC) {
        return articleCommandeRepository.save(AC);
    }

    @Override
    public void deleteArticleBonCommandeByIdAC(Long idAC) {
        articleCommandeRepository.deleteById(idAC);
    }

    @Override
    public void deleteAllArticleCommandeofBonCommande(Long idBC) {
        List<ArticleCommande> articles = articleCommandeRepository.findByBonCommande_IdBC(idBC);
        articleCommandeRepository.deleteAll(articles);
    }


    @Override
    public ArticleCommande convertDTO(ArticleCommandeDTO ACDTO) {
        ArticleCommande articleCommande = new ArticleCommande();
        articleCommande.setQuantiteCommande(ACDTO.getQuantiteCommande());
        if (ACDTO.getIdArticle() != null) {
            Article article = articleRepository.findById(ACDTO.getIdArticle())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Article ID: " + ACDTO.getIdArticle()));
            articleCommande.setArticle(article);
        }
        if (ACDTO.getIdBC() != null) {
            BonCommande bonCommande = bonCommandeRepository.findById(ACDTO.getIdBC())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Sortie ID: " + ACDTO.getIdBC()));
            articleCommande.setBonCommande(bonCommande);
        }

        return articleCommande;
    }
}