package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.services.ArticleLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articleLivraison")
@CrossOrigin("*")
public class ArticleLivraisonController {
    @Autowired
    private ArticleLivraisonService articleLivraisonService;

    @GetMapping("/by-bon-livraison/{idBL}")
    public ResponseEntity<List<ArticleLivraison>> listArticleLivraisonByIdBL(@PathVariable Long idBL) {
        return ResponseEntity.ok(articleLivraisonService.listArticleLivraisonByIdBL(idBL));
    }

    @GetMapping("/by-article/{idArticle}")
    public ResponseEntity<List<ArticleLivraison>> listArticleLivraisonByIdArticle(@PathVariable Long idArticle) {
        return ResponseEntity.ok(articleLivraisonService.listArticleLivraisonByIdArticle(idArticle));
    }

    @GetMapping("/{idAL}")
    public ResponseEntity<ArticleLivraison> getArticleLivraisonById(@PathVariable Long idAL) {
        ArticleLivraison articleLivraison = articleLivraisonService.getArticleLivraisonById(idAL);
        return articleLivraison != null ? ResponseEntity.ok(articleLivraison) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleLivraison>> getArticleLivraisonByIdBLAndArticle(@RequestParam Long idBL, @RequestParam Long idArticle) {
        return ResponseEntity.ok(articleLivraisonService.getArticleLivraisonbyidArticle(idBL, idArticle));
    }

    @PostMapping("/affect-to-bon-livraison/{idBL}")
    public ResponseEntity<BonLivraison> affectListArticleLivraisonToBonLivraison(@PathVariable Long idBL, @RequestBody List<ArticleLivraison> listArticleLivraison) {
        BonLivraison bonLivraison = articleLivraisonService.affectListArticleLivraisonToBonLivraison(idBL, listArticleLivraison);
        return bonLivraison != null ? ResponseEntity.ok(bonLivraison) : ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<ArticleLivraison> updateArticleBonLivraison(@RequestBody ArticleLivraison AL) {
        return ResponseEntity.ok(articleLivraisonService.updateArticleBonLivraison(AL));
    }

    @DeleteMapping("/{idAL}")
    public ResponseEntity<Void> deleteArticleBonLivraisonByIdAL(@PathVariable Long idAL) {
        articleLivraisonService.deleteArticleBonLivraisonByIdAL(idAL);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/by-bon-livraison/{idBL}")
    public ResponseEntity<Void> deleteAllArticleBonLivraison(@PathVariable Long idBL) {
        articleLivraisonService.deleteAllArticleBonLivraison(idBL);
        return ResponseEntity.noContent().build();
    }
}
