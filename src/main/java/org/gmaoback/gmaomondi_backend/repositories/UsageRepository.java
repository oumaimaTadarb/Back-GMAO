package org.gmaoback.gmaomondi_backend.repositories;;
import org.gmaoback.gmaomondi_backend.entites.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usage,Long> {
}
