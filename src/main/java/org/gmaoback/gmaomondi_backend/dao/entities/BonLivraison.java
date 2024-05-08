package org.gmaoback.gmaomondi_backend.dao.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.enums.StatusBL;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="BonLivraison",indexes={
        @Index(name="idFounisseurx",columnList="Fournisseur")
})
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBL")
    private Long idBL;
    @Column(name = "codeSapBL")
    private Long  codeSapBL;
    @Column(name = "documentBL", length = 100)
    private String documentBL;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateReception")
    private LocalDateTime dateReception;
    @Column(name="idRecepteur")
    private Long idRecepteur;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 100)
    private StatusBL status ;
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idFournisseur", referencedColumnName = "idFournisseur")
    private Fournisseur fournisseur;


    @OneToMany(mappedBy = "bonLivraison")
    @JsonIgnore
    private List<ArticleLivraison> articleLivraisons;

}
