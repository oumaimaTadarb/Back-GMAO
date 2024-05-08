package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.Fournisseur;
import org.gmaoback.gmaomondi_backend.dto.FournisseurDTO;
import org.gmaoback.gmaomondi_backend.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @PostMapping
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody FournisseurDTO fournisseurDto) {
        Fournisseur savedFournisseur = fournisseurService.addNewFournisseur(fournisseurDto);
        return new ResponseEntity<>(savedFournisseur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(id, fournisseurDTO);
        if (updatedFournisseur != null) {
            return new ResponseEntity<>(updatedFournisseur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        try {
            fournisseurService.deleteFournisseur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> listFournisseursDTO() {
        List<FournisseurDTO> fournisseurs = fournisseurService.listFournisseursDTO();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fournisseur>> listFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.listFournisseurs();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> loadFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.loadFournisseurById(id);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/updateData/{id}")
    public ResponseEntity<Fournisseur> updateFournisseurData(@PathVariable Long id, @RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur existingFournisseur = fournisseurService.loadFournisseurById(id);
        if (existingFournisseur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Fournisseur updatedFournisseur = fournisseurService.updateData(existingFournisseur, fournisseurDTO);
        return new ResponseEntity<>(updatedFournisseur, HttpStatus.OK);
    }
    @GetMapping("/fournisseurDTO/{id}")
    public ResponseEntity<FournisseurDTO> loadFournisseurByFournisseurId(@PathVariable Long id) {
        FournisseurDTO fournisseurDto = fournisseurService.loadFournisseurByFournisseurId(id);
        if (fournisseurDto != null) {
            return new ResponseEntity<>(fournisseurDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/codeSapFr/{codeSapFr}")
    public ResponseEntity<Fournisseur> loadFournisseurByCodeSapFr(@PathVariable Long codeSapFr) {
        Fournisseur fournisseur = fournisseurService.loadFournisseurBycodeSapFr(codeSapFr);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
//    @PostMapping("/saveFournisseur")
//    public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur) {
//        return fournisseurService.saveFournisseur(fournisseur);
//    }
//
//    @PutMapping("/{id}")
//    public Fournisseur updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur fournisseur) {
//        fournisseur.setIdFournisseur(id);
//        return fournisseurService.updateFournisseur(fournisseur);
//    }
//
//    @GetMapping("/{id}")
//    public Fournisseur getFournisseurById(@PathVariable("id") Long id) {
//        return fournisseurService.getFournisseurById(id);
//    }
//    @GetMapping("/codeSapFr/{codeSapFr}")
//    public Fournisseur getBonLivraisonBycodeSapFr(@PathVariable Long codeSapFr) {
//        return fournisseurService.getFournisseurBycodeSapFr(codeSapFr);
//
//    }
//    @PutMapping("/{codeSapFr}")
//    public Fournisseur updateFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr, @RequestBody Fournisseur updatedFournisseur) {
//        return fournisseurService.updateFournisseurByCodeSapFr(codeSapFr, updatedFournisseur);
//    }
//
//    @DeleteMapping("/{codeSapFr}")
//    public void deleteFournisseurByCodeSapFr(@PathVariable("codeSapFr") Long codeSapFr) {
//        fournisseurService.deleteFournisseurByCodeSapFr(codeSapFr);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteFournisseurById(@PathVariable("id") Long id) {
//        fournisseurService.deleteFournisseurById(id);
//    }
//
//    @GetMapping
//    public List<Fournisseur> getAllFournisseurs() {
//        return fournisseurService.getAllFournisseurs();
//    }

