package org.gmaoback.gmaomondi_backend.repositories;
import org.gmaoback.gmaomondi_backend.entites.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
