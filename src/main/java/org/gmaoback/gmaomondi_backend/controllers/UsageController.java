package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.Usage;
import org.gmaoback.gmaomondi_backend.dto.UsageDTO;
import org.gmaoback.gmaomondi_backend.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usages")
public class UsageController {

    @Autowired

    private UsageService usageService;


    @PostMapping
    public ResponseEntity<UsageDTO> addUsage(@RequestBody UsageDTO usageDto) {
        Usage usage = usageService.addNewUsage(usageDto);
        return ResponseEntity.ok(usageService.convertToUsageDTO(usage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsageDTO> updateUsage(@PathVariable Long id, @RequestBody UsageDTO usageDto) {
        Usage updatedUsage = usageService.updateUsage(id, usageDto);
        return ResponseEntity.ok(usageService.convertToUsageDTO(updatedUsage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsage(@PathVariable Long id) {
        usageService.deleteUsage(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UsageDTO>> getAllUsages() {
        List<UsageDTO> usageDtoList = usageService.listUsagesDTO();
        return ResponseEntity.ok(usageDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsageDTO> getUsageById(@PathVariable Long id) {
        UsageDTO usageDto = usageService.loadUsageById(id);
        return ResponseEntity.ok(usageDto);
    }

//    @GetMapping("/page")
//    public Page<Usage> getAllUsagesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return usageService.getAllUsagesByPage(page, size);
//    }
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
//

}
