package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.models.Usage;
import org.gmaoback.gmaomondi_backend.dao.repositories.UsageRepository;
import org.gmaoback.gmaomondi_backend.services.UsageService;
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
        try {
            return usageRepository.save(usage);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de l'usage : " + e.getMessage());
        }
    }

    @Override
    public Usage updateUsage(Usage usage) {
        try {
            if (usageRepository.existsById(usage.getIdUsage())) {
                return usageRepository.save(usage);
            } else {
                throw new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + usage.getIdUsage());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de l'usage : " + e.getMessage());
        }
    }

    @Override
    public Usage getUsageById(Long idUsage) {
        try {
            return usageRepository.findById(idUsage)
                    .orElseThrow(() -> new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + idUsage));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de l'usage par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Usage> getAllUsages() {
        try {
            return usageRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les usages : " + e.getMessage());
        }
    }

    @Override
    public void deleteUsageById(Long idUsage) {
        try {
            usageRepository.deleteById(idUsage);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de l'usage par ID : " + e.getMessage());
        }
    }

    @Override
    public Page<Usage> getAllUsagesByPage(int page, int size) {
        try {
            return usageRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des usages par page : " + e.getMessage());
        }
    }
}
