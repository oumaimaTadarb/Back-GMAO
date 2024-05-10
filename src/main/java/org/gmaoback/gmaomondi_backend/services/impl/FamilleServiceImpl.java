package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.gmaoback.gmaomondi_backend.dto.ArticleDTO;
import org.gmaoback.gmaomondi_backend.dto.FamilleDTO;
import org.gmaoback.gmaomondi_backend.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
public class FamilleServiceImpl implements FamilleService {

    private final FamilleRepository familleRepository;

    private final ArticleRepository ArticleRepository;

    @Autowired
    public FamilleServiceImpl(FamilleRepository familleRepository, ArticleRepository ArticleRepository) {
        this.familleRepository = familleRepository;
        this.ArticleRepository = ArticleRepository;
    }

    @Override
    public Famille addNewFamille(FamilleDTO FamilleDTO){
        Famille famille = new Famille();

        famille.setName(FamilleDTO.getNomFamille());
        if(FamilleDTO.getIdFamilleMere() != null) {
            Famille FamilleMere = getFamilleById(FamilleDTO.getIdFamilleMere());
            System.out.println( FamilleMere);
            famille.setFamilleMere(FamilleMere);
        }
        return this.familleRepository.save(famille);

    }
    @Override
    public Famille affectFamilleMereToFamille(Long idFamille, Long idFamilleMere){
        Famille FamilleMere = getFamilleById(idFamilleMere);
        Famille Famille = getFamilleById(idFamille);
        if(Famille != null && FamilleMere != null){
            Famille.setFamilleMere(FamilleMere);
            return this.familleRepository.save(Famille);
        }
        return null;
    }
    @Override
    public void deleteFamille(Long idFamille){
        Famille Famille = this.getFamilleById(idFamille);
        Famille.setFamilleMere(null);
        Famille.setArticles(null);
        this.familleRepository.save(Famille);
    }
    @Override
    public Famille getFamilleById(Long id) {
        return this.familleRepository
                .findById(id)
                .orElse(null);
    }
    @Override
    public Famille loadFamilleMereByIdFamille(Long id) {
        Famille Famille=this.familleRepository.findById(id).orElse(null);
        if(Famille!=null){
            return Famille.getFamilleMere();
        } else
            return null;
    }

    @Override
    public FamilleDTO loadFamilleDTOByID(Long id) {
        Famille Famille = getFamilleById(id);
        FamilleDTO FamilleDTO= new FamilleDTO();
        if (Famille != null) {
            FamilleDTO.setIdFamille(Famille.getIdFamille());
            FamilleDTO.setNomFamille(Famille.getName());
            if (Famille.getFamilleMere() != null) {
                FamilleDTO.setIdFamilleMere(Famille.getFamilleMere().getIdFamille());
            }
        }
        return FamilleDTO;
    }

    @Override
    public FamilleDTO loadFamilleMereDTOByIdFamille(Long id) {
        Famille Famille = loadFamilleMereByIdFamille(id);
        FamilleDTO FamilleDTO= new FamilleDTO();
        if (Famille != null) {
            FamilleDTO.setIdFamille(Famille.getIdFamille());
            FamilleDTO.setNomFamille(Famille.getName());
            if (Famille.getFamilleMere() != null) {
                FamilleDTO.setIdFamilleMere(Famille.getFamilleMere().getIdFamille());
            }
        }
        return FamilleDTO;
    }

    @Override
    public Famille updateFamilleName(Long idFamille, String name){
        Famille famille = getFamilleById(idFamille);
        famille.setName(name);
        return this.familleRepository.save(famille);
    }

    @Override
    public List<Famille> listFamilles(){

        return this.familleRepository.findAll();
    }

    @Override
    public List<FamilleDTO> listFamillesDTO(){
        List<Famille> Familles = this.familleRepository.findAll();
        List<FamilleDTO> FamillesDTO = Familles.stream()
                .map(this::convertToFamilleDTO)
                .collect(Collectors.toList());
        return FamillesDTO; // Return the list of ClientDTOs
    }
    @Override
    public FamilleDTO convertToFamilleDTO(Famille Famille) {
        if(Famille == null){
            return null;
        }
        FamilleDTO FamilleDto = new FamilleDTO();
        FamilleDto.setNomFamille(Famille.getName());
        FamilleDto.setIdFamille(Famille.getIdFamille());
        if(Famille.getFamilleMere() != null) {
            FamilleDto.setIdFamilleMere(Famille.getFamilleMere().getIdFamille());
        }
        return FamilleDto;
    }

    @Override
    public List<ArticleDTO> listArticlesDtoOfFamille(Long idFamille){
        List<Article>Articles =getAllArticlesByFamilleId(idFamille);
        return null;
    }

    @Override
    public List<FamilleDTO> listSousFamillesDTO(Long idFamilleMere){
        List<Famille> Familles =getFamillesFillesById(idFamilleMere);
        List<FamilleDTO> FamillesDTO = Familles.stream()
                .map(this::convertToFamilleDTO)
                .collect(Collectors.toList());
        return FamillesDTO;
    }

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
                    .map(Article::getCodeSapArticle)
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

//    @Override
//    public Famille getFamilleById(Long idFamille) {
//        try {
//            return familleRepository.findById(idFamille)
//                    .orElseThrow(() -> new IllegalArgumentException("Famille non trouvée avec l'identifiant : " + idFamille));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de la famille par ID : " + e.getMessage());
//        }
//    }


}
