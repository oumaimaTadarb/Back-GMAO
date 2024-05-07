package org.gmaoback.gmaomondi_backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;

import java.util.Date;

public class BonCommandeDTO {
    private Long idBC;
    private Date dateBC;
    private Long  codeSapBC;
    private String documentBC;
    private double montant;
    private Date dateLivraisonConfirmee;
    private Date dateDemissionProforma;
    private Long numProforma;
    private String docProforma;
    private Long idFournisseur;
}
