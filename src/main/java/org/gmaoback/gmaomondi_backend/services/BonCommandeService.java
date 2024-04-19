package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.BonCommande;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BonCommandeService {
    BonCommande saveBonCommande(BonCommande bonCommande);
    BonCommande updateBonCommande(BonCommande bonCommande);
    BonCommande getBonCommandeById(Long idBC);
    List<BonCommande>getAllBonCommandes();
    //void deleteBonCommandeById(Long idBC);
    //List<BonCommande>finAllByIdFournisseur(Long idFournisseur);
    Page<BonCommande> getAllArticlesByPage(int page , int size);

}
