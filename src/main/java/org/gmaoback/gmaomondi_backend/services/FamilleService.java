package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.models.Article;
import org.gmaoback.gmaomondi_backend.dao.models.Famille;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamilleService {


    Famille updateFamille(Famille famille);
    Famille getFamilleById(Long idFamille);

    Famille saveFamille(Famille famille);

    void deleteFamilleById(Long idFamille);
   List<Article> getAllArticlesByFamilleId(Long idFamille);
   List<Famille> getFamillesFillesById(Long idFamille);
   List<Long> getAllSapCodesByFamilleId(Long idFamille);
}
