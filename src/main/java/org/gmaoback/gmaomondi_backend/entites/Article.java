package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idArticle;
    private Long codeSap;
    private String designation;
    private String emplacementPhysique;
    private int stockMin;
    private int stockMax;
    private int stockSecurite;
    private String famille;
    private String donneeTechnique;

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleCommande> articleCommandes;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleLivraison> articleLivraisons;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleSortie> articleSorties;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleDemande> articleDemandes;




}
