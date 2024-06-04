package org.gmaoback.gmaomondi_backend.gestionEquipement.services.impl;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository.MachineRepository;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.MachineMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;

    @Override
    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine updateMachine(Long id, Machine updatedMachine) {
        Optional<Machine> existingMachine = machineRepository.findById(id);
        if (existingMachine.isPresent()) {
            Machine machine = existingMachine.get();
            machine.setDesignation(updatedMachine.getDesignation());
            machine.setDateMiseEnService(updatedMachine.getDateMiseEnService());
            machine.setDescriptionTechnique(updatedMachine.getDescriptionTechnique());
            machine.setFournisseur(updatedMachine.getFournisseur());
            machine.setEquipements(updatedMachine.getEquipements());
            machine.setLigne(updatedMachine.getLigne());
            return machineRepository.save(machine);
        }
        return null;
    }

    @Override
    public void deleteMachine(Long id) throws Exception {
        Optional<Machine> machine = machineRepository.findById(id);
        if (machine.isPresent()) {
            if (machine.get().getEquipements() != null && !machine.get().getEquipements().isEmpty()) {
                throw new Exception("Cannot delete a Machine that contains Equipements");
            } else {
                machineRepository.deleteById(id);
            }
        } else {
            throw new Exception("Machine not found");
        }
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    @Override
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    @Override
    public Machine createMachineDTO(MachineDTO machineDTO) {
        return createMachine(MachineMapper.INSTANCE.toEntity(machineDTO));
    }

    @Override
    public MachineDTO updateMachineDTO(Long id, MachineDTO machineDTO) {
        Machine machineToUpdate = MachineMapper.INSTANCE.toEntity(machineDTO);
        machineToUpdate.setIdMachine(id);
        Machine updatedMachine = updateMachine(id, machineToUpdate);
    return MachineMapper.INSTANCE.toDTO(updatedMachine);
    }

    @Override
    public void deleteMachineDTO(Long id) throws Exception {
        deleteMachine(id);
    }

    @Override
    public MachineDTO getMachineDTOById(Long id) {
        return MachineMapper.INSTANCE.toDTO(getMachineById(id));
    }

    @Override
    public List<MachineDTO> getAllMachinesDTO() {
        return getAllMachines().stream()
                .map(MachineMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}