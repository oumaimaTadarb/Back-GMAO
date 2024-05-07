package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familles")
public class FamilleController {

    @Autowired
    private FamilleService familleService;
//
//    @PutMapping("/{id}")
//    public Famille updateFamille(@PathVariable("id") Long id, @RequestBody Famille famille) {
//        famille.setIdFamille(id);
//        return familleService.updateFamille(famille);
//    }
//
//    @GetMapping("/{id}")
//    public Famille getFamilleById(@PathVariable("id") Long id) {
//        return familleService.getFamilleById(id);
//    }
//
//    @PostMapping("/save")
//    public Famille saveFamille(@RequestBody Famille famille) {
//        return familleService.saveFamille(famille);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteFamilleById(@PathVariable("id") Long idFamille) {
//        familleService.deleteFamilleById(idFamille);
//    }
//
//    @GetMapping("/{id}/articles")
//    public List<Article> getAllArticlesByFamilleId(@PathVariable("id") Long idFamille) {
//        return familleService.getAllArticlesByFamilleId(idFamille);
//    }
//
//    @GetMapping("/famillesdilles/{id}")
//    public List<Famille> getFamillesFillesById(@PathVariable("id") Long idFamille) {
//        return familleService.getFamillesFillesById(idFamille);
//    }
//    @GetMapping("/sap-codes/{id}")
//    public List<Long> getAllSapCodesByFamilleId(@PathVariable("id") Long idFamille) {
//        return familleService.getAllSapCodesByFamilleId(idFamille);
//    }
///*
//    @PutMapping("/{idFamille}/mere/{idFamilleMere}")
//    public Famille assignFamilleMere(@PathVariable Long idFamille, @PathVariable Long idFamilleMere) {
//        return familleService.assignFamilleMere(idFamille, idFamilleMere);
//    }*/
}