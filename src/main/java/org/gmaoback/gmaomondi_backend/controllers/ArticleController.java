package org.gmaoback.gmaomondi_backend.controllers;


import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/uploadExcel")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile multipartFile) {
        try {
            // Charger le fichier Excel dans un flux de travail
            Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());

            // Accéder à la première feuille de calcul
            Sheet sheet = workbook.getSheetAt(0);

            // Parcourir les lignes
            for (Row row : sheet) {
                // Parcourir les colonnes
                for (Cell cell : row) {
                    // Lire la valeur de la cellule
                    String value = cell.getStringCellValue();
                    System.out.println(value);
                }
            }

            workbook.close();
            return ResponseEntity.ok("Fichier Excel traité avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du traitement du fichier Excel.");
        }
    }

}
