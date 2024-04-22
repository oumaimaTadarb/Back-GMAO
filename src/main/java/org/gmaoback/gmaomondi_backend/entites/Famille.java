package org.gmaoback.gmaomondi_backend.entites;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    private Long idFamille;
    private String nomFamille;


    public Long getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(Long idFamille) {
        this.idFamille = idFamille;
    }
}
