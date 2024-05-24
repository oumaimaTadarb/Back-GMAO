package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDemandeRepository extends JpaRepository<ArticleDemande,Long>{
    List<ArticleDemande> findByArticle_IdArticle(Long idArticle);

    List<ArticleDemande> findByDemandeAchat_idDAAndArticle_IdArticle(Long idDA, Long idArticle);

    List<ArticleDemande> findByDemandeAchat_idDA(Long idDA);
}