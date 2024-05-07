package org.gmaoback.gmaomondi_backend.services.impl;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.models.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        try {
            return articleRepository.save(article);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de l'article : " + e.getMessage());
        }
    }

    @Override
    public Article updateArticle(Article article) {
        try {
            if (articleRepository.existsById(article.getIdArticle())) {
                return articleRepository.save(article);
            } else {
                throw new IllegalArgumentException("Article non trouvé avec l'identifiant : " + article.getIdArticle());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de l'article : " + e.getMessage());
        }
    }

    @Override
    public Article getArticleById(Long idArticle) {
        try {
            return articleRepository.findById(idArticle)
                    .orElseThrow(() -> new IllegalArgumentException("Article non trouvé avec l'identifiant : " + idArticle));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de l'article par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Article> getAllArticles() {
        try {
            return articleRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les articles : " + e.getMessage());
        }
    }

    @Override
    public void deleteArticleById(Long idArticle) {
        try {
            articleRepository.deleteById(idArticle);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de l'article par ID : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Article updateArticleByCodeSapAr(Long codeSapAr, Article updatedArticle) {
        try {
            Article existingArticle = articleRepository.findByCodeSapAr(codeSapAr);
            if (existingArticle != null) {
                return articleRepository.save(existingArticle);
            } else {
                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de l'article par codeSapAr : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteArticleByCodeSapAr(Long codeSapAr) {
        try {
            Article existingArticle = articleRepository.findByCodeSapAr(codeSapAr);
            if (existingArticle != null) {
                articleRepository.delete(existingArticle);
            } else {
                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de l'article par codeSapAr : " + e.getMessage());
        }
    }

    @Override
    public Article getArticleByCodeSapAr(Long codeSapAr) {
        try {
            Article article = articleRepository.findByCodeSapAr(codeSapAr);
            if (article == null) {
                throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
            }
            return article;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de l'article par codeSapAr : " + e.getMessage());
        }
    }

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
    public Page<Article> getAllArticlesByPage(int page, int size) {
        try {
            return articleRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des articles par page : " + e.getMessage());
        }
    }
}

