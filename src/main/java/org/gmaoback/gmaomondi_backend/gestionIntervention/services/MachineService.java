package org.gmaoback.gmaomondi_backend.gestionIntervention.services;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dto.MachineDTO;

import java.util.List;

public interface MachineService {
    MachineDTO createMachine(MachineDTO machineDTO);
    MachineDTO getMachineById(Long id);
    List<MachineDTO> getAllMachines();
    MachineDTO updateMachine(Long id, MachineDTO machineDTO);
    void deleteMachine(Long id);
}
