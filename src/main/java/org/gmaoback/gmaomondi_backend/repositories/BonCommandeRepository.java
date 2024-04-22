package org.gmaoback.gmaomondi_backend.repositories;

import org.gmaoback.gmaomondi_backend.entites.Article;
import org.gmaoback.gmaomondi_backend.entites.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonCommandeRepository extends JpaRepository<BonCommande,Long> {
    List<BonCommande> findAllByIdFournisseur(Long idFournisseur);
}
