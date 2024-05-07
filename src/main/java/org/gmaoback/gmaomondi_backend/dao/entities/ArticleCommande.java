package org.gmaoback.gmaomondi_backend.dao.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="quantiteCommande")
    private int quantiteCommande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArticle")
    @JsonIgnore
     private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBC")
    @JsonIgnore
    private BonCommande bonCommande;



    public ArticleCommande(Article article, BonCommande bonCommande, int quantiteCommande) {
        this.article = article;
        this.bonCommande = bonCommande;
        this.quantiteCommande= quantiteCommande;
    }




}

