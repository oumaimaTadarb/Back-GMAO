package org.gmaoback.gmaomondi_backend.dao.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="User",indexes={
        @Index(name="idPersonnex",columnList="Personne")

})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Long idUser;
    @Column(name="username", length = 100)
    private String username;
    @Column(name="password", length = 100)
    private String password;
    @Column(name="role", length = 100)
    private String role;
    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;

  }
