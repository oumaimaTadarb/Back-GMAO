package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.LigneRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.LigneDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.LigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigneServiceImpl implements LigneService {

        @Autowired
        private LigneRepository ligneRepository;

        @Override
        public LigneDTO createLigne(LigneDTO ligneDTO) {
            Ligne ligne = mapToEntity(ligneDTO);
            ligne = ligneRepository.save(ligne);
            return mapToDTO(ligne);
        }

        @Override
        public LigneDTO getLigneById(Long id) {
            Ligne ligne = ligneRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Ligne not found with id: " + id));
            return mapToDTO(ligne);
        }

        @Override
        public List<LigneDTO> getAllLignes() {
            return ligneRepository.findAll().stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public LigneDTO updateLigne(Long id, LigneDTO ligneDTO) {
            Ligne existingLigne = ligneRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Ligne not found with id: " + id));

            existingLigne.setNom(ligneDTO.getNom());

            Ligne updatedLigne = ligneRepository.save(existingLigne);
            return mapToDTO(updatedLigne);
        }

        @Override
        public void deleteLigne(Long id) {
            Ligne ligne = ligneRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Ligne not found with id: " + id));
            ligneRepository.delete(ligne);
        }

        private LigneDTO mapToDTO(Ligne ligne) {
            LigneDTO ligneDTO = new LigneDTO();
            ligneDTO.setIdLigne(ligne.getIdLigne());
            ligneDTO.setNom(ligne.getNom());
            ligneDTO.setMachineIds(ligne.getMachines().stream().map(Machine::getIdMachine).collect(Collectors.toList()));
            return ligneDTO;
        }

        private Ligne mapToEntity(LigneDTO ligneDTO) {
            Ligne ligne = new Ligne();
            ligne.setNom(ligneDTO.getNom());
            return ligne;
        }
}
