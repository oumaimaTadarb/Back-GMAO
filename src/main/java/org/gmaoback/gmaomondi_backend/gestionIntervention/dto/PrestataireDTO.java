package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestataireDTO {
    private Long idPrestataire;
    private String nom;
    private String tel;
    private String email;
    private String adresse;
}
