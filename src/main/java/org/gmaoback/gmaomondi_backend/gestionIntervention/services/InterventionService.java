package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.InterventionDTO;

import java.util.List;

public interface InterventionService {
    InterventionDTO createIntervention(InterventionDTO interventionDTO);
    InterventionDTO getInterventionById(Long id);
    List<InterventionDTO> getAllInterventions();
    InterventionDTO updateIntervention(Long id, InterventionDTO interventionDTO);
    void deleteIntervention(Long id);
}
