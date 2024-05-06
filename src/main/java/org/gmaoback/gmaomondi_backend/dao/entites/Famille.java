package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFamille;

    private String nomFamille = "Racine";

    @ManyToOne
    @JoinColumn(name = "id_famille_mere")
    private Famille familleMere;

    @OneToMany(mappedBy = "famille", cascade = CascadeType.ALL)
    private List<Article> articles;
}

