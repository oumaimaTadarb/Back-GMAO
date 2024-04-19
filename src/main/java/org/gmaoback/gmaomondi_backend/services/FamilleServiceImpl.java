package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Famille;
import org.gmaoback.gmaomondi_backend.repositories.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilleServiceImpl implements FamilleService{
   @Autowired
    FamilleRepository familleRepository;
    @Override
    public Famille saveFamille(Famille famille) {
        return familleRepository.save(famille);
    }

    @Override
    public Famille updateFamille(Famille famille) {
        return familleRepository.save(famille);
    }

    @Override
    public Famille getFamilleById(Long idFamille) {
        return familleRepository.findById(idFamille).get();
    }

    @Override
    public void deleteFamilleById(Long idFamille) {
        familleRepository.deleteById(idFamille);
    }
}
