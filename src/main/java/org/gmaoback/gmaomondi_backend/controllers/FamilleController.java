package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.FamilleDTO;
import org.gmaoback.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Familles")
@CrossOrigin("*")
public class FamilleController {

    private final FamilleService familleService;

    @Autowired
    public FamilleController(FamilleService familleService) {
        this.familleService = familleService;
    }
    
    @GetMapping("/all-dto")
    public List<FamilleDTO> listFamillesDTO() {
        return familleService.listFamillesDTO();
    }


    @PostMapping("/add")
    public Famille addNewFamille(@RequestBody FamilleDTO familleDTO) {
        return familleService.addNewFamille(familleDTO);
    }


    @GetMapping("/{id}/familles-filles")
    public List<FamilleDTO> listSousFamillesDTO(@PathVariable Long id) {
        return familleService.listSousFamillesDTO(id);
    }


    // @PutMapping("/{id}/update")
    // public Famille updateFamille(@PathVariable Long id, @RequestBody Famille famille) {
    //     famille.setIdFamille(id);
    //     return familleService.updateFamille(famille);
    // }

    // @PutMapping("/{idFamille}/affect-mere/{idFamilleMere}")
    // public Famille affectFamilleMereToFamille(@PathVariable Long idFamille, @PathVariable Long idFamilleMere) {
    //     return familleService.affectFamilleMereToFamille(idFamille, idFamilleMere);
    // }

    // @PostMapping("/save")
    // public Famille saveFamille(@RequestBody Famille famille) {
    //     return familleService.saveFamille(famille);
    // }

    // @DeleteMapping("/{id}/delete")
    // public void deleteFamilleById(@PathVariable Long id) {
    //     familleService.deleteFamilleById(id);
    // }
    // @GetMapping("/{id}")
    // public FamilleDTO getFamilleById(@PathVariable Long id) {
    //     return familleService.loadFamilleDTOByID(id);
    // }


    // @PutMapping("/{id}/update-name")
    // public Famille updateFamilleName(@PathVariable Long id, @RequestParam String name) {
    //     return familleService.updateFamilleName(id, name);
    // }

    // @DeleteMapping("/{id}/delete")
    // public void deleteFamille(@PathVariable Long id) {
    //     familleService.deleteFamille(id);
    // }

    // @GetMapping("/{id}/articles")
    // public List<ArticleDTO> listArticlesDtoOfFamille(@PathVariable Long id) {
    //     return familleService.listArticlesDtoOfFamille(id);
    // }

    // @GetMapping("/all")
    // public List<Famille> listFamilles() {
    //     return familleService.listFamilles();
    // }

    // @GetMapping("/{id}/load")
    // public Famille loadFamilleById(@PathVariable Long id) {
    //     return familleService.loadFamilleById(id);
    // }

    // @GetMapping("/{id}/load-dto")
    // public FamilleDTO loadFamilleDTOById(@PathVariable Long id) {
    //     return familleService.loadFamilleDTOByID(id);
    // }

    // @GetMapping("/{id}/load-mere")
    // public Famille loadFamilleMereById(@PathVariable Long id) {
    //     return familleService.loadFamilleMereByIdFamille(id);
    // }

    // @GetMapping("/{id}/load-mere-dto")
    // public FamilleDTO loadFamilleMereDTOById(@PathVariable Long id) {
    //     return familleService.loadFamilleMereDTOByIdFamille(id);
    // }
    // @GetMapping("/{id}/sap-codes")
    // public List<Long> getAllSapCodesByFamilleId(@PathVariable Long id) {
    //     return familleService.getAllSapCodesByFamilleId(id);
    // }
}
//    @Autowired
//    public FamilleController(FamilleService familleService){
//        this.familleService = familleService;
//    }
//
//    @GetMapping("/")
//    public List<Famille> getAllFamilles(){
//        return this.familleService.listFamilles();
//    }
//
//    @GetMapping("/dto")
//    public List<FamilleDTO> listFamillesDTO() {
//        return this.familleService.listFamillesDTO();
//    }
//
//    @PutMapping("/{id}")
//    public Famille updateFamille(@PathVariable("id") Long id, @RequestBody Famille famille) {
//        famille.setIdFamille(id);
//        return familleService.updateFamille(famille);
//    }
//
//    @GetMapping("/{id}")
//    public Famille getFamilleById(@PathVariable("id") Long id) {
//        return familleService.getFamilleById(id);
//    }
//
//    @PostMapping("/save")
//    public Famille saveFamille(@RequestBody Famille famille) {
//        return familleService.saveFamille(famille);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteFamilleById(@PathVariable("id") Long idFamille) {
//        familleService.deleteFamilleById(idFamille);
//    }
//
//    @GetMapping("/{id}/articles")
//    public List<Article> getAllArticlesByFamilleId(@PathVariable("id") Long idFamille) {
//        return familleService.getAllArticlesByFamilleId(idFamille);
//    }
//
//    @GetMapping("/famillesdilles/{id}")
//    public List<Famille> getFamillesFillesById(@PathVariable("id") Long idFamille) {
//        return familleService.getFamillesFillesById(idFamille);
//    }
//    @GetMapping("/sap-codes/{id}")
//    public List<Long> getAllSapCodesByFamilleId(@PathVariable("id") Long idFamille) {
//        return familleService.getAllSapCodesByFamilleId(idFamille);
//    }

