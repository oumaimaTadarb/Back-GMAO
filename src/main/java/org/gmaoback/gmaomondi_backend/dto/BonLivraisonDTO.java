package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonLivraisonDTO {

    private Long idBL;
    private Long codeSapBL;
    private String documentBL;
    private LocalDateTime dateReception;
    private Long idRecepteur;
    private String status;

    private Long idFournissseur;
}
