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
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsage;
    private String usage;

    public Long getIdUsage() {
        return idUsage;
    }

    public void setIdUsage(Long idUsage) {
        this.idUsage = idUsage;
    }
}
