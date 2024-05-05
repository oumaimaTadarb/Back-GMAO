package org.gmaoback.gmaomondi_backend.dao.repositories;

import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonCommandeRepository extends JpaRepository<BonCommande,Long> {
    BonCommande findByCodeSapBC(Long codeSapBC);
}
