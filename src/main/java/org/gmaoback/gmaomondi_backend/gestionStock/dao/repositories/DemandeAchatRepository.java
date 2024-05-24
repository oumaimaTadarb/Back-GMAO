package org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat,Long> {
    DemandeAchat findByCodeSapDA(Long codeSapDA);
//    @Query("select d.docDevis, d.NumDevis, d.DateDemissionDevis from DemandeAchat d where d.codeSapDA = :codeSapDA")
//    DemandeAchat findDevisByCodeSapDA(Long codeSapDA);
}