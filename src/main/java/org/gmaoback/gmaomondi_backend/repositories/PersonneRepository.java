package org.gmaoback.gmaomondi_backend.repositories;
import org.gmaoback.gmaomondi_backend.entites.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
