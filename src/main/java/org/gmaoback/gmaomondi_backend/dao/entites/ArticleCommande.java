package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = " idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idBC")
    private BonCommande bonCommande;

    private int quantiteCommandee;

    public ArticleCommande(Article article, BonCommande bonCommande, int quantiteCommandee) {
        this.article = article;
        this.bonCommande = bonCommande;
        this.quantiteCommandee = quantiteCommandee;
    }




}

