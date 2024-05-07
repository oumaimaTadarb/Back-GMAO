package org.gmaoback.gmaomondi_backend.dao.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Inventaire",indexes={
        @Index(name="idPersonnex",columnList="Personne"),
        @Index(name="idArticlex",columnList="Article")
})
public class Inventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInventaire")
    private Long idInventaire;
    @Column(name = "quantiteReel")
    private int quantiteReel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateInventaire")
    private LocalDateTime dateInventaire;
    @Column(name="idFournisseur", length = 100)
    private String justification;
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idArticle", referencedColumnName = "idArticle")
    private Article article;

   }
