package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.ArrayList;
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
}
