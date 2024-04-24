package org.gmaoback.gmaomondi_backend.entites;
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
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSortie;
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

    @OneToMany(mappedBy = "sortie", cascade = CascadeType.ALL)
    private List<ArticleSortie> articleSorties;
}
