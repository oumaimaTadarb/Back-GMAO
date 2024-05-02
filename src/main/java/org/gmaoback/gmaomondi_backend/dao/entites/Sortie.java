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
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSortie;
    private Date dateDemande;
    private Date dateValidation;
    private String etat;
    private String commentaire;
    private String document;


    @OneToMany(mappedBy = "sortie", cascade = CascadeType.ALL)
    private List<ArticleSortie> articleSorties;
}
