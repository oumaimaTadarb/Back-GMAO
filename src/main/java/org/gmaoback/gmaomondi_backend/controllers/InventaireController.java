package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventaires")
public class InventaireController {

    @Autowired
    private InventaireService inventaireService;
    @GetMapping("/page")
    public Page<Inventaire> getAllInventairesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return inventaireService.getAllInventairesByPage(page, size);
    }

    @PostMapping("/saveInventaire")
    public Inventaire saveInventaire(@RequestBody Inventaire inventaire) {
        return inventaireService.saveInventaire(inventaire);
    }

    @PutMapping("/{id}")
    public Inventaire updateInventaire(@PathVariable("id") Long id, @RequestBody Inventaire inventaire) {
        inventaire.setIdInventaire(id); // Assurez-vous que l'ID de l'inventaire est défini
        return inventaireService.updateInventaire(inventaire);
    }

    @GetMapping("/{id}")
    public Inventaire getInventaireById(@PathVariable("id") Long id) {
        return inventaireService.getInventaireById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInventaireById(@PathVariable("id") Long id) {
        inventaireService.deleteInventaireById(id);
    }

    @GetMapping
    public List<Inventaire> getAllInventaires() {
        return inventaireService.getAllInventaires();
    }


}
