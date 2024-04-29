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
    private Long idFournisseur;
    private Date dateBC;
    //private ArrayList<ArticleCommande>
    private String documentBC;
    private double montant;
    private Date dateLivraisonConfirmee;
    private Date dateDemissionProforma;
    private int numProforma;
    private String docProforma;


    @OneToMany(mappedBy = "bonCommande", cascade = CascadeType.ALL)
    private List<ArticleCommande> articleCommandes;
}
