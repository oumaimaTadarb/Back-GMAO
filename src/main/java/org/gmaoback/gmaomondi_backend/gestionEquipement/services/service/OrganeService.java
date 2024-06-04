package org.gmaoback.gmaomondi_backend.gestionEquipement.services.service;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.OrganeDTO;

import java.util.List;

public interface OrganeService {
    Organe createOrgane(Organe organe);
    Organe updateOrgane(Long id, Organe organe);
    void deleteOrgane(Long id) throws Exception;
    Organe getOrganeById(Long id);
    List<Organe> getAllOrganes();
    OrganeDTO createOrganeDTO(OrganeDTO organeDTO);
    OrganeDTO updateOrganeDTO(Long id, OrganeDTO organeDTO);
    void deleteOrganeDTO(Long id) throws Exception;
    OrganeDTO getOrganeDTOById(Long id);
    List<OrganeDTO> getAllOrganesDTO();
}
