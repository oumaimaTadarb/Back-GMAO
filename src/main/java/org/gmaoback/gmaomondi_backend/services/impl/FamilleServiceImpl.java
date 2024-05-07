package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.models.Article;
import org.gmaoback.gmaomondi_backend.dao.models.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.gmaoback.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilleServiceImpl implements FamilleService {

    @Autowired
    private FamilleRepository familleRepository;

    @Override
    public Famille saveFamille(Famille famille) {
        try {
            if (famille.getFamilleMere() == null) {
                throw new IllegalArgumentException("La famille mère ne peut pas être null.");
            }
            return familleRepository.save(famille);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de la famille : " + e.getMessage());
        }
    }

    @Override
    public void deleteFamilleById(Long idFamille) {
        try {
            Famille famille = familleRepository.findById(idFamille)
                    .orElseThrow(() -> new IllegalArgumentException("La famille n'existe pas."));
            if (!famille.getArticles().isEmpty()) {
                throw new IllegalStateException("La famille contient des articles et ne peut pas être supprimée.");
            }

            List<Famille> famillesMeres = familleRepository.findByFamilleMereId(idFamille);
            if (!famillesMeres.isEmpty()) {
                throw new IllegalStateException("La famille est une famille mère d'une autre famille et ne peut pas être supprimée.");
            }
            familleRepository.deleteById(idFamille);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de la famille : " + e.getMessage());
        }
    }

    @Override
    public List<Article> getAllArticlesByFamilleId(Long idFamille) {
        try {
            Famille famille = familleRepository.findById(idFamille)
                    .orElseThrow(() -> new IllegalArgumentException("La famille n'existe pas."));
            return famille.getArticles();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des articles de la famille : " + e.getMessage());
        }
    }

    @Override
    public List<Famille> getFamillesFillesById(Long idFamille) {
        try {
            List<Famille> famillesFilles = familleRepository.findByFamilleMereId(idFamille);
            if (famillesFilles.isEmpty()) {
                throw new IllegalArgumentException("Aucune famille fille trouvée pour l'ID de famille mère donné.");
            }
            return famillesFilles;
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des familles filles : " + e.getMessage());
        }
    }

    @Override
    public List<Long> getAllSapCodesByFamilleId(Long idFamille) {
        try {
            Famille famille = familleRepository.findById(idFamille)
                    .orElseThrow(() -> new IllegalArgumentException("La famille n'existe pas."));
            List<Article> articles = famille.getArticles();
            return articles.stream()
                    .map(Article::getCodeSapAr)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des codes SAP de la famille : " + e.getMessage());
        }
    }

    @Override
    public Famille updateFamille(Famille famille) {
        try {
            if (familleRepository.existsById(famille.getIdFamille())) {
                return familleRepository.save(famille);
            } else {
                throw new IllegalArgumentException("Famille non trouvée avec l'identifiant : " + famille.getIdFamille());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de la famille : " + e.getMessage());
        }
    }

    @Override
    public Famille getFamilleById(Long idFamille) {
        try {
            return familleRepository.findById(idFamille)
                    .orElseThrow(() -> new IllegalArgumentException("Famille non trouvée avec l'identifiant : " + idFamille));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de la famille par ID : " + e.getMessage());
        }
    }
}
