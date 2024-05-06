package org.gmaoback.gmaomondi_backend.services;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.BonCommande;
import org.gmaoback.gmaomondi_backend.dao.entites.DemandeAchat;
import org.gmaoback.gmaomondi_backend.dao.repositories.DemandeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeAchatServiceImpl implements DemandeAchatService {
    @Autowired
    private DemandeAchatRepository demandeAchatRepository;

    @Override
    @Transactional
    public DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchat updatedDemandeAchat) {
        DemandeAchat existingDemandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
        if (existingDemandeAchat != null) {
            return demandeAchatRepository.save(existingDemandeAchat);
        } else {
            throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
        }
    }

    @Override
    @Transactional
    public void deleteDemandeAchatByCodeSapDA(Long codeSapDA) {
        DemandeAchat existingDemandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
        if (existingDemandeAchat != null) {
            demandeAchatRepository.delete(existingDemandeAchat);
        } else {
            throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
        }
    }

    @Override
    public Page<DemandeAchat> getAllDemandeAchatByPage(int page, int size) {
        return demandeAchatRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public DemandeAchat getDemandeAchatBycodeSapDA(Long codeSapDA) {
        DemandeAchat demandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
        if (demandeAchat == null) {
            throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
        }
        return demandeAchat;
    }

    @Override
    public DemandeAchat findDevisByCodeSapDA(Long codeSapDA) {
        DemandeAchat demandeAchat = demandeAchatRepository.findDevisByCodeSapDA(codeSapDA);
        if (demandeAchat == null) {
            throw new IllegalArgumentException("Devis non trouvé avec le codeSapDA : " + codeSapDA);
        }
        return demandeAchat;
    }
    @Override
    public DemandeAchat saveDemandeAchat(DemandeAchat demandeAchat) {
        return demandeAchatRepository.save(demandeAchat);
    }

    @Override
    public DemandeAchat updateDemandeAchat(DemandeAchat demandeAchat) {
        if (demandeAchatRepository.existsById(demandeAchat.getIdDa())) {
            return demandeAchatRepository.save(demandeAchat);
        } else {
            throw new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + demandeAchat.getIdDa());
        }
    }

    @Override
    public DemandeAchat getDemandeAchatById(Long idDa) {
        return demandeAchatRepository.findById(idDa)
                .orElseThrow(() -> new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + idDa));
    }

    @Override
    public List<DemandeAchat> getAllDemandeAchat() {
        return demandeAchatRepository.findAll();
    }

}
