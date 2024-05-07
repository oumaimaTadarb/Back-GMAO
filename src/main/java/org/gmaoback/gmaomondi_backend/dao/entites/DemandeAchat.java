package org.gmaoback.gmaomondi_backend.dao.entites;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gmaoback.gmaomondi_backend.enums.StatusBL;
import org.gmaoback.gmaomondi_backend.enums.typeDA;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDA")
    private Long idDA;
    @Column(name = "codeSapDA")
    private Long  codeSapDA;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
     @Column(name = "dateSouhaitee")
     private LocalDateTime dateSouhaitee;
    @Column(name = "documentBC", length = 100)
    private String Commentaire;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "dateDA")
    private LocalDateTime dateDA;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "DateDemissionDevis")
    private LocalDateTime DateDemissionDevis;

    @Column(name="NumDevis")
    private int NumDevis;

    @Column(name = "docDevis", length = 100)
    private String docDevis;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 100)
    private typeDA type ;

    @OneToMany(mappedBy = "demandeAchat")
    @JsonIgnore
    private List<ArticleDemande> articledemandes;
}
