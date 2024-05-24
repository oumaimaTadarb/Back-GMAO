package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Article;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.ArticleRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.InventaireRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.PersonneRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.InventaireDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventaireServiceImpl implements InventaireService {

    @Autowired
    private InventaireRepository inventaireRepository;

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Inventaire addNewInventaire(InventaireDTO inventaireDto) {
        Inventaire newInventaire = new Inventaire();
        newInventaire.setQuantiteReel(inventaireDto.getQuantiteReel());
        newInventaire.setDateInventaire(inventaireDto.getDateInventaire() != null ? inventaireDto.getDateInventaire() : LocalDateTime.now());
        newInventaire.setJustification(inventaireDto.getJustification());

        Personne personne = personneRepository.findById(inventaireDto.getIdPersonne())
                .orElseThrow(() -> new RuntimeException("Personne not found with id: " + inventaireDto.getIdPersonne()));
        newInventaire.setPersonne(personne);
        Article article = articleRepository.findById(inventaireDto.getIdArticle())
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + inventaireDto.getIdArticle()));

        int newStockDisponible = inventaireDto.getQuantiteReel();
        article.setStockDisponible(newStockDisponible);
        articleRepository.save(article);

        newInventaire.setArticle(article);
        return inventaireRepository.save(newInventaire);

    }

    @Override
    public Inventaire updateInventaire(Long id, InventaireDTO inventaireDTO) {

            Inventaire existingInventaire = inventaireRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Inventaire not found with id: " + id));

            existingInventaire.setQuantiteReel(inventaireDTO.getQuantiteReel());
            existingInventaire.setDateInventaire(inventaireDTO.getDateInventaire() != null ? inventaireDTO.getDateInventaire() : LocalDateTime.now());
            existingInventaire.setJustification(inventaireDTO.getJustification());

            Personne personne = personneRepository.findById(inventaireDTO.getIdPersonne())
                    .orElseThrow(() -> new RuntimeException("Personne not found with id: " + inventaireDTO.getIdPersonne()));
            existingInventaire.setPersonne(personne);
            Article article = articleRepository.findById(inventaireDTO.getIdArticle())
                    .orElseThrow(() -> new RuntimeException("Article not found with id: " + inventaireDTO.getIdArticle()));
            int newStockDisponible = inventaireDTO.getQuantiteReel();
            article.setStockDisponible(newStockDisponible);
            articleRepository.save(article);


            existingInventaire.setArticle(article);

            return inventaireRepository.save(existingInventaire);

    }

    @Override
    public Inventaire updateData(Inventaire existingInventaire, InventaireDTO inventaireDto) {
        existingInventaire.setQuantiteReel(inventaireDto.getQuantiteReel());
        existingInventaire.setDateInventaire(inventaireDto.getDateInventaire() != null ? inventaireDto.getDateInventaire() : LocalDateTime.now());
        existingInventaire.setJustification(inventaireDto.getJustification());

        if (!existingInventaire.getPersonne().getIdPersonne().equals(inventaireDto.getIdPersonne())) {
            Personne personne = personneRepository.findById(inventaireDto.getIdPersonne())
                    .orElseThrow(() -> new RuntimeException("Personne not found with id: " + inventaireDto.getIdPersonne()));
            existingInventaire.setPersonne(personne);
        }
        if (!existingInventaire.getArticle().getIdArticle().equals(inventaireDto.getIdArticle())) {
            Article article = articleRepository.findById(inventaireDto.getIdArticle())
                    .orElseThrow(() -> new RuntimeException("Article not found with id: " + inventaireDto.getIdArticle()));
            article.setStockDisponible(inventaireDto.getQuantiteReel());
            articleRepository.save(article);
            existingInventaire.setArticle(article);
        } else {
            Article article = existingInventaire.getArticle();
            article.setStockDisponible(inventaireDto.getQuantiteReel());
            articleRepository.save(article);
        }

        return existingInventaire;

    }

    @Override
    public void deleteInventaire(Long id) {
            Inventaire inventaire = inventaireRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Inventaire not found with id: " + id));

            inventaireRepository.delete(inventaire);
    }

    @Override
    public List<InventaireDTO> listInventairesDTO() {
        List<Inventaire> allInventaires = inventaireRepository.findAll();

        return allInventaires.stream().map(inventaire -> convertToDTO(inventaire)).collect(Collectors.toList());
    }

    private InventaireDTO convertToDTO(Inventaire inventaire) {
        InventaireDTO dto = new InventaireDTO();
        dto.setIdInventaire(inventaire.getIdInventaire());
        dto.setQuantiteReel(inventaire.getQuantiteReel());
        dto.setDateInventaire(inventaire.getDateInventaire());
        dto.setJustification(inventaire.getJustification());
        if (inventaire.getPersonne() != null) {
            dto.setIdPersonne(inventaire.getPersonne().getIdPersonne());
        }
        if (inventaire.getArticle() != null) {
            dto.setIdArticle(inventaire.getArticle().getIdArticle());
        }
        return dto;
    }

    @Override
    public Page<Inventaire> findAll(Pageable pageable) {
        return inventaireRepository.findAll(pageable);
    }

    @Override
    public Inventaire loadInventaireById(Long id) {
        Optional<Inventaire> result = inventaireRepository.findById(id);

        return result.orElseThrow(() -> new RuntimeException("Inventaire not found with id: " + id));
    }

    @Override
    public InventaireDTO loadInventaireByInventaireId(Long id) {
        Optional<Inventaire> result = inventaireRepository.findById(id);

        return result.map(this::convertToDTO).orElseThrow(() -> new RuntimeException("Inventaire not found with id: " + id));
    }

    @Override
    public List<Inventaire> listInventaires() {
        return inventaireRepository.findAll();
    }
}

