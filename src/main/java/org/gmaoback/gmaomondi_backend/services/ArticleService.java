package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    Article saveArticle(Article article);
    Article updateArticle(Article article);
    Article getArticleById(Long idArticle);
    List<Article> getAllArticles();
    void deleteArticleByID(Long idArticle);
    void deleteAllArticle();

}
