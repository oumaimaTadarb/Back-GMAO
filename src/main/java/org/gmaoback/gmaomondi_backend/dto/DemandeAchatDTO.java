package org.gmaoback.gmaomondi_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeAchatDTO {

    private Long idDa;
    private Long codeSapDA;
    private String typeDemande;
    private Date dateSouhaitee;
    private String commentaire;
    private Date dateDA;
    private Date dateDemissionDevis;
    private int numDevis;
    private String docDevis;
}
