package org.gmaoback.gmaomondi_backend.gestionEquipement.services.service;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.LigneDTO;

import java.util.List;

public interface LigneService {
    Ligne createLigne(Ligne ligne);
    Ligne updateLigne(Long id, Ligne ligne);
    void deleteLigne(Long id) throws Exception;
    Ligne getLigneById(Long id);
    List<Ligne> getAllLignes();

    LigneDTO createLigneDTO(LigneDTO ligneDTO);
   // LigneDTO updateLigneDTO(Long id, LigneDTO ligneDTO);
    void deleteLigneDTO(Long id) throws Exception;
    LigneDTO getLigneDTOById(Long id);
    List<LigneDTO> getAllLignesDTO();
}