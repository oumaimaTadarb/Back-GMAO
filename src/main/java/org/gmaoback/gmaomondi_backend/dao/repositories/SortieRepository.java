package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.enums.EtatSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortieRepository extends JpaRepository<Sortie,Long> {
    List<Sortie> findByEtat(EtatSortie etat);
}
