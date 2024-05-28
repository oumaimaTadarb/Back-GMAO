package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.OrganeDTO;

import java.util.List;

public interface OrganeService {
    OrganeDTO createOrgane(OrganeDTO organeDTO);
    OrganeDTO getOrganeById(Long id);
    List<OrganeDTO> getAllOrganes();
    OrganeDTO updateOrgane(Long id, OrganeDTO organeDTO);
    void deleteOrgane(Long id);
}
