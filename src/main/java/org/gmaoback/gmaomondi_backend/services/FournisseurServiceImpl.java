package org.gmaoback.gmaomondi_backend.services;

import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.dao.entites.Fournisseur;
import org.gmaoback.gmaomondi_backend.dao.repositories.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        try {
            return fournisseurRepository.save(fournisseur);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement du fournisseur : " + e.getMessage());
        }
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        try {
            if (fournisseurRepository.existsById(fournisseur.getIdFournisseur())) {
                return fournisseurRepository.save(fournisseur);
            } else {
                throw new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + fournisseur.getIdFournisseur());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour du fournisseur : " + e.getMessage());
        }
    }

    @Override
    public Fournisseur getFournisseurById(Long idFournisseur) {
        try {
            return fournisseurRepository.findById(idFournisseur)
                    .orElseThrow(() -> new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + idFournisseur));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du fournisseur par ID : " + e.getMessage());
        }
    }

    @Override
    public void deleteFournisseurById(Long idFournisseur) {
        try {
            fournisseurRepository.deleteById(idFournisseur);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression du fournisseur par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        try {
            return fournisseurRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les fournisseurs : " + e.getMessage());
        }
    }

    @Override
    public Fournisseur getFournisseurBycodeSapFr(Long codeSapFr) {
        try {
            return fournisseurRepository.findBycodeSapFr(codeSapFr);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération du fournisseur par codeSapFr : " + e.getMessage());
        }
    }

    @Override
    public Fournisseur updateFournisseurByCodeSapFr(Long codeSapFr, Fournisseur updatedFournisseur) {
        try {
            Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
            if (existingFournisseur != null) {
                return fournisseurRepository.save(existingFournisseur);
            } else {
                throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour du fournisseur par codeSapFr : " + e.getMessage());
        }
    }

    @Override
    public void deleteFournisseurByCodeSapFr(Long codeSapFr) {
        try {
            Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
            if (existingFournisseur != null) {
                fournisseurRepository.delete(existingFournisseur);
            } else {
                throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression du fournisseur par codeSapFr : " + e.getMessage());
        }
    }
}
