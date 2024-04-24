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
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBL;
    private Long idFournisseur;
    private String documentBL;
    private Date dateReception;
    private Long idRecepteur;
    private String StatusBL;
    private String DocBL;

    public Long getIdBL() {
        return idBL;
    }

    public void setIdBL(Long idBL) {
        this.idBL = idBL;
    }
    @OneToMany(mappedBy = "bonLivraison", cascade = CascadeType.ALL)
    private List<ArticleLivraison> articleLivraisons;
}
