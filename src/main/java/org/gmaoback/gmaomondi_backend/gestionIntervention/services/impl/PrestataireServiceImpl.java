package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.PrestataireRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.PrestataireDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestataireServiceImpl implements PrestataireService {

    @Autowired
    private PrestataireRepository prestataireRepository;

    @Override
    public PrestataireDTO createPrestataire(PrestataireDTO prestataireDTO) {
        Prestataire prestataire = mapToEntity(prestataireDTO);
        prestataire = prestataireRepository.save(prestataire);
        return mapToDTO(prestataire);
    }

    @Override
    public PrestataireDTO getPrestataireById(Long id) {
        Prestataire prestataire = prestataireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + id));
        return mapToDTO(prestataire);
    }

    @Override
    public List<PrestataireDTO> getAllPrestataires() {
        return prestataireRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PrestataireDTO updatePrestataire(Long id, PrestataireDTO prestataireDTO) {
        Prestataire existingPrestataire = prestataireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + id));

        existingPrestataire.setNom(prestataireDTO.getNom());
        existingPrestataire.setTel(prestataireDTO.getTel());
        existingPrestataire.setEmail(prestataireDTO.getEmail());
        existingPrestataire.setAdresse(prestataireDTO.getAdresse());
        Prestataire updatedPrestataire = prestataireRepository.save(existingPrestataire);
        return mapToDTO(updatedPrestataire);
    }

    @Override
    public void deletePrestataire(Long id) {
        Prestataire prestataire = prestataireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestataire not found with id: " + id));
        prestataireRepository.delete(prestataire);
    }

    private PrestataireDTO mapToDTO(Prestataire prestataire) {
        PrestataireDTO prestataireDTO = new PrestataireDTO();
        prestataireDTO.setIdPrestataire(prestataire.getIdPrestataire());
        prestataireDTO.setNom(prestataire.getNom());
        prestataireDTO.setTel(prestataire.getTel());
        prestataireDTO.setEmail(prestataire.getEmail());
        prestataireDTO.setAdresse(prestataire.getAdresse());
        return prestataireDTO;
    }

    private Prestataire mapToEntity(PrestataireDTO prestataireDTO) {
        Prestataire prestataire = new Prestataire();
        prestataire.setNom(prestataireDTO.getNom());
        prestataire.setTel(prestataireDTO.getTel());
        prestataire.setEmail(prestataireDTO.getEmail());
        prestataire.setAdresse(prestataireDTO.getAdresse());
        return prestataire;
    }
}
