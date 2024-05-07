package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entites.*;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonLivraisonRepository;
import org.gmaoback.gmaomondi_backend.services.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {

    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;

    @Override
    public BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison) {
        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
        if (existingBonLivraison != null) {
            return bonLivraisonRepository.save(existingBonLivraison);
        } else {
            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
        }
    }

    @Override
    public void deleteBonLivraisonByCodeSapBL(Long codeSapBL) {
        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
        if (existingBonLivraison != null) {
            bonLivraisonRepository.delete(existingBonLivraison);
        } else {
            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
        }
    }

    @Override
    public BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL) {
        BonLivraison bonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
        if (bonLivraison == null) {
            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
        }
        return bonLivraison;
    }

    @Override
    public Page<BonLivraison> getAllBonLivraisonByPage(int page, int size) {
        try {
            return bonLivraisonRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des bons de livraison par page : " + e.getMessage());
        }
    }

    @Override
    public BonLivraison saveBonLivraison(BonLivraison bonLivraison) {
        try {
            if (bonLivraison.getStatut() != BonLivraison.StatusBL.VALIDE) {
                throw new IllegalArgumentException("Le statut du bon de livraison est non conforme.");
            }
            if (bonLivraison.getFournisseur() == null) {
                throw new IllegalArgumentException("Le fournisseur du bon de livraison ne peut pas être null.");
            }
            BonLivraison savedBonLivraison = bonLivraisonRepository.save(bonLivraison);
            bonLivraisonRepository.updateStockDisponibleByBonLivraison(savedBonLivraison);
            return savedBonLivraison;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement du bon de livraison : " + e.getMessage());
        }
    }

    @Override
    public BonLivraison updateBonLivraison(BonLivraison bonLivraison) {
        try {
            if (bonLivraisonRepository.existsById(bonLivraison.getIdBL())) {
                return bonLivraisonRepository.save(bonLivraison);
            } else {
                throw new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + bonLivraison.getIdBL());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour du bon de livraison : " + e.getMessage());
        }
    }

    @Override
    public BonLivraison getBonLivraisonById(Long idBL) {
        try {
            return bonLivraisonRepository.findById(idBL)
                    .orElseThrow(() -> new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + idBL));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du bon de livraison par ID : " + e.getMessage());
        }
    }

    @Override
    public List<BonLivraison> getAllBonLivraison() {
        try {
            return bonLivraisonRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les bons de livraison : " + e.getMessage());
        }
    }

    @Override
    public void deleteBonLivraisonById(Long idBL) {
        try {
            bonLivraisonRepository.deleteById(idBL);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression du bon de livraison par ID : " + e.getMessage());
        }
    }
}



