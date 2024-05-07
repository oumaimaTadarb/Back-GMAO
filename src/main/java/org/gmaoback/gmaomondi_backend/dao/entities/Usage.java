package org.gmaoback.gmaomondi_backend.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Usage")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsage")
    private Long idUsage;

    @Column(name = "usage", length = 100)
    private String nomUsage;
}