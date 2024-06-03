package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.service;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto.FournisseurDTO;

import java.util.List;

public interface FournisseurService {

    Fournisseur addNewFournisseur(FournisseurDTO fournisseurDto);
    Fournisseur updateFournisseur(Long id, FournisseurDTO fournisseurDTO);
    Fournisseur updateData(Fournisseur fournisseur, FournisseurDTO fournisseurDto);
    void deleteFournisseur(Long id);
    List<FournisseurDTO> listFournisseursDTO();
    List<Fournisseur> listFournisseurs();
    FournisseurDTO loadFournisseurByFournisseurId(Long id);
    Fournisseur loadFournisseurBycodeSapFr(Long codeSapFr);
    Fournisseur loadFournisseurById(Long id);

    FournisseurDTO convertToFournisseurDTO(Fournisseur fournisseur);


//    Fournisseur getFournisseurBycodeSapFr(Long codeSapFr);
//    Fournisseur updateFournisseurByCodeSapFr(Long codeSapFr, Fournisseur updatedFournisseur);
//    void deleteFournisseurByCodeSapFr(Long codeSapFr);
//    Fournisseur saveFournisseur(Fournisseur fournisseur);
//    Fournisseur updateFournisseur(Fournisseur fournisseur);
//    Fournisseur getFournisseurById(Long idFournisseur);
//    void deleteFournisseurById(Long idFournisseur);
//    List<Fournisseur> getAllFournisseurs();
}
