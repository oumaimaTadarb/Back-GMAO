package org.gmaoback.gmaomondi_backend.services;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.dao.repositories.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur getFournisseurBycodeSapFr(Long codeSapFr) {
        return fournisseurRepository.findBycodeSapFr(codeSapFr);
    }

    @Override
    public Fournisseur updateFournisseurByCodeSapFr(Long codeSapFr, Fournisseur updatedFournisseur) {
        Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
        if (existingFournisseur != null) {
            return fournisseurRepository.save(existingFournisseur);
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
        }
    }


    @Override
    public void  deleteFournisseurByCodeSapFr(Long codeSapFr) {
       Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
        if (existingFournisseur != null) {
            fournisseurRepository.delete(existingFournisseur);
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
        }
    }
}
