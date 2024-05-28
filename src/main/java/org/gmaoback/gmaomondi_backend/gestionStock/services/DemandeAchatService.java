package org.gmaoback.gmaomondi_backend.gestionStock.services;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.DemandeAchatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DemandeAchatService {
    DemandeAchat addNewDemandeAchat(DemandeAchatDTO demandeAchatDto);
    DemandeAchat updateData(DemandeAchat demandeAchat, DemandeAchatDTO demandeAchatDto);
    void deleteDemandeAchat(Long id);
    List<DemandeAchatDTO> listDemandeAchatsDTO();
    List<DemandeAchat> listDemandeAchats();
    DemandeAchat loadDemandeAchatById(Long id);
    DemandeAchatDTO loadDemandeAchatByDemandeAchatId(Long id);
    DemandeAchat loadDemandeAchatByCodeSap(Long codeSapBC);
    DemandeAchat updateDemandeAchat(Long id, DemandeAchatDTO demandeAchatDTO);
    DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchatDTO demandeAchatDTO);
//    DemandeAchat findDevisByCodeSapDA(Long codeSapDA);

//    DemandeAchat saveDemandeAchat(DemandeAchat demandeAchat);
//    DemandeAchat updateDemandeAchat(DemandeAchat demandeAchat);
//    DemandeAchat getDemandeAchatById(Long idDa);
//    List<DemandeAchat> getAllDemandeAchat();
//    DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchat updatedDemandeAchat);
//    void deleteDemandeAchatByCodeSapDA(Long codeSapDA);
//    Page<DemandeAchat> getAllDemandeAchatByPage(int page, int size);
//    DemandeAchat getDemandeAchatBycodeSapDA(Long codeSapDA);
//    DemandeAchat findDevisByCodeSapDA(Long codeSapDA);
}
