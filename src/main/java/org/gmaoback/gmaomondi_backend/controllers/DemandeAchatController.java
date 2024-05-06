package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entites.DemandeAchat;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.DemandeAchat;
import org.gmaoback.gmaomondi_backend.services.DemandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandesAchat")
public class DemandeAchatController {

    @Autowired
    private DemandeAchatService demandeAchatService;
    @PostMapping("/saveDA")
    public DemandeAchat saveDemandeAchat(@RequestBody DemandeAchat demandeAchat) {
        return demandeAchatService.saveDemandeAchat(demandeAchat);
    }

    @PutMapping("/{id}")
    public DemandeAchat updateDemandeAchat(@PathVariable("id") Long id, @RequestBody DemandeAchat demandeAchat) {
        demandeAchat.setIdDa(id);
        return demandeAchatService.updateDemandeAchat(demandeAchat);
    }

    @GetMapping("/{id}")
    public DemandeAchat getDemandeAchatById(@PathVariable("id") Long id) {
        return demandeAchatService.getDemandeAchatById(id);
    }

    @GetMapping
    public List<DemandeAchat> getAllDemandeAchat() {
        return demandeAchatService.getAllDemandeAchat();
    }
    @PutMapping("/update/{codeSapDA}")
    public DemandeAchat updateDemandeAchatByCodeSapAr(@PathVariable Long codeSapDA, @RequestBody DemandeAchat updatedDemandeAchat) {
        return demandeAchatService.updateDemandeAchatByCodeSapDA(codeSapDA, updatedDemandeAchat);
    }

    @DeleteMapping("/delete/{codeSapDA}")
    public void deleteDemandeAchatByCodeSapAr(@PathVariable Long codeSapDA) {
        demandeAchatService.deleteDemandeAchatByCodeSapDA(codeSapDA);
    }
    @GetMapping("/page")
    public Page<DemandeAchat> getAllDemandeAchatByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return demandeAchatService.getAllDemandeAchatByPage(page, size);
    }
    @GetMapping("/codeSapDA/{codeSapDA}")
    public DemandeAchat getDemandeAchatByCodeSapDA(@PathVariable Long codeSapDA) {
        return demandeAchatService.getDemandeAchatBycodeSapDA(codeSapDA);
    }

    @GetMapping("/devis/{codeSapDA}")
    public DemandeAchat getDevisByCodeSapDA(@PathVariable Long codeSapDA) {
        return demandeAchatService.findDevisByCodeSapDA(codeSapDA);
    }


}
