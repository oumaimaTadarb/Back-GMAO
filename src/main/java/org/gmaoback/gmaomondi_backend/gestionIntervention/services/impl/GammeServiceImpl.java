package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Gamme;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.GammeRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.OrganeRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.GammeDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Frequence;
import org.gmaoback.gmaomondi_backend.gestionIntervention.enums.Nature;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.GammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GammeServiceImpl implements GammeService {

    @Autowired
    private GammeRepository gammeRepository;

    @Autowired
    private OrganeRepository organeRepository;

    @Override
    public GammeDTO createGamme(GammeDTO gammeDTO) {
        Gamme gamme = mapToEntity(gammeDTO);
        gamme = gammeRepository.save(gamme);
        return mapToDTO(gamme);
    }

    @Override
    public GammeDTO getGammeById(Long id) {
        Gamme gamme = gammeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gamme not found with id: " + id));
        return mapToDTO(gamme);
    }

    @Override
    public List<GammeDTO> getAllGammes() {
        return gammeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GammeDTO updateGamme(Long id, GammeDTO gammeDTO) {
        Gamme existingGamme = gammeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gamme not found with id: " + id));

        existingGamme.setRefGamme(gammeDTO.getRefGamme());
        existingGamme.setNature(Nature.valueOf(gammeDTO.getNature()));
        existingGamme.setFrequence(Frequence.valueOf(gammeDTO.getFrequence()));
        existingGamme.setOrgane(organeRepository.findById(gammeDTO.getOrganeId())
                .orElseThrow(() -> new ResourceNotFoundException("Organe not found with id: " + gammeDTO.getOrganeId())));

        Gamme updatedGamme = gammeRepository.save(existingGamme);
        return mapToDTO(updatedGamme);
    }

    @Override
    public void deleteGamme(Long id) {
        Gamme gamme = gammeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gamme not found with id: " + id));
        gammeRepository.delete(gamme);
    }

    private GammeDTO mapToDTO(Gamme gamme) {
        GammeDTO gammeDTO = new GammeDTO();
        gammeDTO.setIdGamme(gamme.getIdGamme());
        gammeDTO.setRefGamme(gamme.getRefGamme());
        gammeDTO.setNature(gamme.getNature().name());
        gammeDTO.setFrequence(gamme.getFrequence().name());
        gammeDTO.setOrganeId(gamme.getOrgane().getIdOrgane());
        return gammeDTO;
    }

    private Gamme mapToEntity(GammeDTO gammeDTO) {
        Gamme gamme = new Gamme();
        gamme.setRefGamme(gammeDTO.getRefGamme());
        gamme.setNature(Nature.valueOf(gammeDTO.getNature()));
        gamme.setFrequence(Frequence.valueOf(gammeDTO.getFrequence()));
        gamme.setOrgane(organeRepository.findById(gammeDTO.getOrganeId())
                .orElseThrow(() -> new ResourceNotFoundException("Organe not found with id: " + gammeDTO.getOrganeId())));
        return gamme;
    }
}