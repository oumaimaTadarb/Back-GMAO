package org.gmaoback.gmaomondi_backend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="quantiteSortie")
    private int quantiteSortie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArticle")
    @JsonIgnore
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSortie")
    @JsonIgnore
    private Sortie sortie;



    public ArticleSortie(Article article, Sortie sortie, int quantiteSortie) {
        this.article = article;
        this.sortie = sortie;
        this.quantiteSortie = quantiteSortie;
    }



}

