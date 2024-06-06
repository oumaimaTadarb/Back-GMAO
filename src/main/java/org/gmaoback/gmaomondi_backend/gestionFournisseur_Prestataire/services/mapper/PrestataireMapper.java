package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Equipement;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PrestataireMapper {
    PrestataireMapper INSTANCE = Mappers.getMapper(PrestataireMapper.class);

    PrestataireDTO toDTO(Prestataire prestataire);


    default Prestataire toEntity(PrestataireDTO prestataireDTO) {
        if (prestataireDTO == null) {
            return null;
        }
        Prestataire prestataire = new Prestataire();
        prestataire.setIdPrestataire(prestataireDTO.getIdPrestataire());
        prestataire.setNom(prestataireDTO.getNom());
        prestataire.setTel(prestataireDTO.getTel());
        prestataire.setEmail(prestataireDTO.getEmail());
        prestataire.setAdresse(prestataireDTO.getAdresse());
        if (prestataireDTO.getEquipementIds() != null) {
            List<Equipement> equipements = prestataireDTO.getEquipementIds().stream()
                    .map(equipementId -> {
                        Equipement equipement = new Equipement();
                        equipement.setIdEquipement(equipementId);
                        return equipement;
                    })
                    .collect(Collectors.toList());
            prestataire.setEquipements(equipements);
        }
        return prestataire;
    }}