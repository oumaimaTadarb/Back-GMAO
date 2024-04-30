package org.gmaoback.gmaomondi_backend.dao.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventaire;
    private int quantiteReel;
    private Date dateInventaire;
    private String justification;
    @ManyToOne
    @JoinColumn(name = " idPersonne")
    private Personne personne;
    @ManyToOne
    private Article idArticle;

   }
