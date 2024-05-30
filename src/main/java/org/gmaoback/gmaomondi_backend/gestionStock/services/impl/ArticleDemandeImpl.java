package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleDemande;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleDemandeRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.DemandeAchatRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleDemandeDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.ArticleDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleDemandeImpl implements ArticleDemandeService {
    @Autowired
    ArticleDemandeRepository articleDemandeRepository;

    @Autowired
    DemandeAchatRepository demandeAchatRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Override

    public List<ArticleDemande> listArticleDemandeByIdDA(Long idDA) {
        return articleDemandeRepository.findByDemandeAchat_idDA(idDA);
    }

    @Override
    public List<ArticleDemande> listArticleDemandeByIdArticle(Long idArticle) {
        return articleDemandeRepository.findByArticle_IdArticle(idArticle);
    }

    @Override
    public ArticleDemande getArticleCommandeById(Long idAD) {
        return articleDemandeRepository.findById(idAD).orElse(null);

    }

    @Override
    public List<ArticleDemande> getArticleDemandebyidArticle(Long idDA, Long idArticle) {
        return articleDemandeRepository.findByDemandeAchat_idDAAndArticle_IdArticle(idDA, idArticle);
    }

    @Override
    public DemandeAchat affectListArticleCommandeToDemandeAchat(Long idDA, List<ArticleDemande> listArticleDemande) {
        DemandeAchat demandeAchat = demandeAchatRepository.findById(idDA).orElse(null);
        if (demandeAchat != null) {
            demandeAchat.getArticledemandes().clear();
            demandeAchat.getArticledemandes().addAll(listArticleDemande);
            listArticleDemande.forEach(ad -> ad.setDemandeAchat(demandeAchat));
            demandeAchatRepository.save(demandeAchat);
        }
        return demandeAchat;
    }

    @Override
    public ArticleDemande updateArticleDemandeAchat(ArticleDemande AD) {
        return articleDemandeRepository.save(AD);
    }

    @Override
    public void deleteArticleDemandeAchatByIdAD(Long idAD) {
        articleDemandeRepository.deleteById(idAD);

    }

    @Override
    public void deleteAllArticleCommandeofBonCommande(Long idDA) {
        List<ArticleDemande> articles = articleDemandeRepository.findByDemandeAchat_idDA(idDA);
        articleDemandeRepository.deleteAll(articles);

    }

    @Override
    public ArticleDemande convertDTO(ArticleDemandeDTO ADDTO) {
        ArticleDemande articleDemande= new ArticleDemande();
        articleDemande.setQuantiteDemande(ADDTO.getQuantiteDemande());
        if (ADDTO.getIdArticle() != null) {
            Article article = articleRepository.findById(ADDTO.getIdArticle())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Article ID: " + ADDTO.getIdArticle()));
            articleDemande.setArticle(article);
        }
        if (ADDTO.getIdDA() != null) {
            DemandeAchat demandeAchat = demandeAchatRepository.findById(ADDTO.getIdDA())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Demande d'achat ID: " + ADDTO.getIdDA()));
            articleDemande.setDemandeAchat(demandeAchat);
        }

        return articleDemande;

    }
}
