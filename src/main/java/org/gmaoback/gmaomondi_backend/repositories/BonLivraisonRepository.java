package org.gmaoback.gmaomondi_backend.repositories;
import org.gmaoback.gmaomondi_backend.entites.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {
}
