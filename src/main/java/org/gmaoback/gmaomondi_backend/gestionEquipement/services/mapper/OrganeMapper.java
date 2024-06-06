package org.gmaoback.gmaomondi_backend.gestionEquipement.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.gmaoback.gmaomondi_backend.gestionEquipement.services.dto.OrganeDTO;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganeMapper {
    OrganeMapper INSTANCE = Mappers.getMapper(OrganeMapper.class);

    @Mapping(source = "fournisseur.idFournisseur", target = "fournisseurId")
    @Mapping(source = "equipement.idEquipement", target = "equipementId")
    @Mapping(source = "prestataire.idPrestataire", target = "prestataireId")
    OrganeDTO toDTO(Organe organe);

    @Mapping(source = "fournisseurId", target = "fournisseur.idFournisseur")
    @Mapping(source = "equipementId", target = "equipement.idEquipement")
    @Mapping(source = "prestataireId", target = "prestataire.idPrestataire")
    Organe toEntity(OrganeDTO organeDTO);

    default Long map(Fournisseur fournisseur) {
        return fournisseur != null ? fournisseur.getIdFournisseur() : null;
    }

    default Long map(Equipement equipement) {
        return equipement != null ? equipement.getIdEquipement() : null;
    }

    default Long map(Prestataire prestataire) {
        return prestataire != null ? prestataire.getIdPrestataire() : null;
    }

    default Fournisseur mapFournisseur(Long id) {
        if (id == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(id);
        return fournisseur;
    }

    default Equipement mapEquipement(Long id) {
        if (id == null) {
            return null;
        }
        Equipement equipement = new Equipement();
        equipement.setIdEquipement(id);
        return equipement;
    }

    default Prestataire mapPrestataire(Long id) {
        if (id == null) {
            return null;
        }
        Prestataire prestataire = new Prestataire();
        prestataire.setIdPrestataire(id);
        return prestataire;
    }
}
