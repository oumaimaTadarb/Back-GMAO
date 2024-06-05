package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.service;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;

import java.util.List;

public interface PrestataireService {

    PrestataireDTO createPrestataireDTO(PrestataireDTO prestataireDTO);
    PrestataireDTO updatePrestataireDTO(Long id, PrestataireDTO prestataireDTO);
    void deletePrestataireDTO(Long id) throws Exception;
    PrestataireDTO getPrestataireDTOById(Long id);
    List<PrestataireDTO> getAllPrestatairesDTO();

    // Méthodes utilisant des entités
    Prestataire createPrestataire(Prestataire prestataire);
    Prestataire updatePrestataire(Long id, Prestataire prestataire);
    void deletePrestataireEntity(Long id) throws Exception;
    Prestataire getPrestataireByIdEntity(Long id);
    List<Prestataire> getAllPrestatairesEntity();
}
