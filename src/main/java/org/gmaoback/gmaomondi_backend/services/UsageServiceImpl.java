package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Usage;
import org.gmaoback.gmaomondi_backend.dao.repositories.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageServiceImpl implements UsageService {
    @Autowired
    UsageRepository usageRepository;
    @Override
    public Usage saveUsage(Usage usage) {
        return usageRepository.save(usage);
    }

    @Override
    public Usage updateUsage(Usage usage) {
        if (usageRepository.existsById(usage.getIdUsage())) {
            return usageRepository.save(usage);
        } else {
            throw new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + usage.getIdUsage());
        }
    }

    @Override
    public Usage getUsageById(Long idUsage) {
        return usageRepository.findById(idUsage)
                .orElseThrow(() -> new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + idUsage));
    }

    @Override
    public List<Usage> getAllUsages() {
        return usageRepository.findAll();
    }

    @Override
    public void deleteUsageById(Long idUsage) {
        usageRepository.deleteById(idUsage);
    }

    @Override
    public Page<Usage> getAllUsagesByPage(int page, int size) {
        return usageRepository.findAll(PageRequest.of(page, size));
    }
}