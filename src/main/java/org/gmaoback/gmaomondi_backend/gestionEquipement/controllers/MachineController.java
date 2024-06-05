package org.gmaoback.gmaomondi_backend.gestionEquipement.controllers;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper.MachineMapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.service.MachineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Machine")
@CrossOrigin("*")
public class MachineController {
    @Autowired
    private MachineService machineService;

    // Méthodes utilisant des entités

    @PostMapping
    public ResponseEntity<Machine> createMachine(@RequestBody Machine machine) {
        Machine createdMachine = machineService.createMachine(machine);
        return ResponseEntity.ok(createdMachine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable Long id, @RequestBody Machine updatedMachine) {
        Machine updated = machineService.updateMachine(id, updatedMachine);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        try {
            machineService.deleteMachine(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        if (machine != null) {
            return ResponseEntity.ok(machine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Machine>> getAllMachines() {
        List<Machine> machines = machineService.getAllMachines();
        return ResponseEntity.ok(machines);
    }

    // Méthodes utilisant des DTOs

    @PostMapping("/dto")
    public ResponseEntity<MachineDTO> createMachineDTO(@RequestBody MachineDTO machineDTO) {
        Machine createdMachine = machineService.createMachineDTO(machineDTO);
        return ResponseEntity.ok(MachineMapper.INSTANCE.toDTO(createdMachine));
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<MachineDTO> updateMachineDTO(@PathVariable Long id, @RequestBody MachineDTO machineDTO) {
        MachineDTO updatedMachineDTO = machineService.updateMachineDTO(id, machineDTO);
        if (updatedMachineDTO != null) {
            return ResponseEntity.ok(updatedMachineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/dto/{id}")
    public ResponseEntity<Void> deleteMachineDTO(@PathVariable Long id) {
        try {
            machineService.deleteMachineDTO(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<MachineDTO> getMachineDTOById(@PathVariable Long id) {
        MachineDTO machineDTO = machineService.getMachineDTOById(id);
        if (machineDTO != null) {
            return ResponseEntity.ok(machineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<List<MachineDTO>> getAllMachinesDTO() {
        List<MachineDTO> machinesDTO = machineService.getAllMachinesDTO();
        return ResponseEntity.ok(machinesDTO);
    }
}
