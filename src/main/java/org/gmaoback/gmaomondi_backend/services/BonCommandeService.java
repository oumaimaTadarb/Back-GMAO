package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.models.BonCommande;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BonCommandeService {

    BonCommande updateBonCommandeByCodeSapBC (Long codeSapBC, BonCommande updatedBonCommande);
    void deleteBonCommandeByCodeSapBC(Long codeSapBC);
    Page<BonCommande> getAllBonCommandesByPage(int page, int size);
    BonCommande getBonCommandeByCodeSapBC(Long codeSapBC);
    BonCommande saveBonCommande(BonCommande bonCommande);
    BonCommande updateBonCommande(BonCommande bonCommande);
    BonCommande getBonCommandeById(Long idBC);
    List<BonCommande>getAllBonCommandes();
    void deleteBonCommandeById(Long idBC);
}
