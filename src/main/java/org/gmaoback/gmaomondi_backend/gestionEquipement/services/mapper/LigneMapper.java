package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.LigneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface LigneMapper {
    LigneMapper INSTANCE = Mappers.getMapper(LigneMapper.class);

    @Mapping(source = "machines", target = "machineIds")
    LigneDTO toDTO(Ligne ligne);

    default List<Long> map(List<Machine> machines) {
        if (machines != null) {
            return machines.stream()
                    .map(Machine::getIdMachine) // Suppose que votre classe Machine a une méthode getId()
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
    Ligne toEntity(LigneDTO ligneDTO);
}
