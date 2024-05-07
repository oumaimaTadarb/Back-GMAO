package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.models.BonLivraison;
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
    @GetMapping("/codeSapBL/{codeSapBL}")
    public BonLivraison getBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL) {
        return bonLivraisonService.getBonLivraisonByCodeSapBL(codeSapBL);

    }

    @GetMapping("/page")
    public Page<BonLivraison> getAllBonLivraisonsByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bonLivraisonService.getAllBonLivraisonByPage(page, size);
    }

    @PutMapping("/update/{codeSapBL}")
    public BonLivraison updateBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL, @RequestBody BonLivraison updatedBonLivraison) {
        return bonLivraisonService.updateBonLivraisonByCodeSapBL(codeSapBL, updatedBonLivraison);
    }

    @DeleteMapping("/delete/{codeSapBL}")
    public void deleteBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL) {
        bonLivraisonService.deleteBonLivraisonByCodeSapBL(codeSapBL);
    }

}
