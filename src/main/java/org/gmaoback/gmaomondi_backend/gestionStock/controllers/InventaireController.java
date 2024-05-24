package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.InventaireDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventaires")
@CrossOrigin("*")
public class InventaireController {

    @Autowired
    private InventaireService inventaireService;

    @PostMapping("/add")
    public ResponseEntity<Inventaire> addNewInventaire(@RequestBody InventaireDTO inventaireDto) {
        Inventaire createdInventaire = inventaireService.addNewInventaire(inventaireDto);
        return ResponseEntity.ok(createdInventaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventaire> updateInventaire(@PathVariable Long id, @RequestBody InventaireDTO inventaireDTO) {
        Inventaire updatedInventaire = inventaireService.updateInventaire(id, inventaireDTO);
        return ResponseEntity.ok(updatedInventaire);
    }

    @PutMapping("/updateData/{id}")
    public ResponseEntity<Inventaire> updateData(@PathVariable Long id, @RequestBody InventaireDTO inventaireDto) {
        Inventaire existingInventaire = inventaireService.loadInventaireById(id);
        Inventaire updatedInventaire = inventaireService.updateData(existingInventaire, inventaireDto);
        return ResponseEntity.ok(updatedInventaire);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventaire(@PathVariable Long id) {
        inventaireService.deleteInventaire(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<InventaireDTO>> listInventairesDTO() {
        List<InventaireDTO> inventaires = inventaireService.listInventairesDTO();
        return ResponseEntity.ok(inventaires);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Inventaire>> findAll(Pageable pageable) {
        Page<Inventaire> page = inventaireService.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventaire> loadInventaireById(@PathVariable Long id) {
        Inventaire inventaire = inventaireService.loadInventaireById(id);
        return ResponseEntity.ok(inventaire);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<InventaireDTO> loadInventaireByInventaireId(@PathVariable Long id) {
        InventaireDTO inventaireDto = inventaireService.loadInventaireByInventaireId(id);
        return ResponseEntity.ok(inventaireDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Inventaire>> listInventaires() {
        List<Inventaire> inventaires = inventaireService.listInventaires();
        return ResponseEntity.ok(inventaires);
    }
}
//    @PostMapping("/add")
//    public ResponseEntity<InventaireDTO> addNewInventaire(@RequestBody InventaireDTO inventaireDto) {
//        Inventaire inventaire = inventaireService.addNewInventaire(inventaireDto);
//        return new ResponseEntity<>(convertToInventaireDTO(inventaire), HttpStatus.CREATED);
//    }
//    @GetMapping("/listpage")
//    public ResponseEntity<Page<Inventaire>> listInventaires(Pageable pageable) {
//        Page<Inventaire> page = inventaireService.listInventaires(pageable);
//        return ResponseEntity.ok(page);
//    }
//
//    public InventaireDTO convertToInventaireDTO(Inventaire inventaire) {
//        if (inventaire == null) {
//            return null;
//        }
//        InventaireDTO inventaireDto = new InventaireDTO();
//        inventaireDto.setIdInventaire(inventaire.getIdInventaire());
//        inventaireDto.setQuantiteReel(inventaire.getQuantiteReel());
//        inventaireDto.setDateInventaire(LocalDateTime.from(LocalDate.from(inventaire.getDateInventaire())));
//        inventaireDto.setJustification(inventaire.getJustification());
//        if (inventaire.getPersonne() != null) {
//            inventaireDto.setIdPersonne(inventaire.getPersonne().getIdPersonne());
//            inventaireDto.setIdInventaire(inventaire.getPersonne().getIdPersonne());
//        }
//        if (inventaire.getArticle() != null) {
//            inventaireDto.setIdArticle(inventaire.getArticle().getIdArticle());
//            inventaireDto.setIdArticle(inventaire.getArticle().getIdArticle());
//        }
//
//        return inventaireDto;
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<InventaireDTO> updateInventaire(@PathVariable Long id, @RequestBody InventaireDTO inventaireDTO) {
//        Inventaire inventaire = inventaireService.updateInventaire(id, inventaireDTO);
//        return new ResponseEntity<>(convertToInventaireDTO(inventaire), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteInventaire(@PathVariable Long id) {
//        inventaireService.deleteInventaire(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<InventaireDTO>> listInventairesDTO() {
//        List<InventaireDTO> inventaireDTOList = inventaireService.listInventairesDTO();
//        return new ResponseEntity<>(inventaireDTOList, HttpStatus.OK);
//    }
//
//    @GetMapping("/loadById/{id}")
//    public ResponseEntity<Inventaire> loadInventaireById(@PathVariable Long id) {
//        Inventaire inventaire = inventaireService.loadInventaireById(id);
//        return new ResponseEntity<>(inventaire, HttpStatus.OK);
//    }
//
//    @GetMapping("/loadByInventaireId/{id}")
//    public ResponseEntity<InventaireDTO> loadInventaireByInventaireId(@PathVariable Long id) {
//        InventaireDTO inventaireDTO = inventaireService.loadInventaireByInventaireId(id);
//        return new ResponseEntity<>(inventaireDTO, HttpStatus.OK);
//    }}
//  //  @GetMapping("/page")
////    public Page<Inventaire> getAllInventairesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
////        return inventaireService.getAllInventairesByPage(page, size);
////    }
////
////    @PostMapping("/saveInventaire")
////    public Inventaire saveInventaire(@RequestBody Inventaire inventaire) {
////        return inventaireService.saveInventaire(inventaire);
////    }
////
////    @PutMapping("/{id}")
////    public Inventaire updateInventaire(@PathVariable("id") Long id, @RequestBody Inventaire inventaire) {
////        inventaire.setIdInventaire(id); // Assurez-vous que l'ID de l'inventaire est défini
////        return inventaireService.updateInventaire(inventaire);
////    }
////
////    @GetMapping("/{id}")
////    public Inventaire getInventaireById(@PathVariable("id") Long id) {
////        return inventaireService.getInventaireById(id);
////    }
////
////    @DeleteMapping("/{id}")
////    public void deleteInventaireById(@PathVariable("id") Long id) {
////        inventaireService.deleteInventaireById(id);
////    }
////
////    @GetMapping
////    public List<Inventaire> getAllInventaires() {
////        return inventaireService.getAllInventaires();
////    }
////


