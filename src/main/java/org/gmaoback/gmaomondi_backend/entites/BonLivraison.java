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
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBL;
    private Long idFournisseur;
    private Long idBC;
    //private List<ArticleLivré> articlesLivres;
    private String documentBL;
    private Date dateReception;
    private Long idRecepteur;
    private String StatusBL;
    private String DocBL;

}
