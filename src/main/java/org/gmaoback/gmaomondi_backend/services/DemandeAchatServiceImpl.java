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
    public DemandeAchat upadateDemandeAchat(DemandeAchat demandeAchat) {
        return demandeAchatRepository.save(demandeAchat);
    }

    @Override
    public DemandeAchat getDemandeAchatById(Long idDa) {
        return demandeAchatRepository.findById(idDa).get();
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
