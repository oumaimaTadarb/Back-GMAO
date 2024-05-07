package org.gmaoback.gmaomondi_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.dao.entites.Famille;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilleDTO {

    private Long idFamille;

    private String nomFamille;

    private Long idFamilleMere;
}