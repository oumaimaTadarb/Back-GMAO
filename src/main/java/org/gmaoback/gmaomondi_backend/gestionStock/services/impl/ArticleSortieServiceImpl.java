package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleSortie;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleSortieRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.SortieRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleSortieDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.ArticleSortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public ArticleSortieDTO convertToDTO (ArticleSortie articleSortie) { 
    if (articleSortie == null) return null;
    ArticleSortieDTO dto = new ArticleSortieDTO();
    dto.setIdSortie(articleSortie.getSortie() != null ? articleSortie.getSortie().getIdSortie() : null);
    dto.setIdArticleSortie(articleSortie.getId());
    dto.setQuantite(articleSortie.getQuantite());
    dto.setUsage(articleSortie.getUsage() != null ? articleSortie.getUsage().getNomUsage() : null); // Assuming Usage has a field usageType
    dto.setCommentaire(articleSortie.getCommentaire());
    dto.setIdArticle(articleSortie.getArticle() != null ? articleSortie.getArticle().getIdArticle() : null);
    dto.setCodeSap(articleSortie.getArticle() != null ? articleSortie.getArticle().getCodeSapArticle() : null);
    dto.setDesignation(articleSortie.getArticle() != null ? articleSortie.getArticle().getDesignation() : null);
    dto.setDonneeTechnique(articleSortie.getArticle() != null ? articleSortie.getArticle().getDonneeTechnique() : null);
    return dto;
    }/*
    @Override
    public List<ArticleSortieDTO> convertToDTOList(List<ArticleSortie> articles) {
    return articles.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ArticleSortieDTO> listArticlesSortieDTOByIdSortie(Long idSortie) {
        return convertToDTOList(articleSortieRepository.findBySortie_IdSortie(idSortie));
    }

    @Override
    public List<ArticleSortieDTO> listArticlesSortieDTOByIdArticle(Long idArticle) {
        return convertToDTOList(articleSortieRepository.findByArticle_IdArticle(idArticle));
    }

    @Override
    public ArticleSortieDTO getArticleSortieDTOById(Long idAS) {
        return convertToDTO(articleSortieRepository.findById(idAS).orElse(null));
    }

    @Override
    public List<ArticleSortieDTO> getArticleSortieDTOByIdSortieANDIdArticle(Long idSortie, Long idArticle) {
        return convertToDTOList(articleSortieRepository.findBySortie_IdSortieAndArticle_IdArticle(idSortie, idArticle));
    }

    @Override
    public ArticleSortieDTO updateArticleSortie(ArticleSortieDTO asDTO) {
        ArticleSortie articleSortie = convertDTO(asDTO); // You already have convertDTO, you might need to adjust it for reverse conversion
        return convertToDTO(articleSortieRepository.save(articleSortie));
    }

    @Override
    public Sortie affectListArticlesSortieDTOToSortie(Long idSortie, List<ArticleSortieDTO> listArticlesDTO) {
        List<ArticleSortie> articleSorties = listArticlesDTO.stream().map(this::convertDTO).collect(Collectors.toList());
        Sortie sortie = affectListArticlesSortieToSortie(idSortie, articleSorties); // Utilize the existing method
        return sortie; // You will need to implement this conversion method for Sortie -> SortieDTO
    }

    @Override
    public ArticleSortie convertDTO(ArticleSortieDTO ASDTO) {
        // Create a new instance of ArticleSortie
        ArticleSortie articleSortie = new ArticleSortie();

        // Set simple properties from DTO to entity
        articleSortie.setQuantite(ASDTO.getQuantite());
        articleSortie.setCommentaire(ASDTO.getCommentaire());

        // Retrieve and set the Article entity using idArticle from the DTO
        if (ASDTO.getIdArticle() != null) {
            Article article = articleRepository.findById(ASDTO.getIdArticle())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Article ID: " + ASDTO.getIdArticle()));
            articleSortie.setArticle(article);
        }

        // Retrieve and set the Sortie entity using idSortie from the DTO
        if (ASDTO.getIdSortie() != null) {
            Sortie sortie = sortieRepository.findById(ASDTO.getIdSortie())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Sortie ID: " + ASDTO.getIdSortie()));
            articleSortie.setSortie(sortie);
        }

        // Return the fully populated ArticleSortie entity
        return articleSortie;
    }*/




}
