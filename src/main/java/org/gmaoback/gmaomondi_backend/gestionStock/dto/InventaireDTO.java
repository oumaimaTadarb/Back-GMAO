package org.gmaoback.gmaomondi_backend.gestionStock.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventaireDTO {
    private Long idInventaire;
    private int quantiteReel;
    private LocalDateTime dateInventaire;
    private String justification;

    private Long idPersonne;
    private Long idArticle;
}

