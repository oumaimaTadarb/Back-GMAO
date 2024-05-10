package org.gmaoback.gmaomondi_backend.dao.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

@AllArgsConstructor
@Builder
@Table(name="article",indexes={
        @Index(name="idFamillex",columnList="idFamille"),
        @Index(name="idUsagex",columnList="idUsage")
})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idArticle")
    private Long idArticle;
    @Column(name = "codeSapArticle")
    private Long codeSapArticle;
    @Column(name = "designation", length = 100)
    private String designation;
    @Column(name = "emplacementPhysique", length = 100)
    private String emplacementPhysique;
    @Column(name = "stockMin")
    private int stockMin;
    @Column(name = "stockMax")
    private int stockMax;
    @Column(name = "stockSecurite")
    private int stockSecurite;
    @Column(name = "stockDisponible")
    private int stockDisponible ;
    @Column(name = "donneeTechnique", length = 100)
    private String donneeTechnique;
    @Column(name = "refFournisseur", length = 100)
    private String refFournisseur;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idFamille", referencedColumnName = "idFamille")
    private Famille famille;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idUsage", referencedColumnName = "idUsage")
    private Usage usage;

    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<ArticleCommande> articleCommande;

    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<ArticleLivraison> articleLivraison;

    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<ArticleDemande> articleDemandes;

    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<ArticleSortie> articleSortie;

}
