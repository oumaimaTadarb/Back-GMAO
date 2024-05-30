package org.gmaoback.gmaomondi_backend.gestionStock.controllers;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.DemandeAchatDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.DemandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandesAchat")
@CrossOrigin("*")
public class DemandeAchatController {

    @Autowired
    private DemandeAchatService demandeAchatService;

    @PostMapping("/add")
    public ResponseEntity<DemandeAchat> addNewDemandeAchat(@RequestBody DemandeAchatDTO demandeAchatDto) {
        DemandeAchat demandeAchat = demandeAchatService.addNewDemandeAchat(demandeAchatDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeAchat);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DemandeAchat> updateDemandeAchat(@PathVariable Long id, @RequestBody DemandeAchatDTO demandeAchatDto) {
        DemandeAchat demandeAchat = demandeAchatService.updateDemandeAchat(id, demandeAchatDto);
        if (demandeAchat != null) {
            return ResponseEntity.ok(demandeAchat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDemandeAchat(@PathVariable Long id) {
        demandeAchatService.deleteDemandeAchat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<DemandeAchatDTO>> listDemandeAchatsDTO() {
        List<DemandeAchatDTO> demandeAchatsDTO = demandeAchatService.listDemandeAchatsDTO();
        return ResponseEntity.ok(demandeAchatsDTO);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<DemandeAchat>> listAllDemandeAchats() {
        List<DemandeAchat> demandeAchats = demandeAchatService.listDemandeAchats();
        return ResponseEntity.ok(demandeAchats);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<DemandeAchatDTO> loadDemandeAchatByDemandeAchatId(@PathVariable Long id) {
        DemandeAchatDTO demandeAchatDTO = demandeAchatService.loadDemandeAchatByDemandeAchatId(id);
        if (demandeAchatDTO != null) {
            return ResponseEntity.ok(demandeAchatDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update-by-code-sap/{codeSapBC}")
    public ResponseEntity<DemandeAchat> updateDemandeAchatByCodeSapDA(@PathVariable Long codeSapBC, @RequestBody DemandeAchatDTO demandeAchatDto) {
        DemandeAchat demandeAchat = demandeAchatService.updateDemandeAchatByCodeSapDA(codeSapBC, demandeAchatDto);
        if (demandeAchat != null) {
            return ResponseEntity.ok(demandeAchat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/by-code-sap/{codeSapBC}")
    public ResponseEntity<DemandeAchat> loadDemandeAchatByCodeSap(@PathVariable Long codeSapBC) {
        DemandeAchat demandeAchat = demandeAchatService.loadDemandeAchatByCodeSap(codeSapBC);
        if (demandeAchat != null) {
            return ResponseEntity.ok(demandeAchat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/devis/{codeSapDA}")
//    public DemandeAchat getDevisByCodeSapDA(@PathVariable Long codeSapDA) {
//        return demandeAchatService.findDevisByCodeSapDA(codeSapDA);
//    }

}
//    @PostMapping("/saveDA")
//    public DemandeAchat saveDemandeAchat(@RequestBody DemandeAchat demandeAchat) {
//        return demandeAchatService.saveDemandeAchat(demandeAchat);
//    }
//
//    @PutMapping("/{id}")
//    public DemandeAchat updateDemandeAchat(@PathVariable("id") Long id, @RequestBody DemandeAchat demandeAchat) {
//        demandeAchat.setIdDA(id);
//        return demandeAchatService.updateDemandeAchat(demandeAchat);
//    }
//
//    @GetMapping("/{id}")
//    public DemandeAchat getDemandeAchatById(@PathVariable("id") Long id) {
//        return demandeAchatService.getDemandeAchatById(id);
//    }
//
//    @GetMapping
//    public List<DemandeAchat> getAllDemandeAchat() {
//        return demandeAchatService.getAllDemandeAchat();
//    }
//    @PutMapping("/update/{codeSapDA}")
//    public DemandeAchat updateDemandeAchatByCodeSapAr(@PathVariable Long codeSapDA, @RequestBody DemandeAchat updatedDemandeAchat) {
//        return demandeAchatService.updateDemandeAchatByCodeSapDA(codeSapDA, updatedDemandeAchat);
//    }
//
//    @DeleteMapping("/delete/{codeSapDA}")
//    public void deleteDemandeAchatByCodeSapAr(@PathVariable Long codeSapDA) {
//        demandeAchatService.deleteDemandeAchatByCodeSapDA(codeSapDA);
//    }
//    @GetMapping("/page")
//    public Page<DemandeAchat> getAllDemandeAchatByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return demandeAchatService.getAllDemandeAchatByPage(page, size);
//    }
//    @GetMapping("/codeSapDA/{codeSapDA}")
//    public DemandeAchat getDemandeAchatByCodeSapDA(@PathVariable Long codeSapDA) {
//        return demandeAchatService.getDemandeAchatBycodeSapDA(codeSapDA);
//    }
//
//    @GetMapping("/devis/{codeSapDA}")
//    public DemandeAchat getDevisByCodeSapDA(@PathVariable Long codeSapDA) {
//        return demandeAchatService.findDevisByCodeSapDA(codeSapDA);
//    }
//


