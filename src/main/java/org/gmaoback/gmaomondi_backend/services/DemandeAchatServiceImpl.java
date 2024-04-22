package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.DemandeAchat;
import org.gmaoback.gmaomondi_backend.repositories.DemandeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeAchatServiceImpl implements DemandeAchatService {
    @Autowired
    DemandeAchatRepository demandeAchatRepository;
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

    @Override
    public Page<DemandeAchat> getAllDemandeAchatByPage(int page, int size) {
        return demandeAchatRepository.findAll(PageRequest.of(page,size));
    }
}
