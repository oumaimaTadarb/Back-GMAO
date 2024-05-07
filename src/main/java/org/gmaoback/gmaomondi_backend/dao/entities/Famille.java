package org.gmaoback.gmaomondi_backend.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFamille")
    private Long idFamille;
    @Column(name = "name",length = 100,nullable = false)
    private String name = "Racine";
    @ManyToOne
    @JoinColumn(name = "id_famille_mere")
    private Famille familleMere;
    @OneToMany(mappedBy = "famille", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Article> articles;


}

