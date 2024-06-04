package org.gmaoback.gmaomondi_backend.gestionEquipement.services.impl;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.OrganeRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.OrganeDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.OrganeMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.OrganeService;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository.FournisseurRepository;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository.PrestataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganeServiceImpl implements OrganeService {

    @Autowired
    private OrganeRepository organeRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private PrestataireRepository prestataireRepository;

    @Autowired
    private EquipementRepository equipementRepository;

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

    //



    @Override
    public OrganeDTO createOrganeDTO(OrganeDTO organeDTO) {
        Organe organe = OrganeMapper.INSTANCE.toEntity(organeDTO);
        setRelatedEntities(organe, organeDTO);
        Organe savedOrgane = organeRepository.save(organe);
        return OrganeMapper.INSTANCE.toDTO(savedOrgane);
    }

    @Override
    public OrganeDTO updateOrganeDTO(Long id, OrganeDTO organeDTO) {
        Optional<Organe> existingOrgane = organeRepository.findById(id);
        if (existingOrgane.isPresent()) {
            Organe organe = existingOrgane.get();
            organe.setDesignation(organeDTO.getDesignation());
            organe.setDescriptionTechnique(organeDTO.getDescriptionTechnique());
            setRelatedEntities(organe, organeDTO);
            Organe updatedOrgane = organeRepository.save(organe);
            return OrganeMapper.INSTANCE.toDTO(updatedOrgane);
        }
        return null;
    }

    @Override
    public void deleteOrganeDTO(Long id) throws Exception {
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
    public OrganeDTO getOrganeDTOById(Long id) {
        return organeRepository.findById(id)
                .map(OrganeMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<OrganeDTO> getAllOrganesDTO() {
        return organeRepository.findAll().stream()
                .map(OrganeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    private void setRelatedEntities(Organe organe, OrganeDTO organeDTO) {
        if (organeDTO.getFournisseurId() != null) {
            Optional<Fournisseur> fournisseur = fournisseurRepository.findById(organeDTO.getFournisseurId());
            fournisseur.ifPresent(organe::setFournisseur);
        }

        if (organeDTO.getPrestataireId() != null) {
            Optional<Prestataire> prestataire = prestataireRepository.findById(organeDTO.getPrestataireId());
            prestataire.ifPresent(organe::setPrestataire);
        }

        if (organeDTO.getEquipementId() != null) {
            Optional<Equipement> equipement = equipementRepository.findById(organeDTO.getEquipementId());
            equipement.ifPresent(organe::setEquipement);
        }
    }
}
