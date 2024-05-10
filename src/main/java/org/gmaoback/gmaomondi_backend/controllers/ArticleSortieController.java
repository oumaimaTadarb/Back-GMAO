package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleSortie;
import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dto.ArticleSortieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.gmaoback.gmaomondi_backend.services.ArticleSortieService;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/articleSorties")
public class ArticleSortieController {

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
}
