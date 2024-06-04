package org.gmaoback.gmaomondi_backend.gestionEquipement.services.impl;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.LigneRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.MachineRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.LigneDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.LigneMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.MachineMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.LigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.MachineMapper.*;

@Service
public class LigneServiceImpl implements LigneService {

    @Autowired
    private LigneRepository ligneRepository;
    @Autowired
    private MachineRepository machineRepository;

    @Override
    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }

    @Override
    public Ligne updateLigne(Long id, Ligne updatedLigne) {
        Optional<Ligne> existingLigne = ligneRepository.findById(id);
        if (existingLigne.isPresent()) {
            Ligne ligne = existingLigne.get();
            ligne.setNom(updatedLigne.getNom());
            ligne.setMachines(updatedLigne.getMachines());
            return ligneRepository.save(ligne);
        }
        return null;
    }

    @Override
    public void deleteLigne(Long id) throws Exception {
        Optional<Ligne> ligne = ligneRepository.findById(id);
        if (ligne.isPresent()) {
            if (ligne.get().getMachines() != null && !ligne.get().getMachines().isEmpty()) {
                throw new Exception("Cannot delete a Ligne that contains Machines");
            } else {
                ligneRepository.deleteById(id);
            }
        } else {
            throw new Exception("Ligne not found");
        }
    }

    @Override
    public Ligne getLigneById(Long id) {
        return ligneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    @Override
    public LigneDTO createLigneDTO(LigneDTO ligneDTO) {
        Ligne ligne = LigneMapper.INSTANCE.toEntity(ligneDTO);
        return LigneMapper.INSTANCE.toDTO(ligneRepository.save(ligne));
    }

    @Override
    public LigneDTO updateLigneDTO(Long id, LigneDTO ligneDTO) {
        Optional<Ligne> existingLigne = ligneRepository.findById(id);
        if (existingLigne.isPresent()) {
            Ligne ligne = existingLigne.get();
            ligne.setNom(ligneDTO.getNom());
            ligne.setMachines(ligneDTO.getMachineIds().stream()
                    .map(machineId -> machineRepository.findById(machineId).orElse(null))
                    .collect(Collectors.toList()));
            Ligne updatedLigne = ligneRepository.save(ligne);
            return LigneMapper.INSTANCE.toDTO(updatedLigne);
        }
        return null;
    }
    @Override
    public void deleteLigneDTO(Long id) throws Exception {
        Optional<Ligne> ligne = ligneRepository.findById(id);
        if (ligne.isPresent()) {
            if (ligne.get().getMachines() != null && !ligne.get().getMachines().isEmpty()) {
                throw new Exception("Cannot delete a Ligne that contains Machines");
            } else {
                ligneRepository.deleteById(id);
            }
        } else {
            throw new Exception("Ligne not found");
        }
    }

    @Override
    public LigneDTO getLigneDTOById(Long id) {
        return ligneRepository.findById(id)
                .map(LigneMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<LigneDTO> getAllLignesDTO() {
        return ligneRepository.findAll().stream()
                .map(LigneMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}