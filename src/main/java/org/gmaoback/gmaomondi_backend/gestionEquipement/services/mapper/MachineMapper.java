package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MachineMapper{
    MachineMapper INSTANCE = Mappers.getMapper(MachineMapper.class);
    MachineDTO toDTO(Machine machine);
    Machine toEntity(MachineDTO machineDTO);
}
