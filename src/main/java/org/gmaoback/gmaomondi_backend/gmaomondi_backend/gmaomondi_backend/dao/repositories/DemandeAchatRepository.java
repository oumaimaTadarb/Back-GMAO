package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.DemandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat,Long> {
}