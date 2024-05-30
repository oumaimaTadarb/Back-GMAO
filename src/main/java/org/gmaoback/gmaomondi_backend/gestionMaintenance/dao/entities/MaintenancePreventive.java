package org.gmaoback.gmaomondi_backend.gestionMaintenance.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "maintenance_preventive")
public class MaintenancePreventive extends Maintenance {
    @OneToMany(mappedBy = "maintenancePreventive")
    private List<Gamme> gammes;
}
