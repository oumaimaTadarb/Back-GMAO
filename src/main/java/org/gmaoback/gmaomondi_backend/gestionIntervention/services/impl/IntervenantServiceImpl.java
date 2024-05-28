package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Intervenant;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Intervention;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.IntervenantRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.IntervenantDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntervenantServiceImpl implements IntervenantService {

    @Autowired
    private IntervenantRepository intervenantRepository;

    @Override
    public IntervenantDTO createIntervenant(IntervenantDTO intervenantDTO) {
        Intervenant intervenant = mapToEntity(intervenantDTO);
        intervenant = intervenantRepository.save(intervenant);
        return mapToDTO(intervenant);
    }

    @Override
    public IntervenantDTO getIntervenantById(Long id) {
        Intervenant intervenant = intervenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervenant not found with id: " + id));
        return mapToDTO(intervenant);
    }

    @Override
    public List<IntervenantDTO> getAllIntervenants() {
        return intervenantRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IntervenantDTO updateIntervenant(Long id, IntervenantDTO intervenantDTO) {
        Intervenant existingIntervenant = intervenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervenant not found with id: " + id));

        existingIntervenant.setNom(intervenantDTO.getNom());
        existingIntervenant.setSpecialite(intervenantDTO.getSpecialite());

        Intervenant updatedIntervenant = intervenantRepository.save(existingIntervenant);
        return mapToDTO(updatedIntervenant);
    }

    @Override
    public void deleteIntervenant(Long id) {
        Intervenant intervenant = intervenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intervenant not found with id: " + id));
        intervenantRepository.delete(intervenant);
    }

    private IntervenantDTO mapToDTO(Intervenant intervenant) {
        IntervenantDTO intervenantDTO = new IntervenantDTO();
        intervenantDTO.setIdIntervenant(intervenant.getIdIntervenant());
        intervenantDTO.setNom(intervenant.getNom());
        intervenantDTO.setSpecialite(intervenant.getSpecialite());
        intervenantDTO.setInterventionIds(intervenant.getInterventions().stream()
                .map(Intervention::getIdIntervention)
                .collect(Collectors.toList()));
        return intervenantDTO;
    }

    private Intervenant mapToEntity(IntervenantDTO intervenantDTO) {
        Intervenant intervenant = new Intervenant();
        intervenant.setNom(intervenantDTO.getNom());
        intervenant.setSpecialite(intervenantDTO.getSpecialite());
        return intervenant;
    }
}
