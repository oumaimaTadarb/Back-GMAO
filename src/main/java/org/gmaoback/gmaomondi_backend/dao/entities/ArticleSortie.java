package org.gmaoback.gmaomondi_backend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArticleSortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="quantite")
    @Min(value = 0, message = "Quantity must be non-negative")
    private int quantite;

    @Column(name="commantaire")
    private String commentaire;

    @ManyToOne()
    @JoinColumn(name = "idUsage")
    @JsonIgnore
    private Usage usage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArticle")
    @JsonIgnore
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSortie")
    @JsonIgnore
    private Sortie sortie;

}

