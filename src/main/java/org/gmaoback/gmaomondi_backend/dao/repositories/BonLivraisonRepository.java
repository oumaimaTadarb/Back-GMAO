package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {
    //List<BonLivraison> findAllByIdFournisseur(Long idFournisseur);
}
