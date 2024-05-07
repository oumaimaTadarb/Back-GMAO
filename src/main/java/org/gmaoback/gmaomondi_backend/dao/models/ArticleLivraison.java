package org.gmaoback.gmaomondi_backend.dao.models;
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
public class ArticleLivraison {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;
        @Column(name="quantiteLivraison")
        private int quantiteLivraison;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idArticle")
        @JsonIgnore
        private Article article;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name =  "idBL")
        @JsonIgnore
        private BonLivraison bonLivraison;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idBC")
        @JsonIgnore
        private BonCommande bonCommande;



        public ArticleLivraison(Article article, BonLivraison bonLivraison,BonCommande bonCommande, int quantiteLivraison) {
            this.article = article;
            this.bonLivraison = bonLivraison;
            this.bonCommande=bonCommande;
            this.quantiteLivraison = quantiteLivraison;
        }



    }
