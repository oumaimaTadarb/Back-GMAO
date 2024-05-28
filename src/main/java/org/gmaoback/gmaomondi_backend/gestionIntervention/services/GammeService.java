package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.springframework.stereotype.Service;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.GammeDTO;

import java.util.List;

public interface GammeService {
    GammeDTO createGamme(GammeDTO gammeDTO);
    GammeDTO getGammeById(Long id);
    List<GammeDTO> getAllGammes();
    GammeDTO updateGamme(Long id, GammeDTO gammeDTO);
    void deleteGamme(Long id);
}
