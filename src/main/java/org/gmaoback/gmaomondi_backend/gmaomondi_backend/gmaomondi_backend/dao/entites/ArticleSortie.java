package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public ArticleSortie(Article article, Sortie sortie, int quantiteSortie) {
        this.article = article;
        this.sortie = sortie;
        this.quantiteSortie = quantiteSortie;
    }



}

