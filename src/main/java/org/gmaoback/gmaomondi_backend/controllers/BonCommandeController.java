package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.entites.BonCommande;
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

    @PostMapping
    public BonCommande saveBonCommande(@RequestBody BonCommande bonCommande) {
        return bonCommandeService.saveBonCommande(bonCommande);
    }

    @PutMapping("/{id}")
    public BonCommande updateBonCommande(@PathVariable("id") Long id, @RequestBody BonCommande bonCommande) {
        bonCommande.setIdBC(id); // Assurez-vous que l'id du bon de commande est défini
        return bonCommandeService.updateBonCommande(bonCommande);
    }

    @GetMapping("/{id}")
    public BonCommande getBonCommandeById(@PathVariable("id") Long id) {
        return bonCommandeService.getBonCommandeById(id);
    }

    @GetMapping
    public List<BonCommande> getAllBonCommandes() {
        return bonCommandeService.getAllBonCommandes();
    }

    @DeleteMapping("/{id}")
    public void deleteBonCommandeById(@PathVariable("id") Long id) {
        bonCommandeService.deleteBonCommandeById(id);
    }

    @GetMapping("/fournisseur/{idFournisseur}")
    public List<BonCommande> getAllBonCommandesByFournisseur(@PathVariable("idFournisseur") Long idFournisseur) {
        return bonCommandeService.findAllByIdFournisseur(idFournisseur);
    }

    @GetMapping("/page")
    public Page<BonCommande> getAllBonCommandesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bonCommandeService.getAllBonCommandesByPage(page, size);
    }
}

