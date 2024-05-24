package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilleRepository extends JpaRepository<Famille,Long> {
    @Query("SELECT f FROM Famille f WHERE f.familleMere.idFamille = :idFamilleMere")
    List<Famille> findByFamilleMereId(@Param("idFamilleMere") Long idFamilleMere);

    Famille findByName(String name);

    @Override
    default void delete(Famille famille) {
        if (!"Famille Racine".equals(famille.getName())) {
            delete(famille);
        } else {
            // Logique pour gérer la tentative de suppression de la famille Racine
            // Par exemple, enregistrer un avertissement ou lever une exception
            throw new IllegalStateException("La suppression de la famille Racine n'est pas autorisée.");
        }
    }

}
