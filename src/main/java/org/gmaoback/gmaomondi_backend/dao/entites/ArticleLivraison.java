package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleLivraison {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "idArticle")
        private Article article;

        @ManyToOne
        @JoinColumn(name = "idBL")
        private BonLivraison bonLivraison;
        @ManyToOne
        @JoinColumn(name = "idBC")
        private BonCommande bonCommande;

        private int quantiteLivree;

    public ArticleLivraison(Article article, BonLivraison bonLivraison,BonCommande bonCommande, int quantiteLivree) {
            this.article = article;
            this.bonLivraison = bonLivraison;
            this.bonCommande=bonCommande;
            this.quantiteLivree = quantiteLivree;
        }



    }
