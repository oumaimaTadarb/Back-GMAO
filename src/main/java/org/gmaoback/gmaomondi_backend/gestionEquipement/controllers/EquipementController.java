package org.gmaoback.gmaomondi_backend.gestionEquipement.controllers;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.EquipementDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.EquipementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipement")
@CrossOrigin("*")
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    // Méthodes utilisant des entités

    @PostMapping
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement equipement) {
        Equipement createdEquipement = equipementService.createEquipement(equipement);
        return ResponseEntity.ok(createdEquipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement updatedEquipement) {
        Equipement updated = equipementService.updateEquipement(id, updatedEquipement);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        try {
            equipementService.deleteEquipement(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Equipement equipement = equipementService.getEquipementById(id);
        if (equipement != null) {
            return ResponseEntity.ok(equipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipements();
        return ResponseEntity.ok(equipements);
    }

    // Méthodes utilisant des DTOs

    @PostMapping("/dto")
    public ResponseEntity<EquipementDTO> createEquipementDTO(@RequestBody EquipementDTO equipementDTO) {
        EquipementDTO createdEquipementDTO = equipementService.createEquipementDTO(equipementDTO);
        return ResponseEntity.ok(createdEquipementDTO);
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<EquipementDTO> updateEquipementDTO(@PathVariable Long id, @RequestBody EquipementDTO equipementDTO) {
        EquipementDTO updatedEquipementDTO = equipementService.updateEquipementDTO(id, equipementDTO);
        if (updatedEquipementDTO != null) {
            return ResponseEntity.ok(updatedEquipementDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/dto/{id}")
    public ResponseEntity<Void> deleteEquipementDTO(@PathVariable Long id) {
        try {
            equipementService.deleteEquipementDTO(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<EquipementDTO> getEquipementDTOById(@PathVariable Long id) {
        EquipementDTO equipementDTO = equipementService.getEquipementDTOById(id);
        if (equipementDTO != null) {
            return ResponseEntity.ok(equipementDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<List<EquipementDTO>> getAllEquipementsDTO() {
        List<EquipementDTO> equipementsDTO = equipementService.getAllEquipementsDTO();
        return ResponseEntity.ok(equipementsDTO);
    }
}
