package org.gmaoback.gmaomondi_backend.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonLivraisonRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.FournisseurRepository;
import org.gmaoback.gmaomondi_backend.dto.BonLivraisonDTO;
import org.gmaoback.gmaomondi_backend.services.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {

    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;

    @Override
    public BonLivraison addNewBonLivraison(BonLivraisonDTO bonLivraisonDto) {
        return null;
    }

    @Override
    public BonLivraison updateBonLivraison(Long id, BonLivraisonDTO bonLivraisonDTO) {
        return null;
    }

    @Override
    public void deleteBonLivraison(Long id) {

    }

    @Override
    public List<BonLivraisonDTO> listBonLivraisonsDTO() {
        return List.of();
    }

    @Override
    public List<BonLivraison> listBonLivraisons() {
        return List.of();
    }

    @Override
    public BonLivraison loadBonLivraisonById(Long id) {
        return null;
    }

    @Override
    public BonLivraisonDTO loadBonLivraisonDTOById(Long id) {
        return null;
    }

    @Override
    public BonLivraison loadBonLivraisonByCodeSap(Long codeSapBL) {
        return null;
    }


    // Add other methods as per interface

//    @Override
//    public BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison) {
//        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (existingBonLivraison != null) {
//            return bonLivraisonRepository.save(existingBonLivraison);
//        } else {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//    }
//
//    @Override
//    public void deleteBonLivraisonByCodeSapBL(Long codeSapBL) {
//        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (existingBonLivraison != null) {
//            bonLivraisonRepository.delete(existingBonLivraison);
//        } else {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//    }
//
//    @Override
//    public BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL) {
//        BonLivraison bonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (bonLivraison == null) {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//        return bonLivraison;
//    }
//
//    @Override
//    public Page<BonLivraison> getAllBonLivraisonByPage(int page, int size) {
//        try {
//            return bonLivraisonRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des bons de livraison par page : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison saveBonLivraison(BonLivraison bonLivraison) {
//        try {
//
//            if (bonLivraison.getFournisseur() == null) {
//                throw new IllegalArgumentException("Le fournisseur du bon de livraison ne peut pas être null.");
//            }
//            BonLivraison savedBonLivraison = bonLivraisonRepository.save(bonLivraison);
//            bonLivraisonRepository.updateStockDisponibleByBonLivraison(savedBonLivraison);
//            return savedBonLivraison;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement du bon de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison updateBonLivraison(BonLivraison bonLivraison) {
//        try {
//            if (bonLivraisonRepository.existsById(bonLivraison.getIdBL())) {
//                return bonLivraisonRepository.save(bonLivraison);
//            } else {
//                throw new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + bonLivraison.getIdBL());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour du bon de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison getBonLivraisonById(Long idBL) {
//        try {
//            return bonLivraisonRepository.findById(idBL)
//                    .orElseThrow(() -> new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + idBL));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du bon de livraison par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<BonLivraison> getAllBonLivraison() {
//        try {
//            return bonLivraisonRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les bons de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteBonLivraisonById(Long idBL) {
//        try {
//            bonLivraisonRepository.deleteById(idBL);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression du bon de livraison par ID : " + e.getMessage());
//        }
//    }

}



