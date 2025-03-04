package org.gmaoback.gmaomondi_backend.gestionFournisseur_Prestataire.services.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDTO {
    private Long idFournisseur;
    private Long codeSapFr;
    private String nom;
    private String tel;
    private String email;
    private String adresse;

}
