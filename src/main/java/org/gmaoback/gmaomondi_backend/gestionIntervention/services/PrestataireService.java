package org.gmaoback.gmaomondi_backend.gestionIntervention.services;


import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.PrestataireDTO;

import java.util.List;

public interface PrestataireService {
    PrestataireDTO createPrestataire(PrestataireDTO prestataireDTO);
    PrestataireDTO getPrestataireById(Long id);
    List<PrestataireDTO> getAllPrestataires();
    PrestataireDTO updatePrestataire(Long id, PrestataireDTO prestataireDTO);
    void deletePrestataire(Long id);
}
