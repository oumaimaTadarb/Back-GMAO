package org.gmaoback.gmaomondi_backend.dao.repositories;
import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Article a SET a.stockDisponible = a.stockDisponible + (SELECT al.quantiteLivree FROM ArticleLivraison al WHERE al.article = a AND al.bonLivraison = :bonLivraison)")
    void updateStockDisponibleByBonLivraison(BonLivraison bonLivraison);
    BonLivraison findByCodeSapBL(Long codeSapBL);
}
