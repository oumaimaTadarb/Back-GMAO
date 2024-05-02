package org.gmaoback.gmaomondi_backend.dao.repositories;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findByCodeSapAr(Long codeSapAr);
}
