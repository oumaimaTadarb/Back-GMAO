package org.gmaoback.gmaomondi_backend.dto;
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
    private String Phone;
    private String email;
}
