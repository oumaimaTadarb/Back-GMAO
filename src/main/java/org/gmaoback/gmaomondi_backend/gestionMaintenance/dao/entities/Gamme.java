package org.gmaoback.gmaomondi_backend.gestionMaintenance.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.gestionMaintenance.enums.Frequence;
import org.gmaoback.gmaomondi_backend.gestionMaintenance.enums.Nature;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "gamme")
public class Gamme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGamme")
    private Long idGamme;

    @Column(name = "refGamme", length = 100)
    private String refGamme;

    @Enumerated(EnumType.STRING)
    @Column(name = "nature", length = 50)
    private Nature nature;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequence", length = 50)
    private Frequence frequence;

    @ManyToOne
    @JoinColumn(name = "idMaintenancePreventive")
    private MaintenancePreventive maintenancePreventive;
}
