package org.gmaoback.gmaomondi_backend.gestionFournisseur.controllers;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.services.dto.FournisseurDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.services.service.FournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
@CrossOrigin("*")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping("/add")
    public ResponseEntity<FournisseurDTO> addNewFournisseur(@RequestBody FournisseurDTO fournisseurDto) {
        Fournisseur fournisseur = fournisseurService.addNewFournisseur(fournisseurDto);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseurService.convertToFournisseurDTO(fournisseur), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<FournisseurDTO> updateFournisseur(@PathVariable Long id, @RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurService.updateFournisseur(id, fournisseurDTO);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseurService.convertToFournisseurDTO(fournisseur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FournisseurDTO>> listFournisseursDTO() {
        List<FournisseurDTO> fournisseursDTO = fournisseurService.listFournisseursDTO();
        return new ResponseEntity<>(fournisseursDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Fournisseur>> listFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.listFournisseurs();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Fournisseur> loadFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.loadFournisseurById(id);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byFournisseurId/{id}")
    public ResponseEntity<FournisseurDTO> loadFournisseurByFournisseurId(@PathVariable Long id) {
        FournisseurDTO fournisseur = fournisseurService.loadFournisseurByFournisseurId(id);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byCodeSapFr/{codeSapFr}")
    public ResponseEntity<Fournisseur> loadFournisseurBycodeSapFr(@PathVariable Long codeSapFr) {
        Fournisseur fournisseur = fournisseurService.loadFournisseurBycodeSapFr(codeSapFr);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

