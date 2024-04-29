package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.dao.repositories.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        if (fournisseurRepository.existsById(fournisseur.getIdFournisseur())) {
            return fournisseurRepository.save(fournisseur);
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + fournisseur.getIdFournisseur());
        }
    }

    @Override
    public Fournisseur getFournisseurById(Long idFournisseur) {
        return fournisseurRepository.findById(idFournisseur)
                .orElseThrow(() -> new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + idFournisseur));
    }

    @Override
    public void deleteFournisseurById(Long idFournisseur) {
        fournisseurRepository.deleteById(idFournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
}
