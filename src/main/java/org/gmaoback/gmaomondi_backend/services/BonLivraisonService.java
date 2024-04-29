package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BonLivraisonService {
    BonLivraison saveBonLivraison(BonLivraison bonLivraison);

    BonLivraison updateBonLivraison(BonLivraison bonLivraison);

    BonLivraison getBonLivraisonById(Long idBL);

    List<BonLivraison> getAllBonLivraison();

    void deleteBonLivraisonById(Long idBL);
    List<BonLivraison> findAllByIdFournisseur(Long idFournisseur);

    Page<BonLivraison> getAllBonLivraisonByPage(int page, int size);
}
