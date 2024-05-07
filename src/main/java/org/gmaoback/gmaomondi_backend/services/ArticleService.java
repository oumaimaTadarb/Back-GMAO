
package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ArticleService {
     Article updateArticleByCodeSapAr(Long codeSapAr, Article updatedArticle);
     void deleteArticleByCodeSapAr(Long codeSapAr);
    Article getArticleByCodeSapAr(Long codeSapAr);
    List<Article>getBesoin();
    Page<Article> getAllArticlesByPage(int page, int size);
    Article saveArticle(Article article);
    Article updateArticle(Article article);
    Article getArticleById(Long idArticle);
    List<Article> getAllArticles();
    void deleteArticleById(Long idArticle);


}
