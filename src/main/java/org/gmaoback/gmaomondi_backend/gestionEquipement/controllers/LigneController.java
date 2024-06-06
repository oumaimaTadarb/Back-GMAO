package org.gmaoback.gmaomondi_backend.gestionEquipement.controllers;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.LigneDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.LigneService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ligne")
@CrossOrigin("*")
public class LigneController {
    @Autowired
    private LigneService ligneService;

    // Méthodes utilisant des entités

    @PostMapping("/create")
    public ResponseEntity<Ligne> createLigne(@RequestBody Ligne ligne) {
        Ligne createdLigne = ligneService.createLigne(ligne);
        return ResponseEntity.ok(createdLigne);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Ligne> updateLigne(@PathVariable Long id, @RequestBody Ligne updatedLigne) {
        Ligne updated = ligneService.updateLigne(id, updatedLigne);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteLigne(@PathVariable Long id) {
        try {
            ligneService.deleteLigne(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get{id}")
    public ResponseEntity<Ligne> getLigneById(@PathVariable Long id) {
        Ligne ligne = ligneService.getLigneById(id);
        if (ligne != null) {
            return ResponseEntity.ok(ligne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Ligne>> getAllLignes() {
        List<Ligne> lignes = ligneService.getAllLignes();
        return ResponseEntity.ok(lignes);
    }

    // Méthodes utilisant des DTOs

    @PostMapping("/createdto")
    public ResponseEntity<LigneDTO> createLigneDTO(@RequestBody LigneDTO ligneDTO) {
        LigneDTO createdLigneDTO = ligneService.createLigneDTO(ligneDTO);
        return ResponseEntity.ok(createdLigneDTO);
    }

    @PutMapping("/updatedto/{id}")
    public ResponseEntity<LigneDTO> updateLigneDTO(@PathVariable Long id, @RequestBody LigneDTO ligneDTO) {
        LigneDTO updatedLigneDTO = ligneService.updateLigneDTO(id, ligneDTO);
        if (updatedLigneDTO != null) {
            return ResponseEntity.ok(updatedLigneDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletedto/{id}")
    public ResponseEntity<Void> deleteLigneDTO(@PathVariable Long id) {
        try {
            ligneService.deleteLigneDTO(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getdto/{id}")
    public ResponseEntity<LigneDTO> getLigneDTOById(@PathVariable Long id) {
        LigneDTO ligneDTO = ligneService.getLigneDTOById(id);
        if (ligneDTO != null) {
            return ResponseEntity.ok(ligneDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listdto")
    public ResponseEntity<List<LigneDTO>> getAllLignesDTO() {
        List<LigneDTO> lignesDTO = ligneService.getAllLignesDTO();
        return ResponseEntity.ok(lignesDTO);
    }

}
