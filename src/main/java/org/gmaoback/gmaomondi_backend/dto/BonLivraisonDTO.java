package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonLivraisonDTO {

    private Long idBL;
    private Long codeSapBL;
    private String documentBL;
    private Date dateReception;
    private Long idRecepteur;
    private String statut;

    private Long fournisseurId;
}
