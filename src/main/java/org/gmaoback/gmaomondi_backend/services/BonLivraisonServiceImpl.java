package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.*;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonLivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {

    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;
    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison) {
        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
        if (existingBonLivraison != null) {
            return bonLivraisonRepository.save(existingBonLivraison);
        } else {
            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBC : " + codeSapBL);
        }
    }

    @Override
    public void deleteBonLivraisonByCodeSapBL(Long codeSapBL) {
        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
        if (existingBonLivraison != null) {
            bonLivraisonRepository.delete(existingBonLivraison);
        } else {
            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBC : " + codeSapBL);
        }

    }

    @Override
    public BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL) {
        return bonLivraisonRepository.findByCodeSapBL(codeSapBL);

    }
    @Override
    public Page<BonLivraison> getAllBonLivraisonByPage(int page, int size) {
        return bonLivraisonRepository.findAll(PageRequest.of(page, size));
    }


}
