package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDa;
    //private List<ArticleDemande> articles_demandes; // List to hold requested articles and quantities
    private String typeDemande;
    private Date dateSouhaitee;
    private String Commantaire;
    private Date dateDA;
    private Date DateDemissionDevis;
    private int NumDevis;
    private String docDevis;

    public Long getIdDa() {
        return idDa;
    }

    public void setIdDa(Long idDa) {
        this.idDa = idDa;
    }
}
