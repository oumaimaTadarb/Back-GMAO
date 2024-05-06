package org.gmaoback.gmaomondi_backend.services;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
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
        return articleRepository.save(article);
    }
    @Override
    public Article updateArticle(Article article) {
        if (articleRepository.existsById(article.getIdArticle())) {
            return articleRepository.save(article);
        } else {
            throw new IllegalArgumentException("Article non trouvé avec l'identifiant : " + article.getIdArticle());
        }
    }
    @Override
    public Article getArticleById(Long idArticle) {
        return articleRepository.findById(idArticle)
                .orElseThrow(() -> new IllegalArgumentException("Article non trouvé avec l'identifiant : " + idArticle));
    }
    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    @Override
    public void deleteArticleById(Long idArticle) {
        articleRepository.deleteById(idArticle);
    }
    @Override
    @Transactional
    public Article updateArticleByCodeSapAr(Long codeSapAr, Article updatedArticle) {
        Article existingArticle = articleRepository.findByCodeSapAr(codeSapAr);
        if (existingArticle != null) {
            return articleRepository.save(existingArticle);
        } else {
            throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
        }
    }

    @Override
    @Transactional
    public void deleteArticleByCodeSapAr(Long codeSapAr) {
        Article existingArticle = articleRepository.findByCodeSapAr(codeSapAr);
        if (existingArticle != null) {
            articleRepository.delete(existingArticle);
        } else {
            throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
        }
    }

    @Override
    public Article getArticleByCodeSapAr(Long codeSapAr) {
        Article article = articleRepository.findByCodeSapAr(codeSapAr);
        if (article == null) {
            throw new IllegalArgumentException("Article non trouvé avec le codeSapAr : " + codeSapAr);
        }
        return article;
    }

    @Override
    public List<Article> getBesoin() {
        List<Article> articles = articleRepository.findArticlesBesoin();
        if (articles.isEmpty()) {
            throw new IllegalArgumentException("Aucun article trouvé avec les besoins spécifiés.");
        }
        return articles;
    }

    @Override
    public Page<Article> getAllArticlesByPage(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size));
    }



}
