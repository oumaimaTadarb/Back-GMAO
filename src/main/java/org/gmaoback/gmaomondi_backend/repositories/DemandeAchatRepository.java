package org.gmaoback.gmaomondi_backend.repositories;
import org.gmaoback.gmaomondi_backend.entites.DemandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat,Long> {
}