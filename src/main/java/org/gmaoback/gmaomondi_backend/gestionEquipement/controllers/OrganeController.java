package org.gmaoback.gmaomondi_backend.gestionEquipement.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.OrganeDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.OrganeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Organe")
@CrossOrigin("*")
public class OrganeController {
    @Autowired
    private OrganeService organeService;

    // Méthodes utilisant des entités

    @PostMapping("create")
    public ResponseEntity<Organe> createOrgane(@RequestBody Organe organe) {
        Organe createdOrgane = organeService.createOrgane(organe);
        return ResponseEntity.ok(createdOrgane);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Organe> updateOrgane(@PathVariable Long id, @RequestBody Organe updatedOrgane) {
        Organe updated = organeService.updateOrgane(id, updatedOrgane);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteOrgane(@PathVariable Long id) {
        try {
            organeService.deleteOrgane(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get{id}")
    public ResponseEntity<Organe> getOrganeById(@PathVariable Long id) {
        Organe organe = organeService.getOrganeById(id);
        if (organe != null) {
            return ResponseEntity.ok(organe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<Organe>> getAllOrganes() {
        List<Organe> organes = organeService.getAllOrganes();
        return ResponseEntity.ok(organes);
    }

    // Méthodes utilisant des DTOs

    @PostMapping("/createdto")
    public ResponseEntity<OrganeDTO> createOrganeDTO(@RequestBody OrganeDTO organeDTO) {
        OrganeDTO createdOrganeDTO = organeService.createOrganeDTO(organeDTO);
        return ResponseEntity.ok(createdOrganeDTO);
    }

    @PutMapping("/updatedto/{id}")
    public ResponseEntity<OrganeDTO> updateOrganeDTO(@PathVariable Long id, @RequestBody OrganeDTO organeDTO) {
        OrganeDTO updatedOrganeDTO = organeService.updateOrganeDTO(id, organeDTO);
        if (updatedOrganeDTO != null) {
            return ResponseEntity.ok(updatedOrganeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletedto/{id}")
    public ResponseEntity<Void> deleteOrganeDTO(@PathVariable Long id) {
        try {
            organeService.deleteOrganeDTO(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getdto/{id}")
    public ResponseEntity<OrganeDTO> getOrganeDTOById(@PathVariable Long id) {
        OrganeDTO organeDTO = organeService.getOrganeDTOById(id);
        if (organeDTO != null) {
            return ResponseEntity.ok(organeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<List<OrganeDTO>> getAllOrganesDTO() {
        List<OrganeDTO> organesDTO = organeService.getAllOrganesDTO();
        return ResponseEntity.ok(organesDTO);
    }
}
