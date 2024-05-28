package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Intervention;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.MachineRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.PrestataireRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.EquipementDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Etat;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.EquipementService;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipementServiceImpl implements EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private PrestataireRepository prestataireRepository;

    @Autowired
    private MachineRepository machineRepository;

    @Override
    public EquipementDTO createEquipement(EquipementDTO equipementDTO) {
        Equipement equipement = mapToEntity(equipementDTO);
        equipement = equipementRepository.save(equipement);
        return mapToDTO(equipement);
    }

    @Override
    public EquipementDTO getEquipementById(Long id) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + id));
        return mapToDTO(equipement);
    }

    @Override
    public List<EquipementDTO> getAllEquipements() {
        return equipementRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO) {
        Equipement existingEquipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + id));

        existingEquipement.setZone(equipementDTO.getZone());
        existingEquipement.setDesignation(equipementDTO.getDesignation());
        existingEquipement.setDescriptionTechnique(equipementDTO.getDescriptionTechnique());
        existingEquipement.setFournisseur(fournisseurRepository.findById(equipementDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + equipementDTO.getFournisseurId())));
        existingEquipement.setEtat(Etat.valueOf(equipementDTO.getEtat()));
        existingEquipement.setPrestataire(prestataireRepository.findById(equipementDTO.getPrestataireId())
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + equipementDTO.getPrestataireId())));
        existingEquipement.setMachine(machineRepository.findById(equipementDTO.getMachineId())
                .orElseThrow(() -> new ResourceNotFoundException("Machine not found with id: " + equipementDTO.getMachineId())));

        Equipement updatedEquipement = equipementRepository.save(existingEquipement);
        return mapToDTO(updatedEquipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + id));
        equipementRepository.delete(equipement);
    }

    private EquipementDTO mapToDTO(Equipement equipement) {
        EquipementDTO equipementDTO = new EquipementDTO();
        equipementDTO.setIdEquipement(equipement.getIdEquipement());
        equipementDTO.setZone(equipement.getZone());
        equipementDTO.setDesignation(equipement.getDesignation());
        equipementDTO.setDescriptionTechnique(equipement.getDescriptionTechnique());
        equipementDTO.setFournisseurId(equipement.getFournisseur().getIdFournisseur());
        equipementDTO.setEtat(equipement.getEtat().name());
        equipementDTO.setPrestataireId(equipement.getPrestataire().getIdPrestataire());
        equipementDTO.setMachineId(equipement.getMachine().getIdMachine());
        equipementDTO.setOrganeIds(equipement.getOrganes().stream().map(Organe::getIdOrgane).collect(Collectors.toList()));
        equipementDTO.setInterventionIds(equipement.getInterventions().stream().map(Intervention::getIdIntervention).collect(Collectors.toList()));
        return equipementDTO;
    }

    private Equipement mapToEntity(EquipementDTO equipementDTO) {
        Equipement equipement = new Equipement();
        equipement.setZone(equipementDTO.getZone());
        equipement.setDesignation(equipementDTO.getDesignation());
        equipement.setDescriptionTechnique(equipementDTO.getDescriptionTechnique());
        equipement.setFournisseur(fournisseurRepository.findById(equipementDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + equipementDTO.getFournisseurId())));
        equipement.setEtat(Etat.valueOf(equipementDTO.getEtat()));
        equipement.setPrestataire(prestataireRepository.findById(equipementDTO.getPrestataireId())
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + equipementDTO.getPrestataireId())));
        equipement.setMachine(machineRepository.findById(equipementDTO.getMachineId())
                .orElseThrow(() -> new ResourceNotFoundException("Machine not found with id: " + equipementDTO.getMachineId())));
        return equipement;
    }
}
