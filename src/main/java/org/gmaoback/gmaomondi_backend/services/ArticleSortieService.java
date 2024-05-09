package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.springframework.stereotype.Service;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;

import java.util.List;

@Service
public interface ArticleSortieService {
    List<ArticleSortie> listArticlesSortieByIdSortie(Long id);
    List<ArticleSortie> listArticlesSortieByIdArticle(Long id);
    ArticleSortie getArticleSortieById(Long idAS);
    ArticleSortie getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    Sortie affectListArticlesSortieASortie(Long idSortie,List<ArticleSortie> listArticle);
    ArticleSortie updateArticleSortie(ArticleSortie AS);
    void deleteArticleSortieByIdSA(Long idSA);
    ArticleSortie convertDTO();
    //





}
