package org.gmaoback.gmaomondi_backend.gestionIntervention.services;


import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.LigneDTO;

import java.util.List;

public interface LigneService {
    LigneDTO createLigne(LigneDTO ligneDTO);
    LigneDTO getLigneById(Long id);
    List<LigneDTO> getAllLignes();
    LigneDTO updateLigne(Long id, LigneDTO ligneDTO);
    void deleteLigne(Long id);
}
