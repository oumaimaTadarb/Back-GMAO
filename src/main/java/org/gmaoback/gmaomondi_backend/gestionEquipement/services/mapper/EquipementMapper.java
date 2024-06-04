package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.EquipementDTO;
import org.mapstruct.factory.Mappers;

public interface EquipementMapper {
    EquipementMapper INSTANCE = Mappers.getMapper(EquipementMapper.class);

    EquipementDTO toDTO(Equipement equipement);
    Equipement toEntity(EquipementDTO equipementDTO);
}
