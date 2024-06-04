package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.service;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.PrestataireDTO;

import java.util.List;

public interface PrestataireService {

    PrestataireDTO createPrestataire(PrestataireDTO prestataireDTO);
    PrestataireDTO updatePrestataire(Long id, PrestataireDTO prestataireDTO);
    void deletePrestataire(Long id) throws Exception;
    PrestataireDTO getPrestataireById(Long id);
    List<PrestataireDTO> getAllPrestataires();

    // Méthodes utilisant des entités
    Prestataire createPrestataire(Prestataire prestataire);
    Prestataire updatePrestataire(Long id, Prestataire prestataire);
    void deletePrestataireEntity(Long id) throws Exception;
    Prestataire getPrestataireByIdEntity(Long id);
    List<Prestataire> getAllPrestatairesEntity();
}
