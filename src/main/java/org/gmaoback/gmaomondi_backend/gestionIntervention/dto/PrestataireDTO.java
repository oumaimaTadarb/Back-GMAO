package org.gmaoback.gmaomondi_backend.gestionIntervention.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestataireDTO {
    private Long idPrestataire;
    private String nom;
    private String tel;
    private String email;
    private String adresse;
    private List<Long> equipementIds;
}
