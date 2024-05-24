package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.services.ArticleCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articleCommande")
@CrossOrigin("*")
public class ArticleCommandeController {
    @Autowired
    private ArticleCommandeService articleCommandeService;

    @GetMapping("/by-bon-commande/{idBC}")
    public ResponseEntity<List<ArticleCommande>> listArticlesCommandeByIdBC(@PathVariable Long idBC) {
        return ResponseEntity.ok(articleCommandeService.listArticlesCommmandeByIdBC(idBC));
    }

    @GetMapping("/by-article/{idArticle}")
    public ResponseEntity<List<ArticleCommande>> listArticlesCommandeByIdArticle(@PathVariable Long idArticle) {
        return ResponseEntity.ok(articleCommandeService.listArticlesCommandeByIdArticle(idArticle));
    }

    @GetMapping("/{idAC}")
    public ResponseEntity<ArticleCommande> getArticleCommandeById(@PathVariable Long idAC) {
        ArticleCommande articleCommande = articleCommandeService.getArticleCommandeById(idAC);
        return articleCommande != null ? ResponseEntity.ok(articleCommande) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleCommande>> getArticleCommandeByIdBCAndIdArticle(@RequestParam Long idBC, @RequestParam Long idArticle) {
        return ResponseEntity.ok(articleCommandeService.getArticlecommandebyidArticle(idBC, idArticle));
    }

    @PostMapping("/affect-to-bon-commande/{idBC}")
    public ResponseEntity<BonCommande> affectListArticleCommandeToBonCommande(@PathVariable Long idBC, @RequestBody List<ArticleCommande> listArticleCommande) {
        BonCommande bonCommande = articleCommandeService.affectListArticleCommandeToBonCommande(idBC, listArticleCommande);
        return bonCommande != null ? ResponseEntity.ok(bonCommande) : ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<ArticleCommande> updateArticleBonCommande(@RequestBody ArticleCommande AC) {
        return ResponseEntity.ok(articleCommandeService.updateArticleBonCommande(AC));
    }

    @DeleteMapping("/delete/{idAC}")
    public ResponseEntity<Void> deleteArticleBonCommandeByIdAC(@PathVariable Long idAC) {
        articleCommandeService.deleteArticleBonCommandeByIdAC(idAC);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/by-bon-commande/{idBC}")
    public ResponseEntity<Void> deleteAllArticleCommandeofBonCommande(@PathVariable Long idBC) {
        articleCommandeService.deleteAllArticleCommandeofBonCommande(idBC);
        return ResponseEntity.noContent().build();
    }

}
