package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a WHERE a.stockDisponible < a.stockMin")
    List<Article> findArticlesBelowMinimumStock();
   // List<Article> findArticlesBesoin();


    Article findByCodeSapArticle(Long codeSapArticle);
}
