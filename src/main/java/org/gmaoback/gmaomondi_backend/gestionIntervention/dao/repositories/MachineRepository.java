package org.gmaoback.gmaomondi_backend.gestionIntervention.dao.repositories;

import org.gmaoback.gmaomondi_backend.gestionIntervention.dao.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
}
