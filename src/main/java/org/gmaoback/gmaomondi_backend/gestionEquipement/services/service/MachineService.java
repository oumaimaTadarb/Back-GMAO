package org.gmaoback.gmaomondi_backend.gestionEquipement.services.service;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;

import java.util.List;

public interface MachineService {
    Machine createMachine(Machine machine);
    Machine updateMachine(Long id, Machine machine);
    void deleteMachine(Long id) throws Exception;
    Machine getMachineById(Long id);
    List<Machine> getAllMachines();
    Machine createMachineDTO(MachineDTO machineDTO);
    MachineDTO updateMachineDTO(Long id, MachineDTO machineDTO);
    void deleteMachineDTO(Long id) throws Exception;
    MachineDTO getMachineDTOById(Long id);
    List<MachineDTO> getAllMachinesDTO();
}
