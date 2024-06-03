package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.PersonneRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.SortieRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.SortieDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortieServiceImpl implements SortieService {
    @Autowired
    private SortieRepository sortieRepository;

    @Autowired
    private PersonneRepository personneRepository;

    public Sortie addNewSortie(SortieDTO sortieDto) {
        Sortie nouvelleSortie = new Sortie();
        mapSortieDtoToSortie(sortieDto, nouvelleSortie);
        return sortieRepository.save(nouvelleSortie);
    }

    public Sortie updateSortie(Long id, SortieDTO sortieDTO) {
        return sortieRepository.findById(id)
                .map(sortieToUpdate -> {
                    mapSortieDtoToSortie(sortieDTO, sortieToUpdate);
                    return sortieRepository.save(sortieToUpdate);
                })
                .orElse(null);
    }

    public Sortie updateDataSortie(Sortie sortie, SortieDTO sortieDto) {
        if (sortie != null && sortieDto != null) {
            mapSortieDtoToSortie(sortieDto, sortie);
            sortieRepository.save(sortie);
        }
        return sortie;
    }

    public void deleteSortie(Long id) {
        sortieRepository.deleteById(id);
    }

    public List<SortieDTO> listSortiesDTO() {
        return sortieRepository.findAll().stream()
                .map(this::convertToSortieDTO)
                .collect(Collectors.toList());
    }

    public List<Sortie> listSorties() {
        return sortieRepository.findAll();
    }

    public Sortie loadSortieById(Long id) {
        return sortieRepository.findById(id).orElse(null);
    }

//    public SortieDTO loadSortieBySortieId(Long id) {
//        return sortieRepository.findById(id)
//                .map(this::convertToSortieDTO)
//                .orElse(null);
//    }

    public SortieDTO convertToSortieDTO(Sortie sortie) {
        SortieDTO sortieDTO = new SortieDTO();
        mapSortieToSortieDto(sortie, sortieDTO);
        return sortieDTO;
    }

    @Override
    public List<Sortie> getSortiesByEtat(EtatSortie etat) {
        return sortieRepository.findByEtat(etat);
    }

    private void mapSortieDtoToSortie(SortieDTO sortieDto, Sortie sortie) {
        if (sortieDto != null && sortie != null) {
            sortie.setDateDemande(sortieDto.getDateDemande());
            sortie.setDateValidation(sortieDto.getDateValidation());
            sortie.setDocument(sortieDto.getDocument());
            sortie.setEtat(EtatSortie.valueOf(String.valueOf(sortieDto.getEtat())));
            sortie.setPersonne(getPersonneFromId(sortieDto.getIdPersonne()));
        }
    }

    private void mapSortieToSortieDto(Sortie sortie, SortieDTO sortieDTO) {
        if (sortie != null && sortieDTO != null) {
            sortieDTO.setIdSortie(sortie.getIdSortie());
            sortieDTO.setDateDemande(sortie.getDateDemande());
            sortieDTO.setDateValidation(sortie.getDateValidation());
            sortieDTO.setDocument(sortie.getDocument());
            sortieDTO.setEtat(EtatSortie.valueOf(String.valueOf(sortie.getEtat())));
        }
    }

    private Personne getPersonneFromId(Long personneId) {
        return personneRepository.findById(personneId).orElse(null);
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
