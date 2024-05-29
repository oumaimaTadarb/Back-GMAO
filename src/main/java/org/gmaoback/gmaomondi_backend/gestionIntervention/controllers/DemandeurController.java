package org.gmaoback.gmaomondi_backend.gestionIntervention.controllers;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.DemandeurDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.DemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Demandeur")
@CrossOrigin("*")
public class DemandeurController {

    @Autowired
    private DemandeurService demandeurService;

    @PostMapping
    public ResponseEntity<DemandeurDTO> createDemandeur(@RequestBody DemandeurDTO demandeurDTO) {
        DemandeurDTO createdDemandeur = demandeurService.createDemandeur(demandeurDTO);
        return ResponseEntity.ok(createdDemandeur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeurDTO> getDemandeurById(@PathVariable Long id) {
        DemandeurDTO demandeurDTO = demandeurService.getDemandeurById(id);
        return ResponseEntity.ok(demandeurDTO);
    }

    @GetMapping
    public ResponseEntity<List<DemandeurDTO>> getAllDemandeurs() {
        List<DemandeurDTO> demandeurs = demandeurService.getAllDemandeurs();
        return ResponseEntity.ok(demandeurs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeurDTO> updateDemandeur(@PathVariable Long id, @RequestBody DemandeurDTO demandeurDTO) {
        DemandeurDTO updatedDemandeur = demandeurService.updateDemandeur(id, demandeurDTO);
        return ResponseEntity.ok(updatedDemandeur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemandeur(@PathVariable Long id) {
        demandeurService.deleteDemandeur(id);
        return ResponseEntity.noContent().build();
    }
}
