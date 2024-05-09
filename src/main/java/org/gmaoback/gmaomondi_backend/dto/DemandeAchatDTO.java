package org.gmaoback.gmaomondi_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeAchatDTO {

    private Long idDA;
    private Long codeSapDA;
    private String typeDemande;
    private LocalDateTime dateSouhaitee;
    private String commentaire;
    private LocalDateTime dateDA;
    private LocalDateTime dateDemissionDevis;
    private int numDevis;
    private String docDevis;
}
