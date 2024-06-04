package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.impl;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository.PrestataireRepository;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.mapper.PrestataireMapper;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.service.PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestataireServiceImpl implements PrestataireService {

    @Autowired
    private PrestataireRepository prestataireRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    // Méthodes utilisant des DTOs
    @Override
    public PrestataireDTO createPrestataire(PrestataireDTO prestataireDTO) {
        Prestataire prestataire = PrestataireMapper.INSTANCE.toEntity(prestataireDTO);
        setRelatedEntities(prestataire, prestataireDTO);
        Prestataire savedPrestataire = prestataireRepository.save(prestataire);
        return PrestataireMapper.INSTANCE.toDTO(savedPrestataire);
    }

    @Override
    public PrestataireDTO updatePrestataire(Long id, PrestataireDTO prestataireDTO) {
        Optional<Prestataire> existingPrestataire = prestataireRepository.findById(id);
        if (existingPrestataire.isPresent()) {
            Prestataire prestataire = existingPrestataire.get();
            prestataire.setNom(prestataireDTO.getNom());
            prestataire.setTel(prestataireDTO.getTel());
            prestataire.setEmail(prestataireDTO.getEmail());
            prestataire.setAdresse(prestataireDTO.getAdresse());
            prestataire.setEquipements(prestataireDTO.getEquipementIds().stream()
                    .map(equipementId -> equipementRepository.findById(equipementId).orElse(null))
                    .collect(Collectors.toList()));
            Prestataire updatedPrestataire = prestataireRepository.save(prestataire);
            return PrestataireMapper.INSTANCE.toDTO(updatedPrestataire);
        }
        return null; // ou lancez une exception
    }

    @Override
    public void deletePrestataire(Long id) throws Exception {
        Optional<Prestataire> prestataire = prestataireRepository.findById(id);
        if (prestataire.isPresent()) {
            prestataireRepository.deleteById(id);
        } else {
            throw new Exception("Prestataire not found");
        }
    }

    @Override
    public PrestataireDTO getPrestataireById(Long id) {
        return prestataireRepository.findById(id)
                .map(PrestataireMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<PrestataireDTO> getAllPrestataires() {
        return prestataireRepository.findAll().stream()
                .map(PrestataireMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    // Méthodes utilisant des entités
    @Override
    public Prestataire createPrestataire(Prestataire prestataire) {
        return prestataireRepository.save(prestataire);
    }

    @Override
    public Prestataire updatePrestataire(Long id, Prestataire prestataire) {
        Optional<Prestataire> existingPrestataire = prestataireRepository.findById(id);
        if (existingPrestataire.isPresent()) {
            Prestataire existing = existingPrestataire.get();
            existing.setNom(prestataire.getNom());
            existing.setTel(prestataire.getTel());
            existing.setEmail(prestataire.getEmail());
            existing.setAdresse(prestataire.getAdresse());
            existing.setEquipements(prestataire.getEquipements());
            return prestataireRepository.save(existing);
        }
        return null; // ou lancez une exception
    }

    @Override
    public void deletePrestataireEntity(Long id) throws Exception {
        Optional<Prestataire> prestataire = prestataireRepository.findById(id);
        if (prestataire.isPresent()) {
            prestataireRepository.deleteById(id);
        } else {
            throw new Exception("Prestataire not found");
        }
    }

    @Override
    public Prestataire getPrestataireByIdEntity(Long id) {
        return prestataireRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prestataire> getAllPrestatairesEntity() {
        return prestataireRepository.findAll();
    }

    private void setRelatedEntities(Prestataire prestataire, PrestataireDTO prestataireDTO) {
        if (prestataireDTO.getEquipementIds() != null) {
            List<Equipement> equipements = prestataireDTO.getEquipementIds().stream()
                    .map(id -> equipementRepository.findById(id).orElse(null))
                    .collect(Collectors.toList());
            prestataire.setEquipements(equipements);
        }
    }
}

