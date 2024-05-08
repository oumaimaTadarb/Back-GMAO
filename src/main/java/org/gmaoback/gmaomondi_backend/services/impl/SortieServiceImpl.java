package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dao.repositories.PersonneRepository;
import org.gmaoback.gmaomondi_backend.dao.repositories.SortieRepository;
import org.gmaoback.gmaomondi_backend.dto.SortieDTO;
import org.gmaoback.gmaomondi_backend.enums.EtatSortie;
import org.gmaoback.gmaomondi_backend.services.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SortieServiceImpl implements SortieService {

    @Autowired
    SortieRepository sortieRepository;
    @Autowired
    PersonneRepository personneRepository;
    @Override
    public Sortie addNewSortie(SortieDTO sortieDto) {
            Sortie nouvelleSortie = new Sortie();
            nouvelleSortie.setDateDemande(sortieDto.getDateDemande());
            nouvelleSortie.setDateValidation(sortieDto.getDateValidation());
            nouvelleSortie.setCommentaire(sortieDto.getCommentaire());
            nouvelleSortie.setDocument(sortieDto.getDocument());
            nouvelleSortie.setEtat(EtatSortie.valueOf(sortieDto.getEtat()));

            Personne personne = personneRepository.findById(sortieDto.getIdPersonne()).orElse(null);
            nouvelleSortie.setPersonne(personne);

            return sortieRepository.save(nouvelleSortie);
        }


    @Transactional
    @Override
    public Sortie updateSortie(Long id, SortieDTO sortieDTO) {
        return null;
    }

    @Override
    public Sortie updateData(Sortie Sortie, SortieDTO sortieDto) {
        return null;
    }

    @Override
    public void deleteSortie(Long id) {

    }

    @Override
    public List<SortieDTO> listSortiesDTO() {
        return null;
    }

    @Override
    public List<Sortie> listSorties() {
        return null;
    }

    @Override
    public Sortie loadSortieById(Long id) {
        return null;
    }

    @Override
    public SortieDTO loadSortieBySortieId(Long id) {
        return null;
    }

//    @Override
//    public Sortie saveSortie(Sortie sortie) {
//        try {
//            return sortieRepository.save(sortie);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement de la sortie : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Sortie updateSortie(Sortie sortie) {
//        try {
//            if (sortieRepository.existsById(sortie.getIdSortie())) {
//                return sortieRepository.save(sortie);
//            } else {
//                throw new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + sortie.getIdSortie());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de la sortie : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Sortie getSortieById(Long idSortie) {
//        try {
//            return sortieRepository.findById(idSortie)
//                    .orElseThrow(() -> new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + idSortie));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de la sortie par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Sortie> getAllSorties() {
//        try {
//            return sortieRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de toutes les sorties : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteSortieById(Long idSortie) {
//        try {
//            sortieRepository.deleteById(idSortie);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression de la sortie par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Page<Sortie> getAllSortiesByPage(int page, int size) {
//        try {
//            return sortieRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des sorties par page : " + e.getMessage());
//        }
//    }
}
