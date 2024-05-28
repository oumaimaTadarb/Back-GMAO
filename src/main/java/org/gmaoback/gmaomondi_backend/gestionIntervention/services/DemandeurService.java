package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.DemandeurDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DemandeurService {
    DemandeurDTO createDemandeur(DemandeurDTO demandeurDTO);
    DemandeurDTO getDemandeurById(Long id);
    List<DemandeurDTO> getAllDemandeurs();
    DemandeurDTO updateDemandeur(Long id, DemandeurDTO demandeurDTO);
    void deleteDemandeur(Long id);
}
