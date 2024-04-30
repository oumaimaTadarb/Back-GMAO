package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BonCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idBC;
    private Date dateBC;
    private Long  codeSapBC;
    private String documentBC;
    private double montant;
    private Date dateLivraisonConfirmee;
    private Date dateDemissionProforma;
    private int numProforma;
    private String docProforma;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "bonCommande", cascade = CascadeType.ALL)
    private List<ArticleCommande> articleCommandes;
}
