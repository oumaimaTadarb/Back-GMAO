package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.dto.DemandeAchatDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapBC, DemandeAchatDTO demandeAchatDTO);

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
