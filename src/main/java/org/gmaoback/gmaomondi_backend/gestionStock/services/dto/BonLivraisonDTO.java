package org.gmaoback.gmaomondi_backend.gestionStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.StatusBL;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BonLivraisonDTO {

    private Long idBL;
    private Long codeSapBL;
    private String documentBL;
    private LocalDateTime dateReception;
    private Long idRecepteur;
    private StatusBL status;

    private Long idFournissseur;
}
