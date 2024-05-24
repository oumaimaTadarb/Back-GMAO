package org.gmaoback.gmaomondi_backend.gestionStock.controllers;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleSortie;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleSortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.gmaoback.gmaomondi_backend.gestionStock.services.ArticleSortieService;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/articleSorties")
public class ArticleSortieController {
    @Autowired
    private ArticleSortieRepository articleSortieRepository;

    @Autowired
    private ArticleSortieService articleSortieService;

    @GetMapping("/bySortie/{id}")
    public ResponseEntity<List<ArticleSortie>> listArticlesSortieByIdSortie(@PathVariable Long id) {
        return ResponseEntity.ok(articleSortieService.listArticlesSortieByIdSortie(id));
    }

    @GetMapping("/byArticle/{id}")
    public ResponseEntity<List<ArticleSortie>> listArticlesSortieByIdArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleSortieService.listArticlesSortieByIdArticle(id));
    }

    @GetMapping("/{idAS}")
    public ResponseEntity<ArticleSortie> getArticleSortieById(@PathVariable Long idAS) {
        ArticleSortie articleSortie = articleSortieService.getArticleSortieById(idAS);
        return articleSortie != null ? ResponseEntity.ok(articleSortie) : ResponseEntity.notFound().build();
    }

    @GetMapping("/bySortie/{idSortie}/AndArticle/{idArticle}")
    public ResponseEntity<List<ArticleSortie>> getArticleSortieByIdSortieAndIdArticle(@RequestParam Long idSortie, @RequestParam Long idArticle) {
        return ResponseEntity.ok(articleSortieService.getArticleSortieByIdSortieANDIdArticle(idSortie, idArticle));
    }

    @PostMapping("/affectToSortie/{idSortie}")
    public ResponseEntity<Sortie> affectListArticlesSortieToSortie(@PathVariable Long idSortie, @RequestBody List<ArticleSortie> listArticle) {
        return ResponseEntity.ok(articleSortieService.affectListArticlesSortieToSortie(idSortie, listArticle));
    }

    @PutMapping("/put/")
    public ResponseEntity<ArticleSortie> updateArticleSortie(@RequestBody ArticleSortie AS) {
        ArticleSortie updatedArticleSortie = articleSortieService.updateArticleSortie(AS);
        return ResponseEntity.ok(updatedArticleSortie);
    }

    @DeleteMapping("/Delete/{idSA}")
    public ResponseEntity<Void> deleteArticleSortieByIdSA(@PathVariable Long idSA) {
        articleSortieService.deleteArticleSortieByIdSA(idSA);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/bySortie/{idSortie}")
    public ResponseEntity<Void> deleteAllArticleSortieOfSortie(@PathVariable Long idSortie) {
        articleSortieService.deleteAllArticleSortieOfSortie(idSortie);
        return ResponseEntity.ok().build();
    }
//
//    @PostMapping("/convert")
//    public ResponseEntity<ArticleSortie> convertDTO(@RequestBody ArticleSortieDTO ASDTO) {
//        ArticleSortie articleSortie = articleSortieService.convertDTO(ASDTO);
//        return ResponseEntity.ok(articleSortie);
//    }


    /*package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.gmaoback.gmaomondi_backend.services.ArticleSortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articlesorties")
public class ArticleSortieController {

    @Autowired
    private ArticleSortieService articleSortieService;

    // Get all ArticleSorties by Sortie ID
    @GetMapping("/by-sortie/{idSortie}")
    public ResponseEntity<List<ArticleSortieDTO>> listArticleSortiesBySortieId(@PathVariable Long idSortie) {
        return ResponseEntity.ok(articleSortieService.listArticlesSortieDTOByIdSortie(idSortie));
    }

    // Get all ArticleSorties by Article ID
    @GetMapping("/by-article/{idArticle}")
    public ResponseEntity<List<ArticleSortieDTO>> listArticleSortiesByArticleId(@PathVariable Long idArticle) {
        return ResponseEntity.ok(articleSortieService.listArticlesSortieDTOByIdArticle(idArticle));
    }

    // Get a single ArticleSortie by ID
    @GetMapping("/{id}")
    public ResponseEntity<ArticleSortieDTO> getArticleSortieById(@PathVariable Long id) {
        ArticleSortieDTO articleSortieDTO = articleSortieService.getArticleSortieDTOById(id);
        return articleSortieDTO != null ? ResponseEntity.ok(articleSortieDTO) : ResponseEntity.notFound().build();
    }

    // Create or Update an ArticleSortie
    @PostMapping("/")
    public ResponseEntity<ArticleSortieDTO> saveOrUpdateArticleSortie(@RequestBody ArticleSortieDTO articleSortieDTO) {
        ArticleSortieDTO savedArticleSortie = articleSortieService.updateArticleSortie(articleSortieDTO);
        return ResponseEntity.ok(savedArticleSortie);
    }

    // Delete an ArticleSortie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleSortie(@PathVariable Long id) {
        articleSortieService.deleteArticleSortieByIdSA(id);
        return ResponseEntity.ok().build();
    }

    // Affect a list of ArticleSorties to a Sortie
    @PostMapping("/affect-to-sortie/{idSortie}")
    public ResponseEntity<Void> affectArticleSortiesToSortie(@PathVariable Long idSortie, @RequestBody List<ArticleSortieDTO> articleSortiesDTO) {
        articleSortieService.affectListArticlesSortieDTOToSortie(idSortie, articleSortiesDTO);
        return ResponseEntity.ok().build();
    }
}
*/
}
