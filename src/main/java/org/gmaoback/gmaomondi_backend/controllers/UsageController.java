package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entites.Usage;
import org.gmaoback.gmaomondi_backend.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usages")
public class UsageController {

    @Autowired
    private UsageService usageService;

//    @PostMapping("/saveUsage")
//    public Usage saveUsage(@RequestBody Usage usage) {
//        return usageService.saveUsage(usage);
//    }
//
//    @PutMapping("/{id}")
//    public Usage updateUsage(@PathVariable("id") Long id, @RequestBody Usage usage) {
//        usage.setIdUsage(id); // Assurez-vous que l'ID de l'usage est défini
//        return usageService.updateUsage(usage);
//    }
//
//    @GetMapping("/{id}")
//    public Usage getUsageById(@PathVariable("id") Long id) {
//        return usageService.getUsageById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUsageById(@PathVariable("id") Long id) {
//        usageService.deleteUsageById(id);
//    }
//
//    @GetMapping
//    public List<Usage> getAllUsages() {
//        return usageService.getAllUsages();
//    }

    @GetMapping("/page")
    public Page<Usage> getAllUsagesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return usageService.getAllUsagesByPage(page, size);
    }
}
