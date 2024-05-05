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
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBL;
    private Long  codeSapBL;
    private String documentBL;
    private Date dateReception;
    private Long idRecepteur;
    private String StatusBL;

    @ManyToOne
    @JoinColumn(name = " idFournisseur")
    private Fournisseur fournisseur;


    @OneToMany(mappedBy = "bonLivraison", cascade = CascadeType.ALL)
    private List<ArticleLivraison> articleLivraisons;

}
