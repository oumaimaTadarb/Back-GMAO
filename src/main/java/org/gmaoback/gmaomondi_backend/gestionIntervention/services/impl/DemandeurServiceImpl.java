package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Demandeur;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Intervention;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.DemandeurRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.DemandeurDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.DemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DemandeurServiceImpl implements DemandeurService {

    @Autowired
    private DemandeurRepository demandeurRepository;

    @Override
    public DemandeurDTO createDemandeur(DemandeurDTO demandeurDTO) {
        Demandeur demandeur = mapToEntity(demandeurDTO);
        demandeur = demandeurRepository.save(demandeur);
        return mapToDTO(demandeur);
    }

    @Override
    public DemandeurDTO getDemandeurById(Long id) {
        Demandeur demandeur = demandeurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demandeur not found with id: " + id));
        return mapToDTO(demandeur);
    }

    @Override
    public List<DemandeurDTO> getAllDemandeurs() {
        return demandeurRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeurDTO updateDemandeur(Long id, DemandeurDTO demandeurDTO) {
        Demandeur existingDemandeur = demandeurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demandeur not found with id: " + id));

        existingDemandeur.setNom(demandeurDTO.getNom());
        existingDemandeur.setSpecialite(demandeurDTO.getSpecialite());

        Demandeur updatedDemandeur = demandeurRepository.save(existingDemandeur);
        return mapToDTO(updatedDemandeur);
    }

    @Override
    public void deleteDemandeur(Long id) {
        Demandeur demandeur = demandeurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demandeur not found with id: " + id));
        demandeurRepository.delete(demandeur);
    }

    private DemandeurDTO mapToDTO(Demandeur demandeur) {
        DemandeurDTO demandeurDTO = new DemandeurDTO();
        demandeurDTO.setIdDemandeur(demandeur.getIdDemandeur());
        demandeurDTO.setNom(demandeur.getNom());
        demandeurDTO.setSpecialite(demandeur.getSpecialite());
        demandeurDTO.setInterventionIds(
                demandeur.getInterventions().stream()
                        .map(Intervention::getIdIntervention)
                        .collect(Collectors.toList())
        );
        return demandeurDTO;
    }

    private Demandeur mapToEntity(DemandeurDTO demandeurDTO) {
        Demandeur demandeur = new Demandeur();
        demandeur.setNom(demandeurDTO.getNom());
        demandeur.setSpecialite(demandeurDTO.getSpecialite());
        return demandeur;
    }
}