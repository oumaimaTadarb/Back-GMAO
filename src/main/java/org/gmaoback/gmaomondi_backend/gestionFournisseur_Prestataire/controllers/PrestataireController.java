package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.controllers;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.service.PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Prestataire")
@CrossOrigin("*")
public class PrestataireController {
    @Autowired
    private PrestataireService prestataireService;

    // Méthodes utilisant des DTOs

    @PostMapping
    public ResponseEntity<PrestataireDTO> createPrestataireDTO(@RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO createdPrestataire = prestataireService.createPrestataireDTO(prestataireDTO);
        return ResponseEntity.ok(createdPrestataire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestataireDTO> updatePrestataireDTO(@PathVariable Long id, @RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO updatedPrestataire = prestataireService.updatePrestataireDTO(id, prestataireDTO);
        if (updatedPrestataire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrestataire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestataireDTO(@PathVariable Long id) {
        try {
            prestataireService.deletePrestataireDTO(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestataireDTO> getPrestataireDTOById(@PathVariable Long id) {
        PrestataireDTO prestataireDTO = prestataireService.getPrestataireDTOById(id);
        if (prestataireDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestataireDTO);
    }

    @GetMapping
    public ResponseEntity<List<PrestataireDTO>> getAllPrestatairesDTO() {
        List<PrestataireDTO> prestataires = prestataireService.getAllPrestatairesDTO();
        return ResponseEntity.ok(prestataires);
    }

    // Méthodes utilisant des entités

    @PostMapping("/entity")
    public ResponseEntity<Prestataire> createPrestataire(@RequestBody Prestataire prestataire) {
        Prestataire createdPrestataire = prestataireService.createPrestataire(prestataire);
        return ResponseEntity.ok(createdPrestataire);
    }

    @PutMapping("/entity/{id}")
    public ResponseEntity<Prestataire> updatePrestataire(@PathVariable Long id, @RequestBody Prestataire prestataire) {
        Prestataire updatedPrestataire = prestataireService.updatePrestataire(id, prestataire);
        if (updatedPrestataire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrestataire);
    }

    @DeleteMapping("/entity/{id}")
    public ResponseEntity<Void> deletePrestataireEntity(@PathVariable Long id) {
        try {
            prestataireService.deletePrestataireEntity(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Prestataire> getPrestataireByIdEntity(@PathVariable Long id) {
        Prestataire prestataire = prestataireService.getPrestataireByIdEntity(id);
        if (prestataire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestataire);
    }

    @GetMapping("/entity")
    public ResponseEntity<List<Prestataire>> getAllPrestatairesEntity() {
        List<Prestataire> prestataires = prestataireService.getAllPrestatairesEntity();
        return ResponseEntity.ok(prestataires);
    }

}