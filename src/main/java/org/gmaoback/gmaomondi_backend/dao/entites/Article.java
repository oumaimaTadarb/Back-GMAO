package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

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
    private int stockDisponiblezedcv  ;
    private String famille;
    private String donneeTechnique;
    private String refFournisseur;


    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleCommande> articleCommandes;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleLivraison> articleLivraisons;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleSortie> articleSorties;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleDemande> articleDemandes;




}
