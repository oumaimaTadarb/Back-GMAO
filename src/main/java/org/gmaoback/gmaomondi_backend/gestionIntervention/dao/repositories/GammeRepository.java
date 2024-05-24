package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Gamme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GammeRepository extends JpaRepository<Gamme,Long> {
}
