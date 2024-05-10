package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.springframework.stereotype.Service;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;

import java.util.List;

@Service
public interface ArticleSortieService {
    List<ArticleSortie> listArticlesSortieByIdSortie(Long id);
    List<ArticleSortie> listArticlesSortieByIdArticle(Long id);
    ArticleSortie getArticleSortieById(Long idAS);
    List<ArticleSortie> getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    Sortie affectListArticlesSortieToSortie(Long idSortie,List<ArticleSortie> listArticle);
    ArticleSortie updateArticleSortie(ArticleSortie AS);
    void deleteArticleSortieByIdSA(Long idSA);
    void deleteAllArticleSortieOfSortie(Long idSortie);
    ArticleSortie convertDTO(ArticleSortieDTO ASDTO);








}
