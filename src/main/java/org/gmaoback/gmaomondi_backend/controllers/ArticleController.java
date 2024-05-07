package org.gmaoback.gmaomondi_backend.controllers;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.gmaoback.gmaomondi_backend.dao.models.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
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

    @PostMapping("/uploadExcel")
    public ResponseEntity<String> updateExel(@RequestParam("file") MultipartFile file) {
        try {
            // Check if the uploaded file is empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Le fichier Excel est vide.");
            }

            // Check if the uploaded file is a valid Excel file
            if (!file.getContentType().equals("application/vnd.ms-excel") && !file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
                return ResponseEntity.badRequest().body("Le fichier n'est pas un fichier Excel valide.");
            }

            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();

                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    // Read the value of the cell
                    String value = currentCell.getStringCellValue();
                    System.out.println(value);
                }
            }
            workbook.close();
            return ResponseEntity.ok("Fichier Excel traité avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la lecture du fichier Excel.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du traitement du fichier Excel.");
        }
    }




}
