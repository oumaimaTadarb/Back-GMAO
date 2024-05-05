package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
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
