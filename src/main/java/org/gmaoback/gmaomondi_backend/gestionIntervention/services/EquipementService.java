package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.EquipementDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EquipementService {
    EquipementDTO createEquipement(EquipementDTO equipementDTO);
    EquipementDTO getEquipementById(Long id);
    List<EquipementDTO> getAllEquipements();
    EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO);
    void deleteEquipement(Long id);
}
