package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BonCommandeService {

    BonCommande updateBonCommandeByCodeSapBC (Long codeSapBC, BonCommande updatedBonCommande);
    void deleteBonCommandeByCodeSapBC(Long codeSapBC);
    Page<BonCommande> getAllBonCommandesByPage(int page, int size);
    BonCommande getBonCommandeByCodeSapBC(Long codeSapBC);

}
