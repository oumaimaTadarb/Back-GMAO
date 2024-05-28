package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.OrganeRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.PrestataireRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.OrganeDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.OrganeService;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganeServiceImpl implements OrganeService {

    @Autowired
    private OrganeRepository organeRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    @Autowired
    private PrestataireRepository prestataireRepository;

    @Override
    public OrganeDTO createOrgane(OrganeDTO organeDTO) {
        Organe organe = mapToEntity(organeDTO);
        organe = organeRepository.save(organe);
        return mapToDTO(organe);
    }

    @Override
    public OrganeDTO getOrganeById(Long id) {
        Organe organe = organeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organe not found with id: " + id));
        return mapToDTO(organe);
    }

    @Override
    public List<OrganeDTO> getAllOrganes() {
        return organeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrganeDTO updateOrgane(Long id, OrganeDTO organeDTO) {
        Organe existingOrgane = organeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organe not found with id: " + id));
        existingOrgane.setDesignation(organeDTO.getDesignation());
        existingOrgane.setDescriptionTechnique(organeDTO.getDescriptionTechnique());
        existingOrgane.setFournisseur(fournisseurRepository.findById(organeDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + organeDTO.getFournisseurId())));
        existingOrgane.setEquipement(equipementRepository.findById(organeDTO.getEquipementId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + organeDTO.getEquipementId())));
        existingOrgane.setPrestataire(prestataireRepository.findById(organeDTO.getPrestataireId())
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + organeDTO.getPrestataireId())));
        Organe updatedOrgane = organeRepository.save(existingOrgane);
        return mapToDTO(updatedOrgane);
    }

    @Override
    public void deleteOrgane(Long id) {
        Organe organe = organeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organe not found with id: " + id));
        organeRepository.delete(organe);
    }

    private OrganeDTO mapToDTO(Organe organe) {
        OrganeDTO organeDTO = new OrganeDTO();
        organeDTO.setIdOrgane(organe.getIdOrgane());
        organeDTO.setDesignation(organe.getDesignation());
        organeDTO.setDescriptionTechnique(organe.getDescriptionTechnique());
        organeDTO.setFournisseurId(organe.getFournisseur().getIdFournisseur());
        organeDTO.setEquipementId(organe.getEquipement().getIdEquipement());
        organeDTO.setPrestataireId(organe.getPrestataire().getIdPrestataire());
        return organeDTO;
    }

    private Organe mapToEntity(OrganeDTO organeDTO) {
        Organe organe = new Organe();
        organe.setDesignation(organeDTO.getDesignation());
        organe.setDescriptionTechnique(organeDTO.getDescriptionTechnique());
        organe.setFournisseur(fournisseurRepository.findById(organeDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found")));
        organe.setEquipement(equipementRepository.findById(organeDTO.getEquipementId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found")));
        organe.setPrestataire(prestataireRepository.findById(organeDTO.getPrestataireId())
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found")));
        return organe;
    }
}