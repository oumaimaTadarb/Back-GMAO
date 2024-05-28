package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.BonInterventionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BonInterventionService {
    BonInterventionDTO createBonIntervention(BonInterventionDTO bonInterventionDTO);
    BonInterventionDTO getBonInterventionById(Long id);
    List<BonInterventionDTO> getAllBonInterventions();
    BonInterventionDTO updateBonIntervention(Long id, BonInterventionDTO bonInterventionDTO);
    void deleteBonIntervention(Long id);
}
