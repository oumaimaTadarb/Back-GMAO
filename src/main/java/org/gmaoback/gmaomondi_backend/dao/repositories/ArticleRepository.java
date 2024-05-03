package org.gmaoback.gmaomondi_backend.dao.repositories;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findByCodeSapAr(Long codeSapAr);
    @Query("SELECT a FROM Article a WHERE a.stockDisponible < a.stockMin")
    List<Article> findArticlesBesoin();

}
