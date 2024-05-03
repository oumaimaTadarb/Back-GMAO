package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;

import java.util.List;

public interface FournisseurService {
//    Fournisseur saveFournisseur(Fournisseur fournisseur);
//    Fournisseur updateFournisseur(Fournisseur fournisseur);
//    Fournisseur getFournisseurById(Long idFournisseur);
//    void deleteFournisseurById(Long idFournisseur);
//    List<Fournisseur> getAllFournisseurs();
    Fournisseur getFournisseurBycodeSapFr(Long codeSapFr);
}
