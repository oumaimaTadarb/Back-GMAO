package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.repositories.BonLivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {
    @Autowired
    BonLivraisonRepository bonLivraisonRepository;
    @Override
    public BonLivraison saveBonLivraison(BonLivraison bonLivraison) {
        return bonLivraisonRepository.save(bonLivraison);
    }

    @Override
    public BonLivraison updateBonLivraison(BonLivraison bonLivraison) {
        return bonLivraisonRepository.save(bonLivraison);
    }

    @Override
    public BonLivraison getBonLivraisonById(Long idBL) {
        return bonLivraisonRepository.findById(idBL).get();
    }

    @Override
    public List<BonLivraison> getAllBonLivraison() {
        return bonLivraisonRepository.findAll();
    }
    //@Override
    // public List<BonLivraisone> finAllByIdFournisseur(Long idFournisseur) {
    //     return bonLivraisonRepository.findAllByIdFournisseur(IdFournisseur);
    // }
    @Override
    public Page<BonLivraison> getAllBonLivraisonbyPage(int page, int size) {
        return bonLivraisonRepository.findAll(PageRequest.of(page,size));
    }
}
