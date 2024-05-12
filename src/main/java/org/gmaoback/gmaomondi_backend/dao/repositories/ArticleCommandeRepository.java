package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entities.ArticleCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommandeRepository extends JpaRepository<ArticleCommande,Long>{

    List<ArticleCommande> findByBonCommande_IdBC(Long idBC);

    List<ArticleCommande> findByArticle_IdArticle(Long idArticle);

    List<ArticleCommande> findByBonCommande_idBCAndArticle_IdArticle(Long idBC, Long idArticle);
}

