package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.ArticleSortie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleSortieRepository extends JpaRepository<ArticleSortie,Long> {
    List<ArticleSortie> findBySortie_IdSortie(Long idSortie);
    List<ArticleSortie> findByArticle_IdArticle(Long idArticle);
    List<ArticleSortie> findAllByArticle_IdArticle(Long articleId);
    List<ArticleSortie> findBySortie_IdSortieAndArticle_IdArticle(Long idSortie, Long idArticle);

}
