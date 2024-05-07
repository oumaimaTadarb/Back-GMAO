package org.gmaoback.gmaomondi_backend.dao.repositories;

import org.gmaoback.gmaomondi_backend.dao.models.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonCommandeRepository extends JpaRepository<BonCommande,Long> {
    BonCommande findByCodeSapBC(Long codeSapBC);

}
