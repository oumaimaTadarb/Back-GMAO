package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.LigneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface LigneMapper {
    LigneMapper INSTANCE = Mappers.getMapper(LigneMapper.class);

    LigneDTO toDTO(Ligne ligne);
    Ligne toEntity(LigneDTO ligneDTO);
}
