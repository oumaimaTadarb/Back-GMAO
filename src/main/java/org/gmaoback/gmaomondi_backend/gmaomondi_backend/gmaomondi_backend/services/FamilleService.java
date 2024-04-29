package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Famille;
import org.springframework.stereotype.Service;

@Service
public interface FamilleService {
    Famille saveFamille(Famille famille);
    Famille updateFamille(Famille famille);
    Famille getFamilleById(Long idFamille);
    void deleteFamilleById(Long idFamille);

}
