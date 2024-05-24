package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleLivraisonRepository extends JpaRepository<ArticleLivraison,Long>{

    List<ArticleLivraison> findByBonLivraison_IdBL(Long idBL);

    List<ArticleLivraison> findByArticle_IdArticle(Long idArticle);

    List<ArticleLivraison> findByBonLivraison_idBLAndArticle_IdArticle(Long idBL, Long idArticle);
}