package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneRepository extends JpaRepository<Ligne, Long> {
}
