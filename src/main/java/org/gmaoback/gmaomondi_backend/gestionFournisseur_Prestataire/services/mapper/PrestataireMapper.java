package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.mapper;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrestataireMapper {
    PrestataireMapper INSTANCE = Mappers.getMapper(PrestataireMapper.class);

    PrestataireDTO toDTO(Prestataire prestataire);
    Prestataire toEntity(PrestataireDTO prestataireDTO);
}
