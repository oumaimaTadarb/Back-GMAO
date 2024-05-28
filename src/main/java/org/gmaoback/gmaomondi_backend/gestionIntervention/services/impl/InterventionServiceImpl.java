package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Intervention;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.DemandeurRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.IntervenantRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.InterventionRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.InterventionDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Classification;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Impact;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Priorite;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.TypeDAnomalie;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterventionServiceImpl implements InterventionService {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    @Autowired
    private IntervenantRepository intervenantRepository;

    @Autowired
    private DemandeurRepository demandeurRepository;

    @Override
    public InterventionDTO createIntervention(InterventionDTO interventionDTO) {
        Intervention intervention = mapToEntity(interventionDTO);
        intervention = interventionRepository.save(intervention);
        return mapToDTO(intervention);
    }

    @Override
    public InterventionDTO getInterventionById(Long id) {
        Intervention intervention = interventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervention not found with id: " + id));
        return mapToDTO(intervention);
    }

    @Override
    public List<InterventionDTO> getAllInterventions() {
        return interventionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InterventionDTO updateIntervention(Long id, InterventionDTO interventionDTO) {
        Intervention existingIntervention = interventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervention not found with id: " + id));

        existingIntervention.setDateDemande(interventionDTO.getDateDemande());
        existingIntervention.setClassification(Classification.valueOf(interventionDTO.getClassification()));
        existingIntervention.setDegreDimpact(Impact.valueOf(interventionDTO.getDegreDimpact()));
        existingIntervention.setMotifIntervention(interventionDTO.getMotifIntervention());
        existingIntervention.setDateReception(interventionDTO.getDateReception());
        existingIntervention.setTypeDAnomalie(TypeDAnomalie.valueOf(interventionDTO.getTypeDAnomalie()));
        existingIntervention.setDegrePriorite(Priorite.valueOf(interventionDTO.getDegrePriorite()));
        existingIntervention.setCausesRacines(interventionDTO.getCausesRacines());
        existingIntervention.setDateValidation(interventionDTO.getDateValidation());
        existingIntervention.setHeureDebut(interventionDTO.getHeureDebut());
        existingIntervention.setHeureFin(interventionDTO.getHeureFin());
        existingIntervention.setEquipement(equipementRepository.findById(interventionDTO.getEquipementId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + interventionDTO.getEquipementId())));
        existingIntervention.setIntervenant(intervenantRepository.findById(interventionDTO.getIntervenantId())
                .orElseThrow(() -> new ResourceNotFoundException("Intervenant not found with id: " + interventionDTO.getIntervenantId())));
        existingIntervention.setDemandeur(demandeurRepository.findById(interventionDTO.getDemandeurId())
                .orElseThrow(() -> new ResourceNotFoundException("Demandeur not found with id: " + interventionDTO.getDemandeurId())));

        Intervention updatedIntervention = interventionRepository.save(existingIntervention);
        return mapToDTO(updatedIntervention);
    }

    @Override
    public void deleteIntervention(Long id) {
        Intervention intervention = interventionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervention not found with id: " + id));
        interventionRepository.delete(intervention);
    }

    private InterventionDTO mapToDTO(Intervention intervention) {
        InterventionDTO interventionDTO = new InterventionDTO();
        interventionDTO.setIdIntervention(intervention.getIdIntervention());
        interventionDTO.setDateDemande(intervention.getDateDemande());
        interventionDTO.setClassification(intervention.getClassification().name());
        interventionDTO.setDegreDimpact(intervention.getDegreDimpact().name());
        interventionDTO.setMotifIntervention(intervention.getMotifIntervention());
        interventionDTO.setDateReception(intervention.getDateReception());
        interventionDTO.setTypeDAnomalie(intervention.getTypeDAnomalie().name());
        interventionDTO.setDegrePriorite(intervention.getDegrePriorite().name());
        interventionDTO.setCausesRacines(intervention.getCausesRacines());
        interventionDTO.setDateValidation(intervention.getDateValidation());
        interventionDTO.setHeureDebut(intervention.getHeureDebut());
        interventionDTO.setHeureFin(intervention.getHeureFin());
        interventionDTO.setEquipementId(intervention.getEquipement().getIdEquipement());
        interventionDTO.setIntervenantId(intervention.getIntervenant().getIdIntervenant());
        interventionDTO.setDemandeurId(intervention.getDemandeur().getIdDemandeur());
        return interventionDTO;
    }

    private Intervention mapToEntity(InterventionDTO interventionDTO) {
        Intervention intervention = new Intervention();
        intervention.setDateDemande(interventionDTO.getDateDemande());
        intervention.setClassification(Classification.valueOf(interventionDTO.getClassification()));
        intervention.setDegreDimpact(Impact.valueOf(interventionDTO.getDegreDimpact()));
        intervention.setMotifIntervention(interventionDTO.getMotifIntervention());
        intervention.setDateReception(interventionDTO.getDateReception());
        intervention.setTypeDAnomalie(TypeDAnomalie.valueOf(interventionDTO.getTypeDAnomalie()));
        intervention.setDegrePriorite(Priorite.valueOf(interventionDTO.getDegrePriorite()));
        intervention.setCausesRacines(interventionDTO.getCausesRacines());
        intervention.setDateValidation(interventionDTO.getDateValidation());
        intervention.setHeureDebut(interventionDTO.getHeureDebut());
        intervention.setHeureFin(interventionDTO.getHeureFin());
        intervention.setEquipement(equipementRepository.findById(interventionDTO.getEquipementId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipement not found with id: " + interventionDTO.getEquipementId())));
        intervention.setIntervenant(intervenantRepository.findById(interventionDTO.getIntervenantId())
                .orElseThrow(() -> new ResourceNotFoundException("Intervenant not found with id: " + interventionDTO.getIntervenantId())));
        intervention.setDemandeur(demandeurRepository.findById(interventionDTO.getDemandeurId())
                .orElseThrow(() -> new ResourceNotFoundException("Demandeur not found with id: " + interventionDTO.getDemandeurId())));
        return intervention;
    }
}
