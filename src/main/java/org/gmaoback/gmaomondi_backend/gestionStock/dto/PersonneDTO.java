package org.gmaoback.gmaomondi_backend.gestionStock.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDTO {
    private Long idPersonne;
    private String nom;
    private String prenom;
    private String specialite;
    private String tel;
    private String email;

}
