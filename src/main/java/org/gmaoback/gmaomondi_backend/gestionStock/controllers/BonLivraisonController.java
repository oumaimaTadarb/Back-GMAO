package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.BonLivraisonDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonLivraisons")
@CrossOrigin("*")
public class BonLivraisonController {

    @Autowired
    private BonLivraisonService bonLivraisonService;

    @PostMapping("/add")
    public ResponseEntity<BonLivraison> addNewBonLivraison(@RequestBody BonLivraisonDTO bonLivraisonDto) {
        BonLivraison createdBonLivraison = bonLivraisonService.addNewBonLivraison(bonLivraisonDto);
        return ResponseEntity.ok(createdBonLivraison);
    }

    @GetMapping("/listBL")
    public ResponseEntity<List<BonLivraison>> listBonLivraisons() {
        List<BonLivraison> bonLivraisons = bonLivraisonService.listBonLivraisons();
        return ResponseEntity.ok(bonLivraisons);
    }

    @GetMapping("/load by/{id}")
    public ResponseEntity<BonLivraison> loadBonLivraisonById(@PathVariable Long id) {
        BonLivraison bonLivraison = bonLivraisonService.loadBonLivraisonById(id);
        if (bonLivraison != null) {
            return ResponseEntity.ok(bonLivraison);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BonLivraison> updateBonLivraison(@PathVariable Long id, @RequestBody BonLivraisonDTO bonLivraisonDTO) {
        try {
            BonLivraison updatedBonLivraison = bonLivraisonService.updateBonLivraison(id, bonLivraisonDTO);
            return ResponseEntity.ok(updatedBonLivraison);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBonLivraison(@PathVariable Long id) {
        try {
            bonLivraisonService.deleteBonLivraison(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<BonLivraisonDTO>> listBonLivraisonsDTO() {
        List<BonLivraisonDTO> bonLivraisons = bonLivraisonService.listBonLivraisonsDTO();
        return ResponseEntity.ok(bonLivraisons);
    }

    @GetMapping("/by{id}")
    public ResponseEntity<BonLivraisonDTO> loadBonLivraisonDTOById(@PathVariable Long id) {
        BonLivraisonDTO bonLivraisonDTO = bonLivraisonService.loadBonLivraisonDTOById(id);
        if (bonLivraisonDTO != null) {
            return ResponseEntity.ok(bonLivraisonDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/codesap/{codeSapBL}")
    public ResponseEntity<BonLivraison> loadBonLivraisonByCodeSap(@PathVariable Long codeSapBL) {
        BonLivraison bonLivraison = bonLivraisonService.loadBonLivraisonByCodeSap(codeSapBL);
        if (bonLivraison != null) {
            return ResponseEntity.ok(bonLivraison);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }

//    @PostMapping("/saveBL")
//    public BonLivraison saveBonLivraison(@RequestBody BonLivraison bonLivraison) {
//        return bonLivraisonService.saveBonLivraison(bonLivraison);
//    }
//
//    @PutMapping("/{id}")
//    public BonLivraison updateBonLivraison(@PathVariable("id") Long id, @RequestBody BonLivraison bonLivraison) {
//        bonLivraison.setIdBL(id);
//        return bonLivraisonService.updateBonLivraison(bonLivraison);
//    }
//
//    @GetMapping("/{id}")
//    public BonLivraison getBonLivraisonById(@PathVariable("id") Long id) {
//        return bonLivraisonService.getBonLivraisonById(id);
//    }
//
//    @GetMapping
//    public List<BonLivraison> getAllBonLivraisons() {
//        return bonLivraisonService.getAllBonLivraison();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBonLivraisonById(@PathVariable("id") Long id) {
//        bonLivraisonService.deleteBonLivraisonById(id);
//    }
//    @GetMapping("/codeSapBL/{codeSapBL}")
//    public BonLivraison getBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL) {
//        return bonLivraisonService.getBonLivraisonByCodeSapBL(codeSapBL);
//
//    }
//
//    @GetMapping("/page")
//    public Page<BonLivraison> getAllBonLivraisonsByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return bonLivraisonService.getAllBonLivraisonByPage(page, size);
//    }
//
//    @PutMapping("/update/{codeSapBL}")
//    public BonLivraison updateBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL, @RequestBody BonLivraison updatedBonLivraison) {
//        return bonLivraisonService.updateBonLivraisonByCodeSapBL(codeSapBL, updatedBonLivraison);
//    }
//
//    @DeleteMapping("/delete/{codeSapBL}")
//    public void deleteBonLivraisonByCodeSapBL(@PathVariable Long codeSapBL) {
//        bonLivraisonService.deleteBonLivraisonByCodeSapBL(codeSapBL);
//    }

