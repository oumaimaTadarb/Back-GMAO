package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findBycodeSapFr(Long codeSapFr);
}
