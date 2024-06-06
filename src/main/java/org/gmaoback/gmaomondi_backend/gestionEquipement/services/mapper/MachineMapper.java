package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.MachineDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface MachineMapper{
    MachineMapper INSTANCE = Mappers.getMapper(MachineMapper.class);

    @Mapping(source = "fournisseur.idFournisseur", target = "fournisseurId")
    @Mapping(source = "ligne.idLigne", target = "ligneId")
    @Mapping(source = "equipements", target = "equipementIds")
    MachineDTO toDTO(Machine machine);

    Machine toEntity(MachineDTO machineDTO);

    default Long map(Fournisseur fournisseur) {
        return fournisseur != null ? fournisseur.getIdFournisseur() : null;
    }

    default Long map(Ligne ligne) {
        return ligne != null ? ligne.getIdLigne() : null;
    }

    default List<Long> map(List<Equipement> equipements) {
        return equipements != null ?
                equipements.stream()
                        .map(Equipement::getIdEquipement)
                        .collect(Collectors.toList()) : null;
    }
}
