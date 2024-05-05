package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Article;
import org.gmaoback.gmaomondi_backend.dao.entites.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilleServiceImpl implements FamilleService {

    @Autowired
    private FamilleRepository familleRepository;
    public Famille saveFamille(Famille famille) {
        if (famille.getFamilleMere() == null) {
            throw new IllegalArgumentException("La famille mère ne peut pas être null.");
        }
        return familleRepository.save(famille);

}

    @Override
    public void deleteFamilleById(Long idFamille) {
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
    }
    @Override
    public List<Article> getAllArticlesByFamilleId(Long idFamille) {
        Famille famille = familleRepository.findById(idFamille)
                .orElseThrow(() -> new IllegalArgumentException("La famille n'existe pas."));
        return famille.getArticles();
    }

    @Override
    public List<Famille> getFamillesFillesById(Long idFamille) {
        List<Famille> famillesFilles = familleRepository.findByFamilleMereId(idFamille);
        if (famillesFilles.isEmpty()) {
            throw new IllegalArgumentException("Aucune famille fille trouvée pour l'ID de famille mère donné.");
        }
        return famillesFilles;
    }

    @Override
    public List<Long> getAllSapCodesByFamilleId(Long idFamille) {
        Famille famille = familleRepository.findById(idFamille)
                .orElseThrow(() -> new IllegalArgumentException("La famille n'existe pas."));
        List<Article> articles = famille.getArticles();
        return articles.stream()
                .map(Article::getCodeSapAr)
                .collect(Collectors.toList());
    }
}

