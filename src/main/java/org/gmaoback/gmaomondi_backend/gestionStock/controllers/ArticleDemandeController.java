package org.gmaoback.gmaomondi_backend.gestionStock.controllers;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleDemande;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.gestionStock.services.ArticleDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articleDemande")
@CrossOrigin("*")
public class ArticleDemandeController {
    @Autowired
    private ArticleDemandeService articleDemandeService;

    @GetMapping("/by-demande-achat/{idDA}")
    public ResponseEntity<List<ArticleDemande>> listArticleDemandeByIdDA(@PathVariable Long idDA) {
        return ResponseEntity.ok(articleDemandeService.listArticleDemandeByIdDA(idDA));
    }

    @GetMapping("/by-article/{idArticle}")
    public ResponseEntity<List<ArticleDemande>> listArticleDemandeByIdArticle(@PathVariable Long idArticle) {
        return ResponseEntity.ok(articleDemandeService.listArticleDemandeByIdArticle(idArticle));
    }

    @GetMapping("/{idAD}")
    public ResponseEntity<ArticleDemande> getArticleDemandeById(@PathVariable Long idAD) {
        ArticleDemande articleDemande = articleDemandeService.getArticleCommandeById(idAD);
        return articleDemande != null ? ResponseEntity.ok(articleDemande) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleDemande>> getArticleDemandeByIdDAAndArticle(@RequestParam Long idDA, @RequestParam Long idArticle) {
        return ResponseEntity.ok(articleDemandeService.getArticleDemandebyidArticle(idDA, idArticle));
    }

    @PostMapping("/affect-to-demande-achat/{idDA}")
    public ResponseEntity<DemandeAchat> affectListArticleDemandeToDemandeAchat(@PathVariable Long idDA, @RequestBody List<ArticleDemande> listArticleDemande) {
        DemandeAchat demandeAchat = articleDemandeService.affectListArticleCommandeToDemandeAchat(idDA, listArticleDemande);
        return demandeAchat != null ? ResponseEntity.ok(demandeAchat) : ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<ArticleDemande> updateArticleDemandeAchat(@RequestBody ArticleDemande AD) {
        return ResponseEntity.ok(articleDemandeService.updateArticleDemandeAchat(AD));
    }

    @DeleteMapping("/{idAD}")
    public ResponseEntity<Void> deleteArticleDemandeAchatByIdAD(@PathVariable Long idAD) {
        articleDemandeService.deleteArticleDemandeAchatByIdAD(idAD);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/by-demande-achat/{idDA}")
    public ResponseEntity<Void> deleteAllArticleCommandeOfDemandeAchat(@PathVariable Long idDA) {
        articleDemandeService.deleteAllArticleCommandeofBonCommande(idDA);
        return ResponseEntity.noContent().build();
    }

}
