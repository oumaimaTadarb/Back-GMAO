package org.gmaoback.gmaomondi_backend.gestionStock.dao.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usage_entity")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsage")
    private Long idUsage;

    @Column(name = "usage_name", length = 100)
    private String nomUsage;

    @OneToMany(mappedBy = "usage")
    @JsonIgnore
    private List<ArticleUsage> listArticle;
}