package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @PutMapping("/update/{codeSapAr}")
    public Article updateArticleByCodeSapAr(@PathVariable Long codeSapAr, @RequestBody Article updatedArticle) {
        return articleService.updateArticleByCodeSapAr(codeSapAr, updatedArticle);
    }

    @DeleteMapping("/delete/{codeSapAr}")
    public void deleteArticleByCodeSapAr(@PathVariable Long codeSapAr) {
        articleService.deleteArticleByCodeSapAr(codeSapAr);
    }
    @GetMapping("/codeSapAr/{codeSapAr}")
    public Article getArticleByCodeSapAr(@PathVariable Long codeSapAr) {
        return articleService.getArticleByCodeSapAr(codeSapAr);

    }
    @GetMapping("/besoin")
    public List<Article> getArticlesBesoin() {
        return articleService.getBesoin();
    }
    @GetMapping("/page")
    public Page<Article> getAllArticlesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return articleService.getAllArticlesByPage(page, size);
    }



}
