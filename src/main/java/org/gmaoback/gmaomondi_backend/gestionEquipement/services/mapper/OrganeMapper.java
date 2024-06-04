package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.OrganeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganeMapper {
    OrganeMapper INSTANCE = Mappers.getMapper(OrganeMapper.class);

    OrganeDTO toDTO(Organe organe);
    Organe toEntity(OrganeDTO organeDTO);
}
