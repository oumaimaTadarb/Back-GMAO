package org.gmaoback.gmaomondi_backend.gestionStock.services;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Usage;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.UsageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsageService {

    Usage addNewUsage(UsageDTO usageDto);
    Usage updateUsage(Long id, UsageDTO usageDto);
    Usage updateData(Usage usage, UsageDTO usageDto);
    void deleteUsage(Long id);
    List<UsageDTO> listUsagesDTO();
    List<Usage> listUsages();
    UsageDTO loadUsageById(Long id);

    UsageDTO convertToUsageDTO(Usage usage);



    //Usage saveUsage(Usage usage);
//    Usage updateUsage(Usage usage);
//    Usage getUsageById(Long idUsage);
//    List<Usage> getAllUsages();
//    void deleteUsageById(Long idUsage);
//    Page<Usage> getAllUsagesByPage(int page, int size);
}
