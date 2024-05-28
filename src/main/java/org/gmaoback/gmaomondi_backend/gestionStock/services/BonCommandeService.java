package org.gmaoback.gmaomondi_backend.gestionStock.services;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.BonCommandeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BonCommandeService {
    BonCommande addNewBonCommande(BonCommandeDTO bonCommandeDto);
    BonCommande updateBonCommande(Long id, BonCommandeDTO bonCommandeDTO);
    BonCommande updateData(BonCommande BonCommande, BonCommandeDTO bonCommandeDto);
    void deleteBonCommande(Long id);
    List<BonCommandeDTO> listBonCommandesDTO();
    List<BonCommande> listBonCommandes();
    BonCommande loadBonCommandeById(Long id);
    BonCommandeDTO loadBonCommandeByBonCommandeId(Long id);
    BonCommande loadBonCommandeByCodeSap(Long codeSapBC);


//    BonCommande updateBonCommandeByCodeSapBC (Long codeSapBC, BonCommande updatedBonCommande);
//    void deleteBonCommandeByCodeSapBC(Long codeSapBC);
//    Page<BonCommande> getAllBonCommandesByPage(int page, int size);
//    BonCommande getBonCommandeByCodeSapBC(Long codeSapBC);
//    BonCommande saveBonCommande(BonCommande bonCommande);
//    BonCommande updateBonCommande(BonCommande bonCommande);
//    BonCommande getBonCommandeById(Long idBC);
//    List<BonCommande>getAllBonCommandes();
//    void deleteBonCommandeById(Long idBC);
}
