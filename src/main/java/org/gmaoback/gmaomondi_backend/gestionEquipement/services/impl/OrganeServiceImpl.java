package org.gmaoback.gmaomondi_backend.gestionEquipement.services.impl;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.OrganeRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.OrganeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganeServiceImpl implements OrganeService {

    @Autowired
    private OrganeRepository organeRepository;

    @Override
    public Organe createOrgane(Organe organe) {
        return organeRepository.save(organe);
    }

    @Override
    public Organe updateOrgane(Long id, Organe updatedOrgane) {
        Optional<Organe> existingOrgane = organeRepository.findById(id);
        if (existingOrgane.isPresent()) {
            Organe organe = existingOrgane.get();
            organe.setDesignation(updatedOrgane.getDesignation());
            organe.setDescriptionTechnique(updatedOrgane.getDescriptionTechnique());
            organe.setFournisseur(updatedOrgane.getFournisseur());
            organe.setEquipement(updatedOrgane.getEquipement());
            organe.setPrestataire(updatedOrgane.getPrestataire());
            organe.setArticles(updatedOrgane.getArticles());
            return organeRepository.save(organe);
        }
        return null; // ou lancez une exception
    }

    @Override
    public void deleteOrgane(Long id) throws Exception {
        Optional<Organe> organe = organeRepository.findById(id);
        if (organe.isPresent()) {
            if (organe.get().getArticles() != null && !organe.get().getArticles().isEmpty()) {
                throw new Exception("Cannot delete an Organe that contains Articles");
            } else {
                organeRepository.deleteById(id);
            }
        } else {
            throw new Exception("Organe not found");
        }
    }

    @Override
    public Organe getOrganeById(Long id) {
        return organeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Organe> getAllOrganes() {
        return organeRepository.findAll();
    }
}
