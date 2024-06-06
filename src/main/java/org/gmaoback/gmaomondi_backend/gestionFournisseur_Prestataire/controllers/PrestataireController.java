package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.controllers;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/dto")
    public ResponseEntity<PrestataireDTO> createPrestataireDTO(@RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO createdPrestataire = prestataireService.createPrestataireDTO(prestataireDTO);
        return new ResponseEntity<>(createdPrestataire, HttpStatus.CREATED);
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<PrestataireDTO> updatePrestataireDTO(@PathVariable Long id, @RequestBody PrestataireDTO prestataireDTO) {
        PrestataireDTO updatedPrestataire = prestataireService.updatePrestataireDTO(id, prestataireDTO);
        if (updatedPrestataire != null) {
            return new ResponseEntity<>(updatedPrestataire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dto/{id}")
    public ResponseEntity<Void> deletePrestataireDTO(@PathVariable Long id) {
        try {
            prestataireService.deletePrestataireDTO(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<PrestataireDTO> getPrestataireDTOById(@PathVariable Long id) {
        PrestataireDTO prestataireDTO = prestataireService.getPrestataireDTOById(id);
        if (prestataireDTO != null) {
            return new ResponseEntity<>(prestataireDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<List<PrestataireDTO>> getAllPrestatairesDTO() {
        List<PrestataireDTO> prestataires = prestataireService.getAllPrestatairesDTO();
        return new ResponseEntity<>(prestataires, HttpStatus.OK);
    }

    // Méthodes utilisant des entités

    @PostMapping
    public ResponseEntity<Prestataire> createPrestataire(@RequestBody Prestataire prestataire) {
        Prestataire createdPrestataire = prestataireService.createPrestataire(prestataire);
        return new ResponseEntity<>(createdPrestataire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestataire> updatePrestataire(@PathVariable Long id, @RequestBody Prestataire prestataire) {
        Prestataire updatedPrestataire = prestataireService.updatePrestataire(id, prestataire);
        if (updatedPrestataire != null) {
            return new ResponseEntity<>(updatedPrestataire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestataire(@PathVariable Long id) {
        try {
            prestataireService.deletePrestataireEntity(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestataire> getPrestataireById(@PathVariable Long id) {
        Prestataire prestataire = prestataireService.getPrestataireByIdEntity(id);
        if (prestataire != null) {
            return new ResponseEntity<>(prestataire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Prestataire>> getAllPrestataires() {
        List<Prestataire> prestataires = prestataireService.getAllPrestatairesEntity();
        return new ResponseEntity<>(prestataires, HttpStatus.OK);
    }
}