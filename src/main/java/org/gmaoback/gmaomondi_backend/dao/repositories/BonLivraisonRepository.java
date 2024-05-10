package org.gmaoback.gmaomondi_backend.dao.repositories;
import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entities.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {

    BonLivraison findByCodeSapBL(Long codeSapBL);
}
