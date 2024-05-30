package org.gmaoback.gmaomondi_backend.gestionEquipement.dao.repository;

import org.gmaoback.gmaomondi_backend.gestionEquipement.dao.entities.Organe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganeRepository extends JpaRepository<Organe, Long> {
}
