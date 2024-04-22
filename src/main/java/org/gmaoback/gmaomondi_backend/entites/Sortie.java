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
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSortie;
    private String idPersonne;
    //private List<ArticleSortie> articlesSorties;
    private Date dateDemande;
    private Date dateValidation;
    private String usage;
    private String etat;
    private String commentaire;
    private String document;

    public Long getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(Long idSortie) {
        this.idSortie = idSortie;
    }
}
