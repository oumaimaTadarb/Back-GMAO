package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.*;
@Entity
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

        private int quantiteLivree;
        public ArticleLivraison() {
        }

        public ArticleLivraison(Article article, BonLivraison bonLivraison, int quantiteLivree) {
            this.article = article;
            this.bonLivraison = bonLivraison;
            this.quantiteLivree = quantiteLivree;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Article getArticle() {
            return article;
        }

        public void setArticle(Article article) {
            this.article = article;
        }

        public BonLivraison getBonLivraison() {
            return bonLivraison;
        }

        public void setBonLivraison(BonLivraison bonLivraison) {
            this.bonLivraison = bonLivraison;
        }

        public int getQuantiteLivree() {
            return quantiteLivree;
        }

        public void setQuantiteLivree(int quantiteLivree) {
            this.quantiteLivree = quantiteLivree;
        }
    }
