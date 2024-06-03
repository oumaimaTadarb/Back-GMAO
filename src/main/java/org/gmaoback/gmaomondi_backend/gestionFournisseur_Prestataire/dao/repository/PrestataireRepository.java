package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Prestataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire,Long> {
}
