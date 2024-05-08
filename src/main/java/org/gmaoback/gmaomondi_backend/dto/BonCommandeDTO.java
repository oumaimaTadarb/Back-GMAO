package org.gmaoback.gmaomondi_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonCommandeDTO {

    private Long idBC;
    private Date dateBC;
    private Long codeSapBC;
    private String documentBC;
    private double montant;
    private Date dateLivraisonConfirmee;
    private Date dateDemissionProforma;
    private Long numProforma;
    private String docProforma;
    private Long fournisseurId;

}
