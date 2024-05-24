package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonCommandeRepository extends JpaRepository<BonCommande,Long> {
    BonCommande findByCodeSapBC(Long codeSapBC);

}
