package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Fournisseur;

public interface FournisseurService {
    Fournisseur saveFournisseur(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    Fournisseur getFournisseurById(Long idFournisseur);
    void deleteFournisseurById(Long idFournisseur);


}
