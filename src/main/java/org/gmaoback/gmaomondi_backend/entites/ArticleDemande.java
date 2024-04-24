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
    private DemandeAchat demandeAchat;

    private int quantiteCommandee;

    public ArticleDemande() {
    }

    public ArticleDemande(Article article, DemandeAchat demandeAchat, int quantiteCommandee) {
        this.article = article;
        this.demandeAchat = demandeAchat;
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

    public DemandeAchat getDemandeAchat() {
        return demandeAchat;
    }

    public void setDemandeAchat(DemandeAchat demandeAchat) {
        this.demandeAchat = demandeAchat;
    }

    public int getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(int quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }
}
