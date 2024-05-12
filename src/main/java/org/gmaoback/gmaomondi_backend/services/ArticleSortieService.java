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
    List<ArticleSortie> listArticlesSortieByIdArticle(Long id);
    ArticleSortie getArticleSortieById(Long idAS);
    List<ArticleSortie> getArticleSortieByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    Sortie affectListArticlesSortieToSortie(Long idSortie,List<ArticleSortie> listArticle);
    ArticleSortie updateArticleSortie(ArticleSortie AS);
    ArticleSortieDTO updateArticleSortie(ArticleSortieDTO AS);
    void deleteArticleSortieByIdSA(Long idSA);
    void deleteAllArticleSortieOfSortie(Long idSortie);
    ArticleSortieDTO convertToDTO(ArticleSortie articleSortie);
    List<ArticleSortieDTO> convertToDTOList(List<ArticleSortie> articles);
    List <ArticleSortieDTO> listArticlesSortieDTOByIdSortie(Long id);
    List<ArticleSortieDTO> listArticlesSortieDTOByIdArticle(Long id);
    ArticleSortieDTO getArticleSortieDTOById(Long idAS);
    List<ArticleSortieDTO> getArticleSortieDTOByIdSortieANDIdArticle(Long idSortie, Long idArticle);
    Sortie affectListArticlesSortieDTOToSortie(Long idSortie, List<ArticleSortieDTO> listArticle);
    ArticleSortie convertDTO(ArticleSortieDTO ASDTO);







}
