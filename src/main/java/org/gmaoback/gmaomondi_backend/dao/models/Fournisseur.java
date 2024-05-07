package org.gmaoback.gmaomondi_backend.dao.models;
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
    @Column(name = "codeSapFournisseur")
    private Long  codeSapFournisseur;
    @Column(name = "nom", length = 100)
    private String nom;
    @Column(name = "phone")
    private int phone;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "adresse", length = 100)
    private String adresse;



}
