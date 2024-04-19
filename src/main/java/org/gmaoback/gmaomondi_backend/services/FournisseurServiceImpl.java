package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur getFournisseurById(Long idFournisseur) {
        return fournisseurRepository.findById(idFournisseur).get();
    }

    @Override
    public void deleteFournisseurById(Long idFournisseur) {
        fournisseurRepository.deleteById(idFournisseur);
    }
}
