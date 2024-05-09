package org.gmaoback.gmaomondi_backend.services;
import org.gmaoback.gmaomondi_backend.dao.entities.Usage;
import org.gmaoback.gmaomondi_backend.dto.UsageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
