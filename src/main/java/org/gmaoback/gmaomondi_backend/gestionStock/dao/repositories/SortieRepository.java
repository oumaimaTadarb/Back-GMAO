package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortieRepository extends JpaRepository<Sortie,Long> {
    List<Sortie> findByEtat(EtatSortie etat);
}
