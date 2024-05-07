package org.gmaoback.gmaomondi_backend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.gmaoback.gmaomondi_backend.dao.entites.BonLivraison;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;

import java.util.Date;

public class BonLivraisonDTO {
    private Long idBL;
    private Long  codeSapBL;
    private String documentBL;
    private Date dateReception;
    private Long idRecepteur;
    public BonLivraison.StatusBL status  ;
    private Long idFournisseur;
}
