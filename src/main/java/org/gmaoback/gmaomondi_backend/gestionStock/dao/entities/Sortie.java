package org.gmaoback.gmaomondi_backend.gestionStock.dao.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Sortie",
        indexes={
        @Index(name="idPersonnex",columnList="idPersonne")

})
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSortie")
    private Long idSortie;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateDemande")
    private LocalDateTime dateDemande;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateValidation")
    private LocalDateTime dateValidation;
    @Column(name="document", length = 100)
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat", length = 100)
    private EtatSortie etat;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;

    @OneToMany(mappedBy = "sortie")
    @JsonIgnore
    private List<ArticleSortie> articleSorties;
}
