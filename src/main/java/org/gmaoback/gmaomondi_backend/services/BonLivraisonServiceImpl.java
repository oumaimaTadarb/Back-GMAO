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
    private BonLivraisonRepository bonLivraisonRepository;

    @Override
    public BonLivraison saveBonLivraison(BonLivraison bonLivraison) {
        return bonLivraisonRepository.save(bonLivraison);
    }

    @Override
    public BonLivraison updateBonLivraison(BonLivraison bonLivraison) {
        if (bonLivraisonRepository.existsById(bonLivraison.getIdBL())) {
            return bonLivraisonRepository.save(bonLivraison);
        } else {
            throw new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + bonLivraison.getIdBL());
        }
    }

    @Override
    public BonLivraison getBonLivraisonById(Long idBL) {
        return bonLivraisonRepository.findById(idBL)
                .orElseThrow(() -> new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + idBL));
    }

    @Override
    public List<BonLivraison> getAllBonLivraison() {
        return bonLivraisonRepository.findAll();
    }

    @Override
    public void deleteBonLivraisonById(Long idBL) {
        bonLivraisonRepository.deleteById(idBL);
    }

    @Override
    public List<BonLivraison> findAllByIdFournisseur(Long idFournisseur) {
        return bonLivraisonRepository.findAllByIdFournisseur(idFournisseur);
    }

    @Override
    public Page<BonLivraison> getAllBonLivraisonByPage(int page, int size) {
        return bonLivraisonRepository.findAll(PageRequest.of(page, size));
    }


}
