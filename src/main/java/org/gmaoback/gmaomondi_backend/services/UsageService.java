package org.gmaoback.gmaomondi_backend.services;
import org.gmaoback.gmaomondi_backend.dao.entities.Usage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsageService {
    Usage saveUsage(Usage usage);
    Usage updateUsage(Usage usage);
    Usage getUsageById(Long idUsage);
    List<Usage> getAllUsages();
    void deleteUsageById(Long idUsage);
    Page<Usage> getAllUsagesByPage(int page, int size);
}
