package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.services.BonCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonCommandes")
public class BonCommandeController {

    @Autowired
    private BonCommandeService bonCommandeService;

    @GetMapping("/codeSapBC/{codeSapBC}")
    public BonCommande getBonCommandeByCodeSapBC(@PathVariable Long codeSapBC) {
        return bonCommandeService.getBonCommandeByCodeSapBC(codeSapBC);
    }

    @GetMapping("/page")
    public Page<BonCommande> getAllBonCommandesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bonCommandeService.getAllBonCommandesByPage(page, size);
    }

    @PutMapping("/update/{codeSapBC}")
    public BonCommande updateBonCommandeByCodeSapBC(@PathVariable Long codeSapBC, @RequestBody BonCommande updatedBonCommande) {
        return bonCommandeService.updateBonCommandeByCodeSapBC(codeSapBC, updatedBonCommande);
    }

    @DeleteMapping("/delete/{codeSapBC}")
    public void deleteBonCommandeByCodeSapBC(@PathVariable Long codeSapBC) {
        bonCommandeService.deleteBonCommandeByCodeSapBC(codeSapBC);
    }

}

