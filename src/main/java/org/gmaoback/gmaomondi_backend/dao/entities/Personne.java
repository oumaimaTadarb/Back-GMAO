package org.gmaoback.gmaomondi_backend.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersonne")
    private Long idPersonne;
    @Column(name="nom", length = 100)
    private String nom;
    @Column(name="prenom", length = 100)
    private String prenom;
    @Column(name="specialite", length = 100)
    private String specialite;
    @Column(name="phone")
    private Long phone;
    @Column(name="email", length = 100)
    private String email;


   }
