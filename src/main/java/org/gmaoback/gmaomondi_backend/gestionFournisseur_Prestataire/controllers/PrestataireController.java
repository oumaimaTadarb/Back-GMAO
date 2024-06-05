package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.controllers;

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

    @PostMapping
    public ResponseEntity<PrestataireDTO> createPrestataire(@RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO createdPrestataire = prestataireService.createPrestataire(prestataireDTO);
        return ResponseEntity.ok(createdPrestataire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestataireDTO> updatePrestataire(@PathVariable Long id, @RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO updatedPrestataire = prestataireService.updatePrestataire(id, prestataireDTO);
        if (updatedPrestataire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrestataire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestataire(@PathVariable Long id) {
        try {
            prestataireService.deletePrestataire(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestataireDTO> getPrestataireById(@PathVariable Long id) {
        PrestataireDTO prestataireDTO = prestataireService.getPrestataireById(id);
        if (prestataireDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestataireDTO);
    }

    @GetMapping
    public ResponseEntity<List<PrestataireDTO>> getAllPrestataires() {
        List<PrestataireDTO> prestataires = prestataireService.getAllPrestataires();
        return ResponseEntity.ok(prestataires);
    }
}
