package org.gmaoback.gmaomondi_backend.repositories;

import org.gmaoback.gmaomondi_backend.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
