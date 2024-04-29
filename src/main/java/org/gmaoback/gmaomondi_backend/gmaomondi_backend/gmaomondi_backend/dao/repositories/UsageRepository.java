package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.repositories;;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usage,Long> {
}
