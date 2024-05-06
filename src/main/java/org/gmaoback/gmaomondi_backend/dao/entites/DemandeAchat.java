package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDa;
    private Long  codeSapDA;
    private String typeDemande;
    private Date dateSouhaitee;
    private String Commentaire;
    private Date dateDA;
    private Date DateDemissionDevis;
    private int NumDevis;
    private String docDevis;


    @OneToMany(mappedBy = "demandeAchat", cascade = CascadeType.ALL)
    private List<ArticleDemande> articledemandes;
}
