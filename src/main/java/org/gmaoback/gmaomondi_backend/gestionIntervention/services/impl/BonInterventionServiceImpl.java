package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.BonIntervention;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.BonInterventionRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.InterventionRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.BonInterventionDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Classification;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Impact;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Priorite;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.TypeDAnomalie;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.BonInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BonInterventionServiceImpl implements BonInterventionService {

    @Autowired
    private BonInterventionRepository bonInterventionRepository;

    @Autowired
    private InterventionRepository interventionRepository;
    @Override
    public BonInterventionDTO createBonIntervention(BonInterventionDTO bonInterventionDTO) {
        BonIntervention bonIntervention = mapToEntity(bonInterventionDTO);
        bonIntervention = bonInterventionRepository.save(bonIntervention);
        return mapToDTO(bonIntervention);
    }

    @Override
    public BonInterventionDTO getBonInterventionById(Long id) {
        BonIntervention bonIntervention = bonInterventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BonIntervention not found with id: " + id));
        return mapToDTO(bonIntervention);
    }

    @Override
    public List<BonInterventionDTO> getAllBonInterventions() {
        return bonInterventionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BonInterventionDTO updateBonIntervention(Long id, BonInterventionDTO bonInterventionDTO) {
        BonIntervention existingBonIntervention = bonInterventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BonIntervention not found with id: " + id));

        existingBonIntervention.setDateDemande(bonInterventionDTO.getDateDemande());
        existingBonIntervention.setClassification(Classification.valueOf(bonInterventionDTO.getClassification()));
        existingBonIntervention.setDegreDimpact(Impact.valueOf(bonInterventionDTO.getDegreDimpact()));
        existingBonIntervention.setMotifIntervention(bonInterventionDTO.getMotifIntervention());
        existingBonIntervention.setDateReception(bonInterventionDTO.getDateReception());
        existingBonIntervention.setTypeDAnomalie(TypeDAnomalie.valueOf(bonInterventionDTO.getTypeDAnomalie()));
        existingBonIntervention.setDegrePriorite(Priorite.valueOf(bonInterventionDTO.getDegrePriorite()));
        existingBonIntervention.setCausesRacines(bonInterventionDTO.getCausesRacines());
        existingBonIntervention.setDateValidation(bonInterventionDTO.getDateValidation());
        existingBonIntervention.setHeureDebut(bonInterventionDTO.getHeureDebut());
        existingBonIntervention.setHeureFin(bonInterventionDTO.getHeureFin());
        existingBonIntervention.setIntervention(interventionRepository.findById(bonInterventionDTO.getInterventionId())
                .orElseThrow(() -> new ResourceNotFoundException("Intervention not found with id: " + bonInterventionDTO.getInterventionId())));

        BonIntervention updatedBonIntervention = bonInterventionRepository.save(existingBonIntervention);
        return mapToDTO(updatedBonIntervention);
    }

    @Override
    public void deleteBonIntervention(Long id) {
        BonIntervention bonIntervention = bonInterventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BonIntervention not found with id: " + id));
        bonInterventionRepository.delete(bonIntervention);
    }

    private BonInterventionDTO mapToDTO(BonIntervention bonIntervention) {
        BonInterventionDTO bonInterventionDTO = new BonInterventionDTO();
        bonInterventionDTO.setIdBonIntervention(bonIntervention.getIdBonIntervention());
        bonInterventionDTO.setDateDemande(bonIntervention.getDateDemande());
        bonInterventionDTO.setClassification(bonIntervention.getClassification().name());
        bonInterventionDTO.setDegreDimpact(bonIntervention.getDegreDimpact().name());
        bonInterventionDTO.setMotifIntervention(bonIntervention.getMotifIntervention());
        bonInterventionDTO.setDateReception(bonIntervention.getDateReception());
        bonInterventionDTO.setTypeDAnomalie(bonIntervention.getTypeDAnomalie().name());
        bonInterventionDTO.setDegrePriorite(bonIntervention.getDegrePriorite().name());
        bonInterventionDTO.setCausesRacines(bonIntervention.getCausesRacines());
        bonInterventionDTO.setDateValidation(bonIntervention.getDateValidation());
        bonInterventionDTO.setHeureDebut(bonIntervention.getHeureDebut());
        bonInterventionDTO.setHeureFin(bonIntervention.getHeureFin());
        bonInterventionDTO.setInterventionId(bonIntervention.getIntervention().getIdIntervention());
        return bonInterventionDTO;
    }

    private BonIntervention mapToEntity(BonInterventionDTO bonInterventionDTO) {
        BonIntervention bonIntervention = new BonIntervention();
        bonIntervention.setDateDemande(bonInterventionDTO.getDateDemande());
        bonIntervention.setClassification(Classification.valueOf(bonInterventionDTO.getClassification()));
        bonIntervention.setDegreDimpact(Impact.valueOf(bonInterventionDTO.getDegreDimpact()));
        bonIntervention.setMotifIntervention(bonInterventionDTO.getMotifIntervention());
        bonIntervention.setDateReception(bonInterventionDTO.getDateReception());
        bonIntervention.setTypeDAnomalie(TypeDAnomalie.valueOf(bonInterventionDTO.getTypeDAnomalie()));
        bonIntervention.setDegrePriorite(Priorite.valueOf(bonInterventionDTO.getDegrePriorite()));
        bonIntervention.setCausesRacines(bonInterventionDTO.getCausesRacines());
        bonIntervention.setDateValidation(bonInterventionDTO.getDateValidation());
        bonIntervention.setHeureDebut(bonInterventionDTO.getHeureDebut());
        bonIntervention.setHeureFin(bonInterventionDTO.getHeureFin());
        bonIntervention.setIntervention(interventionRepository.findById(bonInterventionDTO.getInterventionId())
                .orElseThrow(() -> new ResourceNotFoundException("Intervention not found with id: " + bonInterventionDTO.getInterventionId())));
        return bonIntervention;
    }
}