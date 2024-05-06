package org.gmaoback.gmaomondi_backend.services;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonCommandeServiceImpl implements BonCommandeService{
    @Autowired
    private BonCommandeRepository bonCommandeRepository;

    @Override
    @Transactional
    public BonCommande updateBonCommandeByCodeSapBC(Long codeSapBC, BonCommande updatedBonCommande) {
        BonCommande existingBonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
        if (existingBonCommande != null) {
            return bonCommandeRepository.save(existingBonCommande);
        } else {
            throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
        }
    }

    @Override
    @Transactional
    public void deleteBonCommandeByCodeSapBC(Long codeSapBC) {
        BonCommande existingBonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
        if (existingBonCommande != null) {
            bonCommandeRepository.delete(existingBonCommande);
        } else {
            throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
        }
    }

    @Override
    public Page<BonCommande> getAllBonCommandesByPage(int page, int size) {
        return bonCommandeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public BonCommande getBonCommandeByCodeSapBC(Long codeSapBC) {
        BonCommande bonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
        if (bonCommande == null) {
            throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
        }
        return bonCommande;
    }
    @Override
    public BonCommande saveBonCommande(BonCommande bonCommande) {
        return bonCommandeRepository.save(bonCommande);
    }
    @Override
    public BonCommande updateBonCommande(BonCommande bonCommande) {
        if (bonCommandeRepository.existsById(bonCommande.getIdBC())) {
            return bonCommandeRepository.save(bonCommande);
        } else {
            throw new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + bonCommande.getIdBC());
        }
    }
    @Override
    public BonCommande getBonCommandeById(Long idBC) {
        return bonCommandeRepository.findById(idBC)
                .orElseThrow(() -> new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + idBC));
    }
    @Override
    public void deleteBonCommandeById(Long idBC) {
        bonCommandeRepository.deleteById(idBC);
    }
    @Override
    public List<BonCommande> getAllBonCommandes() {
        return bonCommandeRepository.findAll();
    }
}