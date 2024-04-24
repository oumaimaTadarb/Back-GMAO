package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.*;
@Entity
public class ArticleDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idDa")
    private BonCommande bonCommande;

    private int quantiteCommandee;


    public ArticleDemande() {
    }

    public ArticleDemande(Article article, BonCommande bonCommande, int quantiteCommandee) {
        this.article = article;
        this.bonCommande = bonCommande;
        this.quantiteCommandee = quantiteCommandee;
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

    public BonCommande getBonCommande() {
        return bonCommande;
    }

    public void setBonCommande(BonCommande bonCommande) {
        this.bonCommande = bonCommande;
    }

    public int getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(int quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }
}
