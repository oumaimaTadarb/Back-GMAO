package org.gmaoback.gmaomondi_backend.gestionStock.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long idUser;
    private String login;
    private String role;
    private Long personneId;
}
