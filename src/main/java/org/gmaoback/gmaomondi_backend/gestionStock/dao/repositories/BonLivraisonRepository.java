package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {

    BonLivraison findByCodeSapBL(Long codeSapBL);
}
