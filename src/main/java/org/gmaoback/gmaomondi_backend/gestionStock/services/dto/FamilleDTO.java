package org.gmaoback.gmaomondi_backend.gestionStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilleDTO {

    private Long idFamille;

    private String nomFamille;

    private Long idFamilleMere;


}