package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Famille;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familles")
public class FamilleController {

    @Autowired
    private FamilleService familleService;

    @PostMapping("/saveFamille")
    public Famille saveFamille(@RequestBody Famille famille) {
        return familleService.saveFamille(famille);
    }

    @PutMapping("/{id}")
    public Famille updateFamille(@PathVariable("id") Long id, @RequestBody Famille famille) {
        famille.setIdFamille(id);
        return familleService.updateFamille(famille);
    }

    @GetMapping("/{id}")
    public Famille getFamilleById(@PathVariable("id") Long id) {
        return familleService.getFamilleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFamilleById(@PathVariable("id") Long id) {
        familleService.deleteFamilleById(id);
    }
}
