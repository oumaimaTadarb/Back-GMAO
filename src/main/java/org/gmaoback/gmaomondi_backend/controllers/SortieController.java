package org.gmaoback.gmaomondi_backend.controllers;

import org.gmaoback.gmaomondi_backend.dao.entites.Sortie;
import org.gmaoback.gmaomondi_backend.services.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sorties")
public class SortieController {

    @Autowired
    private SortieService sortieService;
    @GetMapping("/page")
    public Page<Sortie> getAllSortiesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return sortieService.getAllSortiesByPage(page, size);
    }

    @PostMapping("/saveSortie")
    public Sortie saveSortie(@RequestBody Sortie sortie) {
        return sortieService.saveSortie(sortie);
    }

    @PutMapping("/{id}")
    public Sortie updateSortie(@PathVariable("id") Long id, @RequestBody Sortie sortie) {
        sortie.setIdSortie(id); // Assurez-vous que l'ID de la sortie est défini
        return sortieService.updateSortie(sortie);
    }

    @GetMapping("/{id}")
    public Sortie getSortieById(@PathVariable("id") Long id) {
        return sortieService.getSortieById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSortieById(@PathVariable("id") Long id) {
        sortieService.deleteSortieById(id);
    }

    @GetMapping
    public List<Sortie> getAllSorties() {
        return sortieService.getAllSorties();
    }


}
