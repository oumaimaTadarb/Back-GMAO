package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.FamilleDTO;
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

   Famille addNewFamille(FamilleDTO FamilleDTO);

   Famille affectFamilleMereToFamille(Long idFamille, Long idFamilleMere);

    void deleteFamille(Long idFamille);

    Famille updateFamilleName(Long idFamille, String name);

    List<ArticleDTO> listArticlesDtoOfFamille(Long idFamille);
    //List<Article> listArticlesOfFamille(Long idFamille);

    List<FamilleDTO> listSousFamillesDTO(Long idFamilleMere);

    //List<Famille> listSousFamilles(Long idFamilleMere);

    List<Famille> listFamilles();
    List<FamilleDTO> listFamillesDTO();

    Famille loadFamilleById(Long id);
    FamilleDTO loadFamilleDTOByID(Long id);

    Famille loadFamilleMereByIdFamille(Long id);
    FamilleDTO loadFamilleMereDTOByIdFamille(Long id);

    FamilleDTO convertToFamilleDTO(Famille Famille);


}
