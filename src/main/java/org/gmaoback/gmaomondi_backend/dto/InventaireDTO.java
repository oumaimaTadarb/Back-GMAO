package org.gmaoback.gmaomondi_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventaireDTO {
    private Long idInventaire;
    private int quantiteReel;
    private LocalDate dateInventaire;
    private String justification;

    private Long personneId;
    private Long articleId;
}

