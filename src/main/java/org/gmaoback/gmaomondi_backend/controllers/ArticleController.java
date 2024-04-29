package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping(value = "/articles/{idArticle}")
    public Article getArticleById(@PathVariable("idArticle") Long idArticle) {
        return articleService.getArticleById(idArticle);
    }

    @PostMapping("/saveArticle")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        article.setIdArticle(id);
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable("id") Long id) {
        articleService.deleteArticleById(id);
    }

}
