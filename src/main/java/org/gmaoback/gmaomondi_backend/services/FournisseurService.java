package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur getFournisseurBycodeSapFr(Long codeSapFr);
    Fournisseur updateFournisseurByCodeSapFr(Long codeSapFr, Fournisseur updatedFournisseur);
    void deleteFournisseurByCodeSapFr(Long codeSapFr);
}
