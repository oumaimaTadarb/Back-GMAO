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
        try {
            return demandeAchatRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des demandes d'achat par page : " + e.getMessage());
        }
    }

    @Override
    public DemandeAchat getDemandeAchatBycodeSapDA(Long codeSapDA) {
        try {
            DemandeAchat demandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
            if (demandeAchat == null) {
                throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
            }
            return demandeAchat;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de la demande d'achat par codeSapDA : " + e.getMessage());
        }
    }

    @Override
    public DemandeAchat findDevisByCodeSapDA(Long codeSapDA) {
        try {
            DemandeAchat demandeAchat = demandeAchatRepository.findDevisByCodeSapDA(codeSapDA);
            if (demandeAchat == null) {
                throw new IllegalArgumentException("Devis non trouvé avec le codeSapDA : " + codeSapDA);
            }
            return demandeAchat;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du devis par codeSapDA : " + e.getMessage());
        }
    }

    @Override
    public DemandeAchat saveDemandeAchat(DemandeAchat demandeAchat) {
        try {
            return demandeAchatRepository.save(demandeAchat);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de la demande d'achat : " + e.getMessage());
        }
    }

    @Override
    public DemandeAchat updateDemandeAchat(DemandeAchat demandeAchat) {
        try {
            if (demandeAchatRepository.existsById(demandeAchat.getIdDa())) {
                return demandeAchatRepository.save(demandeAchat);
            } else {
                throw new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + demandeAchat.getIdDa());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de la demande d'achat : " + e.getMessage());
        }
    }

    @Override
    public DemandeAchat getDemandeAchatById(Long idDa) {
        try {
            return demandeAchatRepository.findById(idDa)
                    .orElseThrow(() -> new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + idDa));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de la demande d'achat par ID : " + e.getMessage());
        }
    }

    @Override
    public List<DemandeAchat> getAllDemandeAchat() {
        try {
            return demandeAchatRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de toutes les demandes d'achat : " + e.getMessage());
        }
    }
}
