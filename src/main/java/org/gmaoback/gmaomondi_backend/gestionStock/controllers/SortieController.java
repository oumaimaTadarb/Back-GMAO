package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.SortieDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sorties")
@CrossOrigin("*")
public class SortieController {

    @Autowired
    private SortieService sortieService;

    @PostMapping("/add")
    public ResponseEntity<SortieDTO> addNewSortie(@RequestBody SortieDTO sortieDto) {
        Sortie nouvelleSortie = sortieService.addNewSortie(sortieDto);
        if (nouvelleSortie != null) {
            return new ResponseEntity<>(sortieService.convertToSortieDTO(nouvelleSortie), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/sortie/{id}")
    public ResponseEntity<SortieDTO> updateSortie(@PathVariable Long id, @RequestBody SortieDTO sortieDTO) {
        Sortie updatedSortie = sortieService.updateSortie(id, sortieDTO);
        if (updatedSortie != null) {
            return new ResponseEntity<>(sortieService.convertToSortieDTO(updatedSortie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/etat/{etat}")
    public List<Sortie> getSortiesByEtat(@PathVariable EtatSortie etat) {
        return sortieService.getSortiesByEtat(etat);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSortie(@PathVariable Long id) {
        sortieService.deleteSortie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/list")
    public ResponseEntity<List<SortieDTO>> listSortiesDTO() {
        List<Sortie> sorties = sortieService.listSorties();
        List<SortieDTO> sortieDTOList = sorties.stream()
                .map(sortieService::convertToSortieDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortieDTOList, HttpStatus.OK);
    }

    @GetMapping("/load/{id}")
    public ResponseEntity<Sortie> loadSortieById(@PathVariable Long id) {
        Sortie sortie = sortieService.loadSortieById(id);
        if (sortie != null) {
            return new ResponseEntity<>(sortie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sortie> updateDataSortie(@PathVariable Long id, @RequestBody SortieDTO sortieDto) {
        Sortie sortieToUpdate = sortieService.loadSortieById(id);
        if (sortieToUpdate != null) {
            Sortie updatedSortie = sortieService.updateDataSortie(sortieToUpdate, sortieDto);
            return new ResponseEntity<>(updatedSortie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<SortieDTO> loadSortieBySortieId(@PathVariable Long id) {
//        SortieDTO sortieDTO = sortieService.loadSortieBySortieId(id);
//        if (sortieDTO != null) {
//            return new ResponseEntity<>(sortieDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
//    @GetMapping("/page")
//    public Page<Sortie> getAllSortiesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return sortieService.getAllSortiesByPage(page, size);
//    }
//
//    @PostMapping("/saveSortie")
//    public Sortie saveSortie(@RequestBody Sortie sortie) {
//        return sortieService.saveSortie(sortie);
//    }
//
//    @PutMapping("/{id}")
//    public Sortie updateSortie(@PathVariable("id") Long id, @RequestBody Sortie sortie) {
//        sortie.setIdSortie(id); // Assurez-vous que l'ID de la sortie est défini
//        return sortieService.updateSortie(sortie);
//    }
//
//    @GetMapping("/{id}")
//    public Sortie getSortieById(@PathVariable("id") Long id) {
//        return sortieService.getSortieById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteSortieById(@PathVariable("id") Long id) {
//        sortieService.deleteSortieById(id);
//    }
//
//    @GetMapping
//    public List<Sortie> getAllSorties() {
//        return sortieService.getAllSorties();
//    }
//


