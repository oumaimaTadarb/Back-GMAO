package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entites.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilleRepository extends JpaRepository<Famille,Long> {
    @Query("SELECT f FROM Famille f WHERE f.familleMere.idFamille = :idFamilleMere")
    List<Famille> findByFamilleMereId(@Param("idFamilleMere") Long idFamilleMere);

}
