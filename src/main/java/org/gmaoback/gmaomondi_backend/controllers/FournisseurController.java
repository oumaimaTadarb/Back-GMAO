package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/codeSapFr/{codeSapFr}")
    public Fournisseur getBonLivraisonBycodeSapFr(@PathVariable Long codeSapFr) {
        return fournisseurService.getFournisseurBycodeSapFr(codeSapFr);

    }
//
//    @PostMapping("/saveFournisseur")
//    public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur) {
//        return fournisseurService.saveFournisseur(fournisseur);
//    }
//
//    @PutMapping("/{id}")
//    public Fournisseur updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur fournisseur) {
//        fournisseur.setIdFournisseur(id);
//        return fournisseurService.updateFournisseur(fournisseur);
//    }
//
//    @GetMapping("/{id}")
//    public Fournisseur getFournisseurById(@PathVariable("id") Long id) {
//        return fournisseurService.getFournisseurById(id);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteFournisseurById(@PathVariable("id") Long id) {
//        fournisseurService.deleteFournisseurById(id);
//    }
//
//    @GetMapping
//    public List<Fournisseur> getAllFournisseurs() {
//        return fournisseurService.getAllFournisseurs();
//    }
}
