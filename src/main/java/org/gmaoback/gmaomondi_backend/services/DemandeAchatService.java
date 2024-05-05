package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.DemandeAchat;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeAchatService {
    DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchat updatedDemandeAchat);
    void deleteDemandeAchatByCodeSapDA(Long codeSapDA);
    Page<DemandeAchat> getAllDemandeAchatByPage(int page, int size);
    DemandeAchat getDemandeAchatBycodeSapDA(Long codeSapDA);
    DemandeAchat findDevisByCodeSapDA(Long codeSapDA);
}
