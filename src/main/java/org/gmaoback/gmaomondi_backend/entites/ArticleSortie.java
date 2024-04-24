package org.gmaoback.gmaomondi_backend.entites;

import jakarta.persistence.*;

@Entity
public class ArticleSortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idSortie")
    private Sortie sortie;

    private int quantiteSortie;

    public ArticleSortie() {
    }

    public ArticleSortie(Article article, Sortie sortie, int quantiteSortie) {
        this.article = article;
        this.sortie = sortie;
        this.quantiteSortie = quantiteSortie;
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

    public Sortie getSortie() {
        return sortie;
    }

    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    public int getQuantiteSortie() {
        return quantiteSortie;
    }

    public void setQuantiteSortie(int quantiteSortie) {
        this.quantiteSortie = quantiteSortie;
    }
}

