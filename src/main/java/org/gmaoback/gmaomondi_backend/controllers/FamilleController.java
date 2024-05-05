package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.Famille;
import org.gmaoback.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familles")
public class FamilleController {

    @Autowired
    private FamilleService familleService;

    @PostMapping("/save")
    public Famille saveFamille(@RequestBody Famille famille) {
        return familleService.saveFamille(famille);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFamilleById(@PathVariable("id") Long idFamille) {
        familleService.deleteFamilleById(idFamille);
    }

    @GetMapping("/{id}/articles")
    public List<Article> getAllArticlesByFamilleId(@PathVariable("id") Long idFamille) {
        return familleService.getAllArticlesByFamilleId(idFamille);
    }

    @GetMapping("/{id}")
    public List<Famille> getFamillesFillesById(@PathVariable("id") Long idFamille) {
        return familleService.getFamillesFillesById(idFamille);
    }
}