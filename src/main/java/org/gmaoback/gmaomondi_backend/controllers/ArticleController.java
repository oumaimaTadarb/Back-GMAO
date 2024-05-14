package org.gmaoback.gmaomondi_backend.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleService articleService;

    @GetMapping("/besoin")
    public List<ArticleDTO> getArticlesBesoin() {
        return articleService.getBesoin();
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addNewArticle(@RequestBody ArticleDTO articleDTO) {
        Article newArticle = articleService.addNewArticle(articleDTO);
        return ResponseEntity.ok(newArticle);
    }
    @GetMapping("/listArticle")
    public ResponseEntity<List<Article>> listArticles() {
        List<Article> articles = articleService.listArticles();
        return ResponseEntity.ok(articles);
    }

    @PutMapping("updateArticle/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO){
            Article updatedArticle = articleService.updateArticle(id, articleDTO);
            if (updatedArticle != null) {
                return ResponseEntity.ok(updatedArticle);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/code/{codeSapArticle}")
    public ResponseEntity<Void> deleteArticleByCode(@PathVariable Long codeSapArticle) {
        articleService.deleteArticlebycodeSapArticle(codeSapArticle);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ArticleDTO>> listArticlesDTO() {
        List<ArticleDTO> articleDTOs = articleService.listArticlesDTO();
        return ResponseEntity.ok(articleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.loadArticleById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/code/{codeSapArticle}")
    public ResponseEntity<Article> getArticleByCode(@PathVariable Long codeSapArticle) {
        Article article = articleService.loadArticleBycodeSapArticle(codeSapArticle);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/code/{codeSapArticle}")
    public ResponseEntity<Article> updateArticleByCode(@PathVariable Long codeSapArticle, @RequestBody ArticleDTO articleDTO) {
        Article updatedArticle = articleService.updateArticleBycodeSapArticle(codeSapArticle, articleDTO);
        if (updatedArticle != null) {
            return ResponseEntity.ok(updatedArticle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
//
//    @GetMapping("/articles")
//    public List<Article> getAllArticles() {
//        return articleService.getAllArticles();
//    }
//    @GetMapping(value = "/articles/{idArticle}")
//    public Article getArticleById(@PathVariable("idArticle") Long idArticle) {
//        return articleService.getArticleById(idArticle);
//    }
//
//    @PostMapping("/saveArticle")
//    public Article saveArticle(@RequestBody Article article) {
//        return articleService.saveArticle(article);
//    }
//
//    @PutMapping("/{id}")
//    public Article updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
//        article.setIdArticle(id);
//        return articleService.updateArticle(article);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteArticleById(@PathVariable("id") Long id) {
//        articleService.deleteArticleById(id);
//    }
//    @PutMapping("/update/{codeSapAr}")
//    public Article updateArticleByCodeSapAr(@PathVariable Long codeSapAr, @RequestBody Article updatedArticle) {
//        return articleService.updateArticleByCodeSapAr(codeSapAr, updatedArticle);
//    }
//
//    @DeleteMapping("/delete/{codeSapAr}")
//    public void deleteArticleByCodeSapAr(@PathVariable Long codeSapAr) {
//        articleService.deleteArticleByCodeSapAr(codeSapAr);
//    }
//    @GetMapping("/codeSapAr/{codeSapAr}")
//    public Article getArticleByCodeSapAr(@PathVariable Long codeSapAr) {
//        return articleService.getArticleByCodeSapAr(codeSapAr);
//
//    }
//    @GetMapping("/besoin")
//    public List<Article> getArticlesBesoin() {
//        return articleService.getBesoin();
//    }
//    @GetMapping("/page")
//    public Page<Article> getAllArticlesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return articleService.getAllArticlesByPage(page, size);
//    }
//
//    @PostMapping("/uploadExcel")
//    public ResponseEntity<String> updateExel(@RequestParam("file") MultipartFile file) {
//        try {
//            // Check if the uploaded file is empty
//            if (file.isEmpty()) {
//                return ResponseEntity.badRequest().body("Le fichier Excel est vide.");
//            }
//
//            // Check if the uploaded file is a valid Excel file
//            if (!file.getContentType().equals("application/vnd.ms-excel") && !file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
//                return ResponseEntity.badRequest().body("Le fichier n'est pas un fichier Excel valide.");
//            }
//
//            Workbook workbook = new XSSFWorkbook(file.getInputStream());
//            Sheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rows = sheet.iterator();
//
//            while (rows.hasNext()) {
//                Row currentRow = rows.next();
//                Iterator<Cell> cellsInRow = currentRow.iterator();
//
//                while (cellsInRow.hasNext()) {
//                    Cell currentCell = cellsInRow.next();
//
//                    // Read the value of the cell
//                    String value = currentCell.getStringCellValue();
//                    System.out.println(value);
//                }
//            }
//            workbook.close();
//            return ResponseEntity.ok("Fichier Excel traité avec succès !");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la lecture du fichier Excel.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du traitement du fichier Excel.");
//        }
//    }
//
//
//
//
//}
