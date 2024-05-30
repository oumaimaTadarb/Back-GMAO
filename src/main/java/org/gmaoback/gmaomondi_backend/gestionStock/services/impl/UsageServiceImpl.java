package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Usage;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.UsageRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.UsageDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.UsageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsageServiceImpl implements UsageService {

    private final UsageRepository usageRepository;
    public UsageServiceImpl(UsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }

    @Override
    public Usage addNewUsage(UsageDTO usageDto) {
        Usage usage = new Usage();
        usage.setNomUsage(usageDto.getNomUsage());
        return usageRepository.save(usage);
    }

    @Override
    public Usage updateUsage(Long id, UsageDTO usageDto) {
        Usage existingUsage = usageRepository.findById(id).orElseThrow(() -> new RuntimeException("Usage not found"));
        existingUsage.setNomUsage(usageDto.getNomUsage());
        return usageRepository.save(existingUsage);
    }

    @Override
    public Usage updateData(Usage usage, UsageDTO usageDto) {
        if (usage != null && usageDto != null) {
            usage.setNomUsage(usageDto.getNomUsage());
            return usageRepository.save(usage);
        } else {
            throw new IllegalArgumentException("Usage and UsageDTO must not be null");
        }
    }

    @Override
    public void deleteUsage(Long id) {
        usageRepository.deleteById(id);
    }

    @Override
    public List<UsageDTO> listUsagesDTO() {
        return usageRepository.findAll().stream().map(this::convertToUsageDTO).collect(Collectors.toList());
    }

    @Override
    public List<Usage> listUsages() {
        return usageRepository.findAll();
    }

    @Override
    public UsageDTO loadUsageById(Long id) {
        Usage usage = usageRepository.findById(id).orElseThrow(() -> new RuntimeException("Usage not found"));
        return convertToUsageDTO(usage);
    }

    @Override
    public UsageDTO convertToUsageDTO(Usage usage) {
        UsageDTO usageDto = new UsageDTO();
        usageDto.setIdUsage(usage.getIdUsage());
        usageDto.setNomUsage(usage.getNomUsage());
        return usageDto;
    }



//    @Override
//    public Usage saveUsage(Usage usage) {
//        try {
//            return usageRepository.save(usage);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement de l'usage : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Usage updateUsage(Usage usage) {
//        try {
//            if (usageRepository.existsById(usage.getIdUsage())) {
//                return usageRepository.save(usage);
//            } else {
//                throw new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + usage.getIdUsage());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de l'usage : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Usage getUsageById(Long idUsage) {
//        try {
//            return usageRepository.findById(idUsage)
//                    .orElseThrow(() -> new IllegalArgumentException("Usage non trouvé avec l'identifiant : " + idUsage));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de l'usage par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Usage> getAllUsages() {
//        try {
//            return usageRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les usages : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteUsageById(Long idUsage) {
//        try {
//            usageRepository.deleteById(idUsage);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression de l'usage par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Page<Usage> getAllUsagesByPage(int page, int size) {
//        try {
//            return usageRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des usages par page : " + e.getMessage());
//        }
//    }

}
