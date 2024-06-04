package org.gmaoback.gmaomondi_backend.gestionEquipement.services.service;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;

import java.util.List;

public interface OrganeService {
    Organe createOrgane(Organe organe);
    Organe updateOrgane(Long id, Organe organe);
    void deleteOrgane(Long id) throws Exception;
    Organe getOrganeById(Long id);
    List<Organe> getAllOrganes();
}
