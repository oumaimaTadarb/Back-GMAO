package org.gmaoback.gmaomondi_backend.dao.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="BonCommande",indexes={
        @Index(name="idFournisseurx",columnList="Fournisseur")
})
public class BonCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBC")
    private Long idBC;
    @Column(name = "codeSapBC")
    private Long codeSapBC;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateBC")
    private LocalDateTime dateBC;
    @Column(name = "documentBC", length = 100)
    private String documentBC;
    @Column(name = "montant")
    private double montant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateLivraisonConfirmee")
    private LocalDateTime dateLivraisonConfirmee;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateDemissionProforma")
    private LocalDateTime dateDemissionProforma;
    @Column(name = "numProforma")
    private Long numProforma;
    @Column(name = "docProforma", length = 100)
    private String docProforma;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idFournisseur", referencedColumnName = "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonCommande")
    @JsonIgnore
    private List<ArticleCommande> articleCommande;
    @OneToMany(mappedBy = "bonCommande")
    @JsonIgnore
    private List<ArticleLivraison> articleLivraisons;
}