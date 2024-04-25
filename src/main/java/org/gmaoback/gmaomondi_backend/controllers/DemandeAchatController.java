package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.entites.DemandeAchat;
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
        demandeAchat.setIdDa(id); // Assurez-vous que l'id de la demande d'achat est défini
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

    @GetMapping("/page")
    public Page<DemandeAchat> getAllDemandeAchatByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return demandeAchatService.getAllDemandeAchatByPage(page, size);
    }
}
