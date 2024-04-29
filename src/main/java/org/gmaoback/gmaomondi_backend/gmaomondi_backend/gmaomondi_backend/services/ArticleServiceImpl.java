package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
