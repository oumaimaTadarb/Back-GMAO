package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.BonCommandeDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.BonCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonCommandes")
@CrossOrigin("*")
public class BonCommandeController {
    private final BonCommandeService bonCommandeService;

    @Autowired
    public BonCommandeController(BonCommandeService bonCommandeService) {
        this.bonCommandeService = bonCommandeService;
    }

    @PostMapping("/add")
    public BonCommande addNewBonCommande(@RequestBody BonCommandeDTO bonCommandeDto) {
        return bonCommandeService.addNewBonCommande(bonCommandeDto);
    }

    @PutMapping("/update/{id}")
    public BonCommande updateBonCommande(@PathVariable Long id, @RequestBody BonCommandeDTO bonCommandeDTO) {
        return bonCommandeService.updateBonCommande(id, bonCommandeDTO);
    }

    @GetMapping("/list")
    public List<BonCommande> listBonCommandes() {
        return bonCommandeService.listBonCommandes();
    }

    @GetMapping("/{id}")
    public BonCommande loadBonCommandeById(@PathVariable Long id) {
        return bonCommandeService.loadBonCommandeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBonCommande(@PathVariable Long id) {
        bonCommandeService.deleteBonCommande(id);
    }

    @GetMapping("/listDTO")
    public List<BonCommandeDTO> listBonCommandesDTO() {
        return bonCommandeService.listBonCommandesDTO();
    }

    @GetMapping("/loadDTO/{id}")
    public BonCommandeDTO loadBonCommandeByBonCommandeId(@PathVariable Long id) {
        return bonCommandeService.loadBonCommandeByBonCommandeId(id);
    }
    @PostMapping("/updateData")
    public BonCommande updateBonCommandeData(@RequestBody BonCommande bonCommande, @RequestBody BonCommandeDTO bonCommandeDto) {
        return bonCommandeService.updateData(bonCommande, bonCommandeDto);
    }

    @GetMapping("/loadByCodeSap/{codeSapBC}")
    public BonCommande loadBonCommandeByCodeSap(@PathVariable Long codeSapBC) {
        return bonCommandeService.loadBonCommandeByCodeSap(codeSapBC);
    }
}

//    @PostMapping("/saveBC")
//    public BonCommande saveBonCommande(@RequestBody BonCommande bonCommande) {
//        return bonCommandeService.saveBonCommande(bonCommande);
//    }
//    @PutMapping("/{id}")
//    public BonCommande updateBonCommande(@PathVariable("id") Long id, @RequestBody BonCommande bonCommande) {
//        bonCommande.setIdBC(id);
//        return bonCommandeService.updateBonCommande(bonCommande);
//    }
//    @GetMapping("/{id}")
//    public BonCommande getBonCommandeById(@PathVariable("id") Long id) {
//        return bonCommandeService.getBonCommandeById(id);
//    }
//    @GetMapping
//    public List<BonCommande> getAllBonCommandes() {
//        return bonCommandeService.getAllBonCommandes();
//    }
//    @DeleteMapping("/{id}")
//    public void deleteBonCommandeById(@PathVariable("id") Long id) {
//        bonCommandeService.deleteBonCommandeById(id);
//    }
//    @GetMapping("/codeSapBC/{codeSapBC}")
//    public BonCommande getBonCommandeByCodeSapBC(@PathVariable Long codeSapBC) {
//        return bonCommandeService.getBonCommandeByCodeSapBC(codeSapBC);
//    }
//
//    @GetMapping("/page")
//    public Page<BonCommande> getAllBonCommandesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return bonCommandeService.getAllBonCommandesByPage(page, size);
//    }
//
//    @PutMapping("/update/{codeSapBC}")
//    public BonCommande updateBonCommandeByCodeSapBC(@PathVariable Long codeSapBC, @RequestBody BonCommande updatedBonCommande) {
//        return bonCommandeService.updateBonCommandeByCodeSapBC(codeSapBC, updatedBonCommande);
//    }
//
//    @DeleteMapping("/delete/{codeSapBC}")
//    public void deleteBonCommandeByCodeSapBC(@PathVariable Long codeSapBC) {
//        bonCommandeService.deleteBonCommandeByCodeSapBC(codeSapBC);
//    }



