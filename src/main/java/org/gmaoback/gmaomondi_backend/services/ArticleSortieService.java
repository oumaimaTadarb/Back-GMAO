package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.gmaoback.gmaomondi_backend.dto.SortieDTO;
import org.springframework.stereotype.Service;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;

import java.util.List;

@Service
public interface ArticleSortieService {
    List<ArticleSortie> listArticlesSortieByIdSortie(Long id);
    //List <ArticleSortieDTO> listArticlesSortieDTOByIdSortie(Long id);
    List<ArticleSortie> listArticlesSortieByIdArticle(Long id);
   // List<ArticleSortieDTO> listArticlesSortieDTOByIdArticle(Long id);
    ArticleSortie getArticleSortieById(Long idAS);
    //ArticleSortieDTO getArticleSortieDTOById(Long idAS);
    List<ArticleSortie> getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    //List<ArticleSortieDTO> getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    Sortie affectListArticlesSortieToSortie(Long idSortie,List<ArticleSortie> listArticle);
    //SortieDTO affectListArticlesSortieToSortie(Long idSortie, List<ArticleSortieDTO> listArticle);
    ArticleSortie updateArticleSortie(ArticleSortie AS);
    //ArticleSortieDTO updateArticleSortie(ArticleSortieDTO AS);
    void deleteArticleSortieByIdSA(Long idSA);
    void deleteAllArticleSortieOfSortie(Long idSortie);
    ArticleSortie convertDTO(ArticleSortieDTO ASDTO);
}
