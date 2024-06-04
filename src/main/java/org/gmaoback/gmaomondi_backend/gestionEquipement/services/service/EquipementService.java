package org.gmaoback.gmaomondi_backend.gestionEquipement.services.service;


import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.EquipementDTO;

import java.util.List;

public interface EquipementService {
    Equipement createEquipement(Equipement equipement);
    Equipement updateEquipement(Long id, Equipement equipement);
    void deleteEquipement(Long id) throws Exception;
    Equipement getEquipementById(Long id);
    List<Equipement> getAllEquipements();
    EquipementDTO createEquipementDTO(EquipementDTO equipementDTO);
    EquipementDTO updateEquipementDTO(Long id, EquipementDTO equipementDTO);
    void deleteEquipementDTO(Long id) throws Exception;
    EquipementDTO getEquipementDTOById(Long id);
    List<EquipementDTO> getAllEquipementsDTO();

}
