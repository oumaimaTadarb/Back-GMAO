package org.gmaoback.gmaomondi_backend.dao.repositories;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

}
