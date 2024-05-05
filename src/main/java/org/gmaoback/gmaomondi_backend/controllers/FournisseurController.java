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
    @PutMapping("/{codeSapFr}")
    public Fournisseur updateFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr, @RequestBody Fournisseur updatedFournisseur) {
        return fournisseurService.updateFournisseurByCodeSapFr(codeSapFr, updatedFournisseur);
    }

    @DeleteMapping("/{codeSapFr}")
    public void deleteFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr) {
        fournisseurService.deleteFournisseurByCodeSapFr(codeSapFr);
    }
}
