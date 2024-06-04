package org.gmaoback.gmaomondi_backend.gestionEquipement.services.impl;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.EquipementRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.MachineRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.enums.Etat;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.EquipementDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.EquipementMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.EquipementService;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository.FournisseurRepository;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository.PrestataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Equipement createEquipement(Equipement equipement) {
            return equipementRepository.save(equipement);
        }
        @Override
        public Equipement updateEquipement(Long id, Equipement updatedEquipement) {
            Optional<Equipement> existingEquipement = equipementRepository.findById(id);
            if (existingEquipement.isPresent()) {
                Equipement equipement = existingEquipement.get();
                equipement.setZone(updatedEquipement.getZone());
                equipement.setDesignation(updatedEquipement.getDesignation());
                equipement.setDescriptionTechnique(updatedEquipement.getDescriptionTechnique());
                equipement.setFournisseur(updatedEquipement.getFournisseur());
                equipement.setEtat(updatedEquipement.getEtat());
                equipement.setPrestataire(updatedEquipement.getPrestataire());
                equipement.setMachine(updatedEquipement.getMachine());
                equipement.setOrganes(updatedEquipement.getOrganes());
                return equipementRepository.save(equipement);
            }
            return null;
        }

        @Override
        public void deleteEquipement(Long id) throws Exception {
            Optional<Equipement> equipement = equipementRepository.findById(id);
            if (equipement.isPresent()) {
                if (equipement.get().getOrganes() != null && !equipement.get().getOrganes().isEmpty()) {
                    throw new Exception("Cannot delete an Equipement that contains Organes");
                } else {
                    equipementRepository.deleteById(id);
                }
            } else {
                throw new Exception("Equipement not found");
            }
        }

        @Override
        public Equipement getEquipementById(Long id) {
            return equipementRepository.findById(id).orElse(null);
        }

        @Override
        public List<Equipement> getAllEquipements() {
            return equipementRepository.findAll();
        }
//
    @Override
    public EquipementDTO createEquipementDTO(EquipementDTO equipementDTO) {
    Equipement equipement = EquipementMapper.INSTANCE.toEntity(equipementDTO);
    setRelatedEntities(equipement, equipementDTO);
    Equipement savedEquipement = equipementRepository.save(equipement);
    return EquipementMapper.INSTANCE.toDTO(savedEquipement);
}

    @Override
    public EquipementDTO updateEquipementDTO(Long id, EquipementDTO equipementDTO) {
        Optional<Equipement> existingEquipement = equipementRepository.findById(id);
        if (existingEquipement.isPresent()) {
            Equipement equipement = existingEquipement.get();
            equipement.setZone(equipementDTO.getZone());
            equipement.setDesignation(equipementDTO.getDesignation());
            equipement.setDescriptionTechnique(equipementDTO.getDescriptionTechnique());
            equipement.setEtat(Etat.valueOf(equipementDTO.getEtat()));
            setRelatedEntities(equipement, equipementDTO);
            Equipement updatedEquipement = equipementRepository.save(equipement);
            return EquipementMapper.INSTANCE.toDTO(updatedEquipement);
        }
        return null; // ou lancez une exception
    }

    @Override
    public void deleteEquipementDTO(Long id) throws Exception {
        Optional<Equipement> equipement = equipementRepository.findById(id);
        if (equipement.isPresent()) {
            if (equipement.get().getOrganes() != null && !equipement.get().getOrganes().isEmpty()) {
                throw new Exception("Cannot delete an Equipement that contains Organes");
            } else {
                equipementRepository.deleteById(id);
            }
        } else {
            throw new Exception("Equipement not found");
        }
    }

    @Override
    public EquipementDTO getEquipementDTOById(Long id) {
        return equipementRepository.findById(id)
                .map(EquipementMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<EquipementDTO> getAllEquipementsDTO() {
        return equipementRepository.findAll().stream()
                .map(EquipementMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    private void setRelatedEntities(Equipement equipement, EquipementDTO equipementDTO) {
        if (equipementDTO.getFournisseurId() != null) {
            Optional<Fournisseur> fournisseur = fournisseurRepository.findById(equipementDTO.getFournisseurId());
            fournisseur.ifPresent(equipement::setFournisseur);
        }

        if (equipementDTO.getPrestataireId() != null) {
            Optional<Prestataire> prestataire = prestataireRepository.findById(equipementDTO.getPrestataireId());
            prestataire.ifPresent(equipement::setPrestataire);
        }

        if (equipementDTO.getMachineId() != null) {
            Optional<Machine> machine = machineRepository.findById(equipementDTO.getMachineId());
            machine.ifPresent(equipement::setMachine);
        }
    }
}
