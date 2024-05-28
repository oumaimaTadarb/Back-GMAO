package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.IntervenantDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IntervenantService {
    IntervenantDTO createIntervenant(IntervenantDTO intervenantDTO);
    IntervenantDTO getIntervenantById(Long id);
    List<IntervenantDTO> getAllIntervenants();
    IntervenantDTO updateIntervenant(Long id, IntervenantDTO intervenantDTO);
    void deleteIntervenant(Long id);
}
