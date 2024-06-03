package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.repository;

import org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.dao.entitites.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findBycodeSapFr(Long codeSapFr);

}
