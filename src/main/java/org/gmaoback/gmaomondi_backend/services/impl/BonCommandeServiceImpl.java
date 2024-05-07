package org.gmaoback.gmaomondi_backend.services.impl;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.models.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.repositories.BonCommandeRepository;
import org.gmaoback.gmaomondi_backend.services.BonCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonCommandeServiceImpl implements BonCommandeService {

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
        try {
            return bonCommandeRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des bons de commande par page : " + e.getMessage());
        }
    }

    @Override
    public BonCommande getBonCommandeByCodeSapBC(Long codeSapBC) {
        try {
            BonCommande bonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
            if (bonCommande == null) {
                throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
            }
            return bonCommande;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du bon de commande par codeSapBC : " + e.getMessage());
        }
    }

    @Override
    public BonCommande saveBonCommande(BonCommande bonCommande) {
        try {
            return bonCommandeRepository.save(bonCommande);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement du bon de commande : " + e.getMessage());
        }
    }

    @Override
    public BonCommande updateBonCommande(BonCommande bonCommande) {
        try {
            if (bonCommandeRepository.existsById(bonCommande.getIdBC())) {
                return bonCommandeRepository.save(bonCommande);
            } else {
                throw new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + bonCommande.getIdBC());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour du bon de commande : " + e.getMessage());
        }
    }

    @Override
    public BonCommande getBonCommandeById(Long idBC) {
        try {
            return bonCommandeRepository.findById(idBC)
                    .orElseThrow(() -> new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + idBC));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du bon de commande par ID : " + e.getMessage());
        }
    }

    @Override
    public void deleteBonCommandeById(Long idBC) {
        try {
            bonCommandeRepository.deleteById(idBC);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression du bon de commande par ID : " + e.getMessage());
        }
    }

    @Override
    public List<BonCommande> getAllBonCommandes() {
        try {
            return bonCommandeRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les bons de commande : " + e.getMessage());
        }
    }
}
