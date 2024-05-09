
package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ArticleService {
  List<Article>getBesoin();
    Article addNewArticle(ArticleDTO articleDto);
    Article updateArticle(Long id, ArticleDTO articleDTO);
    void deleteArticle(Long id);
    void deleteArticlebycodeSapArticle(Long codeSapArticle);
    List<ArticleDTO> listArticlesDTO();
    List<Article> listArticles();
    Article loadArticleById(Long id);
    Article loadArticleBycodeSapArticle(Long codeSapArticle);
    Article updateDataArticle(Article article, ArticleDTO articleDto);
    Article updateArticleBycodeSapArticle(Long codeSapArticle, ArticleDTO articleDTO);

//     Article updateArticleByCodeSapAr(Long codeSapAr, Article updatedArticle);
//     void deleteArticleByCodeSapAr(Long codeSapAr);
//    Article getArticleByCodeSapAr(Long codeSapAr);
//    List<Article>getBesoin();
//    Page<Article> getAllArticlesByPage(int page, int size);
//    Article saveArticle(Article article);
//    Article updateArticle(Article article);
//    Article getArticleById(Long idArticle);
//    List<Article> getAllArticles();
//    void deleteArticleById(Long idArticle);


}
