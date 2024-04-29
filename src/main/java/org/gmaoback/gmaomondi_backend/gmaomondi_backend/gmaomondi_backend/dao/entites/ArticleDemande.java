package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private DemandeAchat demandeAchat;

    private int quantiteCommandee;

    public ArticleDemande(Article article, DemandeAchat demandeAchat, int quantiteCommandee) {
        this.article = article;
        this.demandeAchat = demandeAchat;
        this.quantiteCommandee = quantiteCommandee;
    }
}
