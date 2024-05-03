package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilleServiceImpl implements FamilleService {

    @Autowired
    private FamilleRepository familleRepository;

//    @Override
//    public Famille saveFamille(Famille famille) {
//        return familleRepository.save(famille);
//    }
//
//    @Override
//    public Famille updateFamille(Famille famille) {
//        if (familleRepository.existsById(famille.getIdFamille())) {
//            return familleRepository.save(famille);
//        } else {
//            throw new IllegalArgumentException("Famille non trouvée avec l'identifiant : " + famille.getIdFamille());
//        }
//    }
//
//    @Override
//    public Famille getFamilleById(Long idFamille) {
//        return familleRepository.findById(idFamille)
//                .orElseThrow(() -> new IllegalArgumentException("Famille non trouvée avec l'identifiant : " + idFamille));
//    }
//
//    @Override
//    public void deleteFamilleById(Long idFamille) {
//        familleRepository.deleteById(idFamille);
//    }
}
