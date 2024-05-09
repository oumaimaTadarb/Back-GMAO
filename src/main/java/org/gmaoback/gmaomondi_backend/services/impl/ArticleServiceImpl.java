package org.gmaoback.gmaomondi_backend.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    FamilleRepository familleRepository;

    @Override
    public List<Article> getBesoin() {
        try {
            List<Article> articles = articleRepository.findArticlesBesoin();
            if (articles.isEmpty()) {
                throw new IllegalArgumentException("Aucun article trouvé avec les besoins spécifiés.");
            }
            return articles;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des articles avec les besoins spécifiés : " + e.getMessage());
        }
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
        // Recherchez l'article correspondant au code SAP spécifié
        Article articleToUpdate = articleRepository.findByCodeSapArticle(codeSapArticle);

        // Vérifiez si l'article existe
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
