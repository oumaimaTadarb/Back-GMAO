package org.gmaoback.gmaomondi_backend.gestionStock.dao.entities;
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
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFournisseur")
    private Long idFournisseur;
    @Column(name = "codeSapFr")
    private Long  codeSapFr;
    @Column(name = "nom", length = 100)
    private String nom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "adresse", length = 100)
    private String adresse;



}
