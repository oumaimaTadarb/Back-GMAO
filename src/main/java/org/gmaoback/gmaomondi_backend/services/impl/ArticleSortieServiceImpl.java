package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;
import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dao.entities.Usage;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleSortieRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.SortieRepository;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleSortieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleSortieServiceImpl implements ArticleSortieService {

    @Autowired
    private ArticleSortieRepository articleSortieRepository;

    @Autowired
    private SortieRepository sortieRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleSortie> listArticlesSortieByIdSortie(Long idSortie) {
        return articleSortieRepository.findBySortie_IdSortie(idSortie);
    }

    @Override
    public List<ArticleSortie> listArticlesSortieByIdArticle(Long idArticle) {
        return articleSortieRepository.findByArticle_IdArticle(idArticle);
    }

    @Override
    public ArticleSortie getArticleSortieById(Long idAS) {
        return articleSortieRepository.findById(idAS).orElse(null);
    }

    @Override
    public List<ArticleSortie> getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle) {
        return articleSortieRepository.findBySortie_IdSortieAndArticle_IdArticle(idSortie, idArticle);
    }


    @Override
    public Sortie affectListArticlesSortieToSortie(Long idSortie, List<ArticleSortie> listArticleSorties) {
        Sortie sortie = sortieRepository.findById(idSortie).orElse(null);
        if (sortie != null) {
            sortie.getArticleSorties().clear();
            sortie.getArticleSorties().addAll(listArticleSorties);
            listArticleSorties.forEach(as -> as.setSortie(sortie));
            sortieRepository.save(sortie);
        }
        return sortie;
    }

    @Override
    public ArticleSortie updateArticleSortie(ArticleSortie articleSortie) {
        return articleSortieRepository.save(articleSortie);
    }

    @Override
    public void deleteArticleSortieByIdSA(Long idSA) {
        articleSortieRepository.deleteById(idSA);
    }

    @Override
    public void deleteAllArticleSortieOfSortie(Long idSortie) {
        List<ArticleSortie> articles = articleSortieRepository.findBySortie_IdSortie(idSortie);
        articleSortieRepository.deleteAll(articles);
    }

    @Override
    public ArticleSortie convertDTO(ArticleSortieDTO ASDTO) {
        ArticleSortie articleSortie = new ArticleSortie();

        articleSortie.setQuantite(ASDTO.getQuantite());
        articleSortie.setCommentaire(ASDTO.getCommentaire());
        if (ASDTO.getIdArticle() != null) {
            Article article = articleRepository.findById(ASDTO.getIdArticle())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Article ID: " + ASDTO.getIdArticle()));
            articleSortie.setArticle(article);
        }
        if (ASDTO.getIdSortie() != null) {
            Sortie sortie = sortieRepository.findById(ASDTO.getIdSortie())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Sortie ID: " + ASDTO.getIdSortie()));
            articleSortie.setSortie(sortie);
        }

        return articleSortie;
    }

}
