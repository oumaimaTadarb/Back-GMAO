package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usage,Long> {
}
