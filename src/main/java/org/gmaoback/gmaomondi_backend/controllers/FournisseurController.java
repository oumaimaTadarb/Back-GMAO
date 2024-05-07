package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.models.Fournisseur;
import org.gmaoback.gmaomondi_backend.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;
    @PostMapping("/saveFournisseur")
    public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.saveFournisseur(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur fournisseur) {
        fournisseur.setIdFournisseur(id);
        return fournisseurService.updateFournisseur(fournisseur);
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable("id") Long id) {
        return fournisseurService.getFournisseurById(id);
    }
    @GetMapping("/codeSapFr/{codeSapFr}")
    public Fournisseur getBonLivraisonBycodeSapFr(@PathVariable Long codeSapFr) {
        return fournisseurService.getFournisseurBycodeSapFr(codeSapFr);

    }
    @PutMapping("/{codeSapFr}")
    public Fournisseur updateFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr, @RequestBody Fournisseur updatedFournisseur) {
        return fournisseurService.updateFournisseurByCodeSapFr(codeSapFr, updatedFournisseur);
    }

    @DeleteMapping("/{codeSapFr}")
    public void deleteFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr) {
        fournisseurService.deleteFournisseurByCodeSapFr(codeSapFr);
    }
    @DeleteMapping("/{id}")
    public void deleteFournisseurById(@PathVariable("id") Long id) {
        fournisseurService.deleteFournisseurById(id);
    }

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }
}
