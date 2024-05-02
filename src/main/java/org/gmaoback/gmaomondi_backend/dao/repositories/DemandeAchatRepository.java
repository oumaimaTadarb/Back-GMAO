package org.gmaoback.gmaomondi_backend.dao.repositories;
import org.gmaoback.gmaomondi_backend.dao.entites.DemandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat,Long> {
    DemandeAchat findByCodeSapDA(Long codeSapDA);
    @Query("select d.docDevis, d.NumDevis, d.DateDemissionDevis from DemandeAchat d where d.codeSapDA = :codeSapDA")
    DemandeAchat findDevisByCodeSapDA(@Param("codeSapDA") Long codeSapDA);

}