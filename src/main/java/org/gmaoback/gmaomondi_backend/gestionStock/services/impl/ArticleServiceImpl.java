package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.FamilleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    FamilleRepository familleRepository;

    @Override
    public List<ArticleDTO> getBesoin() {
        return articleRepository.findArticlesBelowMinimumStock().stream()
                .map(article -> {
                    ArticleDTO dto = new ArticleDTO();
                    dto.setIdArticle(article.getIdArticle());
                    dto.setCodeSapArticle(article.getCodeSapArticle());
                    dto.setDesignation(article.getDesignation());
                    dto.setEmplacementPhysique(article.getEmplacementPhysique());
                    dto.setStockMin(article.getStockMin());
                    dto.setStockMax(article.getStockMax());
                    dto.setStockSecurite(article.getStockSecurite());
                    dto.setStockDisponible(article.getStockDisponible());
                    dto.setDonneeTechnique(article.getDonneeTechnique());
                    dto.setRefFournisseur(article.getRefFournisseur());

                    if (article.getFamille() != null) {
                        dto.setIdFamille(article.getFamille().getIdFamille());
                        dto.setNomFamille(article.getFamille().getName());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Article addNewArticle(ArticleDTO articleDto) {
        Article nouvelArticle = new Article();
        mapArticleDtoToArticle(articleDto, nouvelArticle);
        return articleRepository.save(nouvelArticle);
    }

    @Override
    public Article updateArticle(Long id, ArticleDTO articleDTO) {
        return articleRepository.findById(id)
                .map(articleToUpdate -> {
                    mapArticleDtoToArticle(articleDTO, articleToUpdate);
                    return articleRepository.save(articleToUpdate);
                })
                .orElse(null);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void deleteArticlebycodeSapArticle(Long codeSapArticle) {
        Article article = articleRepository.findByCodeSapArticle(codeSapArticle);
        if (article != null) {
            articleRepository.delete(article);
        } else {
            throw new EntityNotFoundException("Article not found with code SAP: " + codeSapArticle);
        }
    }

    @Override
    public List<ArticleDTO> listArticlesDTO() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTO> articleDTOs = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = convertToDTO(article);
            articleDTOs.add(articleDTO);
        }
        return articleDTOs;
    }

    @Override
    public List<Article> listArticles() {
        return articleRepository.findAll();
    }
    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setIdArticle(article.getIdArticle());
        articleDTO.setCodeSapArticle(article.getCodeSapArticle());
        articleDTO.setDesignation(article.getDesignation());
        articleDTO.setEmplacementPhysique(article.getEmplacementPhysique());
        articleDTO.setStockMin(article.getStockMin());
        articleDTO.setStockMax(article.getStockMax());
        articleDTO.setStockSecurite(article.getStockSecurite());
        articleDTO.setStockDisponible(article.getStockDisponible());
        articleDTO.setDonneeTechnique(article.getDonneeTechnique());
        articleDTO.setRefFournisseur(article.getRefFournisseur());

        if (article.getFamille() != null) {
            articleDTO.setIdFamille(article.getFamille().getIdFamille());
            articleDTO.setNomFamille(article.getFamille().getName());
        }
        return articleDTO;
    }



    @Override
    public Article loadArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article loadArticleBycodeSapArticle(Long codeSapArticle) {
        return articleRepository.findByCodeSapArticle(codeSapArticle);
    }

    @Override
    public Article updateDataArticle(Article article, ArticleDTO articleDto) {
        Article articleToUpdate = articleRepository.findById(article.getIdArticle())
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id: " + article.getIdArticle()));
        articleToUpdate.setCodeSapArticle(articleDto.getCodeSapArticle());
        articleToUpdate.setDesignation(articleDto.getDesignation());
        articleToUpdate.setEmplacementPhysique(articleDto.getEmplacementPhysique());
        articleToUpdate.setStockMin(articleDto.getStockMin());
        articleToUpdate.setStockMax(articleDto.getStockMax());
        articleToUpdate.setStockSecurite(articleDto.getStockSecurite());
        articleToUpdate.setStockDisponible(articleDto.getStockDisponible());
        articleToUpdate.setDonneeTechnique(articleDto.getDonneeTechnique());
        articleToUpdate.setRefFournisseur(articleDto.getRefFournisseur());

        return articleRepository.save(articleToUpdate);
    }

    @Override
    public Article updateArticleBycodeSapArticle(Long codeSapArticle, ArticleDTO articleDTO) {
       Article articleToUpdate = articleRepository.findByCodeSapArticle(codeSapArticle);
    if (articleToUpdate == null) {
            throw new EntityNotFoundException("Article not found with code SAP: " + codeSapArticle);
        }
    mapArticleDtoToArticle(articleDTO, articleToUpdate);
        return articleRepository.save(articleToUpdate);
    }

    private void mapArticleDtoToArticle(ArticleDTO articleDto, Article article) {
        article.setCodeSapArticle(articleDto.getCodeSapArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setEmplacementPhysique(articleDto.getEmplacementPhysique());
        article.setStockMin(articleDto.getStockMin());
        article.setStockMax(articleDto.getStockMax());
        article.setStockSecurite(articleDto.getStockSecurite());
        article.setStockDisponible(articleDto.getStockDisponible());
        article.setDonneeTechnique(articleDto.getDonneeTechnique());
        article.setRefFournisseur(articleDto.getRefFournisseur());

        if (articleDto.getIdFamille() != null) {
            Famille famille = familleRepository.findById(articleDto.getIdFamille())
                    .orElseThrow(() -> new EntityNotFoundException("Famille not found with id: " + articleDto.getIdFamille()));
            article.setFamille(famille);
        }
    }
}


//    @Override
//    public Article saveArticle(Article article) {
//        try {
//            return articleRepository.save(article);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement de l'article : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Article updateArticle(Article article) {
//        try {
//            if (articleRepository.existsById(article.getIdArticle())) {
//                return articleRepository.save(article);
//            } else {
//                throw new IllegalArgumentException("Article non trouvé avec l'identifiant : " + article.getIdArticle());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de l'article : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Article getArticleById(Long idArticle) {
//        try {
//            return articleRepository.findById(idArticle)
//                    .orElseThrow(() -> new IllegalArgumentException("Article non trouvé avec l'identifiant : " + idArticle));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de l'article par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Article> getAllArticles() {
//        try {
//            return articleRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les articles : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteArticleById(Long idArticle) {
//        try {
//            articleRepository.deleteById(idArticle);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression de l'article par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public Article updateArticleByCodeSapAr(Long codeSapArticle, Article updatedArticle) {
//        try {
//            Article existingArticle = articleRepository.findByCodeSapArticle(codeSapArticle);
//            if (existingArticle != null) {
//                return articleRepository.save(existingArticle);
//            } else {
//                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapArticle);
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de l'article par codeSapAr : " + e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public void deleteArticleByCodeSapAr(Long codeSapArticle) {
//        try {
//            Article existingArticle = articleRepository.findByCodeSapArticle(codeSapArticle);
//            if (existingArticle != null) {
//                articleRepository.delete(existingArticle);
//            } else {
//                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapArticle);
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression de l'article par codeSapAr : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Article getArticleByCodeSapAr(Long codeSapArticle) {
//        try {
//            Article article = articleRepository.findByCodeSapArticle(codeSapArticle);
//            if (article == null) {
//                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapArticle);
//            }
//            return article;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de l'article par codeSapAr : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Article> getBesoin() {
//        try {
//            List<Article> articles = articleRepository.findArticlesBesoin();
//            if (articles.isEmpty()) {
//                throw new IllegalArgumentException("Aucun article trouvé avec les besoins spécifiés.");
//            }
//            return articles;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des articles avec les besoins spécifiés : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Page<Article> getAllArticlesByPage(int page, int size) {
//        try {
//            return articleRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des articles par page : " + e.getMessage());
//        }
//    }
//}
//
