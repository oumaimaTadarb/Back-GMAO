package org.gmaoback.gmaomondi_backend.repositories;

import org.gmaoback.gmaomondi_backend.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource(path = "rest")
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {


}
