package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.dao.entities.Fournisseur;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonCommandeDTO {

    private Long idBC;
    private Date dateBC;
    private Long codeSapBC;
    private String documentBC;
    private double montant;
    private double prixUnitaire;
    private LocalDateTime dateLivraisonConfirmee;
    private LocalDateTime dateDemissionProforma;
    private Long numProforma;
    private String docProforma;
    private Long idFournisseur;

}
