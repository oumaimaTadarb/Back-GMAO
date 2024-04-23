package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.ArrayList;
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

    public Long getIdBC() {
        return idBC;
    }

    public void setIdBC(Long idBC) {
        this.idBC = idBC;
    }

    @OneToMany(mappedBy = "bonCommande", cascade = CascadeType.ALL)
    private List<ArticleCommande> articleCommandes;
}
