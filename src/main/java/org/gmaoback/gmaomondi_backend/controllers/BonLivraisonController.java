package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.services.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonLivraisons")
public class BonLivraisonController {

    @Autowired
    private BonLivraisonService bonLivraisonService;

    @PostMapping("/saveBL")
    public BonLivraison saveBonLivraison(@RequestBody BonLivraison bonLivraison) {
        return bonLivraisonService.saveBonLivraison(bonLivraison);
    }

    @PutMapping("/{id}")
    public BonLivraison updateBonLivraison(@PathVariable("id") Long id, @RequestBody BonLivraison bonLivraison) {
        bonLivraison.setIdBL(id);
        return bonLivraisonService.updateBonLivraison(bonLivraison);
    }

    @GetMapping("/{id}")
    public BonLivraison getBonLivraisonById(@PathVariable("id") Long id) {
        return bonLivraisonService.getBonLivraisonById(id);
    }

    @GetMapping
    public List<BonLivraison> getAllBonLivraisons() {
        return bonLivraisonService.getAllBonLivraison();
    }

    @DeleteMapping("/{id}")
    public void deleteBonLivraisonById(@PathVariable("id") Long id) {
        bonLivraisonService.deleteBonLivraisonById(id);
    }

    @GetMapping("/fournisseur/{idFournisseur}")
    public List<BonLivraison> getAllBonLivraisonsByFournisseur(@PathVariable("idFournisseur") Long idFournisseur) {
        return bonLivraisonService.findAllByIdFournisseur(idFournisseur);
    }

    @GetMapping("/page")
    public Page<BonLivraison> getAllBonLivraisonsByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bonLivraisonService.getAllBonLivraisonByPage(page, size);
    }
}