//    @Override
//    public Inventaire addNewInventaire(InventaireDTO inventaireDto) {
//        Inventaire inventaire = new Inventaire();
//        inventaire.setQuantiteReel(inventaireDto.getQuantiteReel());
//        inventaire.setDateInventaire(LocalDateTime.now());
//        inventaire.setJustification(inventaireDto.getJustification());
//
//        Personne personne = personneRepository.findById(inventaireDto.getIdPersonne()).orElse(null);
//        if (personne == null) {
//            System.err.println("Erreur: Personne non trouvée.");
//            return null;
//        } else {
//            inventaire.setPersonne(personne);
//        }
//        Article article = articleRepository.findById(inventaireDto.getIdArticle()).orElse(null);
//        if (article == null) {
//            System.err.println("Erreur: Article non trouvé.");
//            return null;
//        } else {
//            int newStockDisponible = inventaireDto.getQuantiteReel();
//            article.setStockDisponible(newStockDisponible);
//            articleRepository.save(article);
//            inventaire.setArticle(article);
//        }
//        return inventaireRepository.save(inventaire);
//    }
//
//    @Override
//    public Inventaire updateInventaire(Long id, InventaireDTO inventaireDTO) {
//        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
//        if (inventaire == null) {
//            System.err.println("Erreur: Inventaire non trouvé.");
//            return null;
//        } else {
//            inventaire.setQuantiteReel(inventaireDTO.getQuantiteReel());
//            inventaire.setJustification(inventaireDTO.getJustification());
//            inventaire.setDateInventaire(LocalDateTime.now());
//            Personne personne = personneRepository.findById(inventaireDTO.getIdPersonne()).orElse(null);
//            if (personne == null) {
//                System.err.println("Erreur: Personne non trouvée.");
//                return null;
//            } else {
//                inventaire.setPersonne(personne);
//            }
//            Article article = articleRepository.findById(inventaireDTO.getIdArticle()).orElse(null);
//            {
//                int newStockDisponible = inventaire.getQuantiteReel();
//                article.setStockDisponible(newStockDisponible);
//                articleRepository.save(article);
//                inventaire.setArticle(article);
//            }
//
//            return inventaireRepository.save(inventaire);
//        }
//    }
//
//    @Override
//    public Inventaire updateData(Inventaire inventaire, InventaireDTO inventaireDto) {
//        inventaire.setQuantiteReel(inventaireDto.getQuantiteReel());
//        inventaire.setJustification(inventaireDto.getJustification());
//        inventaire.setDateInventaire(LocalDateTime.now());
//        Personne personne = personneRepository.findById(inventaireDto.getIdPersonne()).orElse(null);
//        if (personne == null) {
//            System.err.println("Erreur: Personne non trouvée.");
//            return null;
//        } else {
//            inventaire.setPersonne(personne);
//        }
//        Article article = articleRepository.findById(inventaireDto.getIdArticle()).orElse(null);
//        {
//            int newStockDisponible = inventaireDto.getQuantiteReel();
//            article.setStockDisponible(newStockDisponible);
//            articleRepository.save(article);
//            inventaire.setArticle(article);
//        }
//        return inventaire;
//    }
//
//
//    @Override
//    public void deleteInventaire(Long id) {
//        inventaireRepository.deleteById(id);
//        Optional<Inventaire> optionalInventaire = inventaireRepository.findById(id);
//        if (optionalInventaire.isPresent()) {
//            throw new EntityNotFoundException("Inventaire non supprimé");
//
//        }
//    }
//
//    @Override
//    public List<InventaireDTO> listInventairesDTO() {
//        List<Inventaire> inventaires = inventaireRepository.findAll();
//        return inventaires.stream()
//                .map(this::convertToInventaireDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Page<Inventaire> findAll(Pageable pageable) {
//        return inventaireRepository.findAll(pageable);
//
//    }
//
//    public InventaireDTO convertToInventaireDTO(Inventaire inventaire) {
//        if (inventaire == null) {
//            return null;
//        }
//        InventaireDTO inventaireDto = new InventaireDTO();
//        inventaireDto.setIdInventaire(inventaire.getIdInventaire());
//        inventaireDto.setQuantiteReel(inventaire.getQuantiteReel());
//        inventaireDto.setDateInventaire(LocalDateTime.from(LocalDate.from(inventaire.getDateInventaire())));
//        inventaireDto.setJustification(inventaire.getJustification());
//        if (inventaire.getPersonne() != null) {
//            inventaireDto.setIdPersonne(inventaire.getPersonne().getIdPersonne());
//            inventaireDto.setIdInventaire(inventaire.getPersonne().getIdPersonne());
//        }
//        if (inventaire.getArticle() != null) {
//            inventaireDto.setIdArticle(inventaire.getArticle().getIdArticle());
//            inventaireDto.setIdArticle(inventaire.getArticle().getIdArticle());
//        }
//
//        return inventaireDto;
//    }
//
//
//
//
//    @Override
//    public Inventaire loadInventaireById(Long id) {
//        return inventaireRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public InventaireDTO loadInventaireByInventaireId(Long id) {
//        // Retrieve the Inventaire entity from the repository
//        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
//        if (inventaire != null) {
//            InventaireDTO inventaireDto = new InventaireDTO();
//            inventaireDto.setIdInventaire(inventaire.getIdInventaire());
//            inventaireDto.setQuantiteReel(inventaire.getQuantiteReel());
//            inventaireDto.setDateInventaire(LocalDateTime.from(LocalDate.from(inventaire.getDateInventaire())));
//            inventaireDto.setJustification(inventaire.getJustification());
//            if (inventaire.getPersonne() != null) {
//                inventaireDto.setIdPersonne(inventaire.getPersonne().getIdPersonne());
//            }
//            if (inventaire.getArticle() != null) {
//                inventaireDto.setIdArticle(inventaire.getArticle().getIdArticle());
//            }
//            return inventaireDto;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Page<Inventaire> listInventaires(Pageable pageable) {
//        return inventaireRepository.findAll(pageable);
//    }
//}
////    @Override
////    public Inventaire saveInventaire(Inventaire inventaire) {
////        try {
////            return inventaireRepository.save(inventaire);
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de l'enregistrement de l'inventaire : " + e.getMessage());
////        }
////    }
////
////    @Override
////    public Inventaire updateInventaire(Inventaire inventaire) {
////        try {
////            if (inventaireRepository.existsById(inventaire.getIdInventaire())) {
////                return inventaireRepository.save(inventaire);
////            } else {
////                throw new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + inventaire.getIdInventaire());
////            }
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de la mise à jour de l'inventaire : " + e.getMessage());
////        }
////    }
////
////    @Override
////    public Inventaire getInventaireById(Long idInventaire) {
////        try {
////            return inventaireRepository.findById(idInventaire)
////                    .orElseThrow(() -> new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + idInventaire));
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de la récupération de l'inventaire par ID : " + e.getMessage());
////        }
////    }
////
////    @Override
////    public List<Inventaire> getAllInventaires() {
////        try {
////            return inventaireRepository.findAll();
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de la récupération de tous les inventaires : " + e.getMessage());
////        }
////    }
////
////    @Override
////    public void deleteInventaireById(Long idInventaire) {
////        try {
////            inventaireRepository.deleteById(idInventaire);
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de la suppression de l'inventaire par ID : " + e.getMessage());
////        }
////    }
////
////    @Override
////    public Page<Inventaire> getAllInventairesByPage(int page, int size) {
////        try {
////            return inventaireRepository.findAll(PageRequest.of(page, size));
////        } catch (Exception e) {
////            throw new IllegalStateException("Erreur lors de la récupération des inventaires par page : " + e.getMessage());
////        }
////    }
