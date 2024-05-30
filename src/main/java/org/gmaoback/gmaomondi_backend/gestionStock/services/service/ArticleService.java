
package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
  List<ArticleDTO>getBesoin();
    Article addNewArticle(ArticleDTO articleDto);
    Article updateArticle(Long id, ArticleDTO articleDTO);
    void deleteArticle(Long id);
    void deleteArticlebycodeSapArticle(Long codeSapArticle);
    List<ArticleDTO> listArticlesDTO();
    List<Article> listArticles();
  Article updateDataArticle(Article article, ArticleDTO articleDto);
    Article loadArticleById(Long id);
    Article loadArticleBycodeSapArticle(Long codeSapArticle);

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
