package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Machine;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.EquipementDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface EquipementMapper {
    EquipementMapper INSTANCE = Mappers.getMapper(EquipementMapper.class);

    @Mapping(source = "fournisseur.idFournisseur", target = "fournisseurId")
    @Mapping(source = "prestataire.idPrestataire", target = "prestataireId")
    @Mapping(source = "machine.idMachine", target = "machineId")
    EquipementDTO toDTO(Equipement equipement);

    @Mapping(source = "fournisseurId", target = "fournisseur.idFournisseur")
    @Mapping(source = "prestataireId", target = "prestataire.idPrestataire")
    @Mapping(source = "machineId", target = "machine.idMachine")
    Equipement toEntity(EquipementDTO equipementDTO);

    default Long map(Fournisseur fournisseur) {
        return fournisseur != null ? fournisseur.getIdFournisseur() : null;
    }

    default Long map(Prestataire prestataire) {
        return prestataire != null ? prestataire.getIdPrestataire() : null;
    }

    default Long map(Machine machine) {
        return machine != null ? machine.getIdMachine() : null;
    }

    default Fournisseur mapFournisseur(Long id) {
        if (id == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(id);
        return fournisseur;
    }

    default Prestataire mapPrestataire(Long id) {
        if (id == null) {
            return null;
        }
        Prestataire prestataire = new Prestataire();
        prestataire.setIdPrestataire(id);
        return prestataire;
    }

    default Machine mapMachine(Long id) {
        if (id == null) {
            return null;
        }
        Machine machine = new Machine();
        machine.setIdMachine(id);
        return machine;
    }
}
