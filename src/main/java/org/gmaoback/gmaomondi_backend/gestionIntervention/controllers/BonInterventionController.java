package org.gmaoback.gmaomondi_backend.gestionIntervention.controllers;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.BonInterventionDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.BonInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BonIntervention")
@CrossOrigin("*")
public class BonInterventionController {
    @Autowired
    private BonInterventionService bonInterventionService;

    @PostMapping
    public ResponseEntity<BonInterventionDTO> createBonIntervention(@RequestBody BonInterventionDTO bonInterventionDTO) {
        BonInterventionDTO createdBonIntervention = bonInterventionService.createBonIntervention(bonInterventionDTO);
        return ResponseEntity.ok(createdBonIntervention);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonInterventionDTO> getBonInterventionById(@PathVariable Long id) {
        BonInterventionDTO bonInterventionDTO = bonInterventionService.getBonInterventionById(id);
        return ResponseEntity.ok(bonInterventionDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BonInterventionDTO>> getAllBonInterventions() {
        List<BonInterventionDTO> bonInterventions = bonInterventionService.getAllBonInterventions();
        return ResponseEntity.ok(bonInterventions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BonInterventionDTO> updateBonIntervention(@PathVariable Long id, @RequestBody BonInterventionDTO bonInterventionDTO) {
        BonInterventionDTO updatedBonIntervention = bonInterventionService.updateBonIntervention(id, bonInterventionDTO);
        return ResponseEntity.ok(updatedBonIntervention);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<?> deleteBonIntervention(@PathVariable Long id) {
        bonInterventionService.deleteBonIntervention(id);
        return ResponseEntity.noContent().build();
    }
}
