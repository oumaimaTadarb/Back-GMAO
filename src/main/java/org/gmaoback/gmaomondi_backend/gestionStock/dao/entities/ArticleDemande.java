package org.gmaoback.gmaomondi_backend.gestionStock.dao.entities;
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
public class ArticleDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="quantiteDemande")
    private int quantiteDemande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArticle")
    @JsonIgnore
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDA")
    @JsonIgnore
    private DemandeAchat demandeAchat;


    public ArticleDemande(Article article, DemandeAchat demandeAchat, int quantiteDemande) {
        this.article = article;
        this.demandeAchat = demandeAchat;
        this.quantiteDemande = quantiteDemande;
    }
}
