package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.repositories.BonCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonCommandeServiceImpl implements BonCommandeService{
    @Autowired
    BonCommandeRepository bonCommandeRepository;
    @Override
    public BonCommande saveBonCommande(BonCommande bonCommande) {
        return bonCommandeRepository.save(bonCommande);
    }
    @Override
    public BonCommande updateBonCommande(BonCommande bonCommande) {
        return bonCommandeRepository.save(bonCommande);
    }
    @Override
    public BonCommande getBonCommandeById(Long idBC) {
        return bonCommandeRepository.findById(idBC).get();
    }

    @Override
    public List<BonCommande> getAllBonCommandes() {
        return bonCommandeRepository.findAll();
    }
    //@Override
    // public List<BonCommande> finAllByIdFournisseur(Long idFournisseur) {
    //     return bonCommandeRepository.findAllByIdFournisseur(IdFournisseur);
    // }

    @Override
    public Page<BonCommande> getAllArticlesByPage(int page, int size) {
        return bonCommandeRepository.findAll(PageRequest.of(page,size));
    }
}
