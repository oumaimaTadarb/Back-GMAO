package org.gmaoback.gmaomondi_backend.gestionIntervention.services.impl;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.LigneRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories.MachineRepository;
import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.MachineDTO;
import org.gmaoback.gmaomondi_backend.gestionIntervention.services.MachineService;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private LigneRepository ligneRepository;

    @Override
    public MachineDTO createMachine(MachineDTO machineDTO) {
        Machine machine = mapToEntity(machineDTO);
        machine = machineRepository.save(machine);
        return mapToDTO(machine);
    }

    @Override
    public MachineDTO getMachineById(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Machine not found with id: " + id));
        return mapToDTO(machine);
    }

    @Override
    public List<MachineDTO> getAllMachines() {
        return machineRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MachineDTO updateMachine(Long id, MachineDTO machineDTO) {
        Machine existingMachine = machineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Machine not found with id: " + id));

        existingMachine.setDesignation(machineDTO.getDesignation());
        existingMachine.setDateMiseEnService(machineDTO.getDateMiseEnService());
        existingMachine.setDescriptionTechnique(machineDTO.getDescriptionTechnique());
        existingMachine.setFournisseur(fournisseurRepository.findById(machineDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + machineDTO.getFournisseurId())));
        existingMachine.setLigne(ligneRepository.findById(machineDTO.getLigneId())
                .orElseThrow(() -> new ResourceNotFoundException("Ligne not found with id: " + machineDTO.getLigneId())));

        Machine updatedMachine = machineRepository.save(existingMachine);
        return mapToDTO(updatedMachine);
    }

    @Override
    public void deleteMachine(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Machine not found with id: " + id));
        machineRepository.delete(machine);
    }

    private MachineDTO mapToDTO(Machine machine) {
        MachineDTO machineDTO = new MachineDTO();
        machineDTO.setIdMachine(machine.getIdMachine());
        machineDTO.setDesignation(machine.getDesignation());
        machineDTO.setDateMiseEnService(machine.getDateMiseEnService());
        machineDTO.setDescriptionTechnique(machine.getDescriptionTechnique());
        machineDTO.setFournisseurId(machine.getFournisseur().getIdFournisseur());
        machineDTO.setLigneId(machine.getLigne().getIdLigne());
        machineDTO.setEquipementIds(machine.getEquipements().stream().map(Equipement::getIdEquipement).collect(Collectors.toList()));
        return machineDTO;
    }

    private Machine mapToEntity(MachineDTO machineDTO) {
        Machine machine = new Machine();
        machine.setDesignation(machineDTO.getDesignation());
        machine.setDateMiseEnService(machineDTO.getDateMiseEnService());
        machine.setDescriptionTechnique(machineDTO.getDescriptionTechnique());
        machine.setFournisseur(fournisseurRepository.findById(machineDTO.getFournisseurId())
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + machineDTO.getFournisseurId())));
        machine.setLigne(ligneRepository.findById(machineDTO.getLigneId())
                .orElseThrow(() -> new ResourceNotFoundException("Ligne not found with id: " + machineDTO.getLigneId())));
        return machine;
    }
}
