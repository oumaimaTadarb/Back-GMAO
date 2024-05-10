package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.dto.SortieDTO;
import org.gmaoback.gmaomondi_backend.enums.EtatSortie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortieService {
    Sortie addNewSortie(SortieDTO sortieDto);
    Sortie updateSortie(Long id, SortieDTO sortieDTO);
    void deleteSortie(Long id);
    List<SortieDTO> listSortiesDTO();
    List<Sortie> listSorties();
    Sortie loadSortieById(Long id);
    Sortie updateDataSortie(Sortie Sortie, SortieDTO sortieDto);
    SortieDTO convertToSortieDTO(Sortie updatedSortie);
    List<Sortie> getSortiesByEtat(EtatSortie etat);

//    SortieDTO loadSortieBySortieId(Long id);
//    Sortie saveSortie(Sortie sortie);
//    Sortie updateSortie(Sortie sortie);
//    Sortie getSortieById(Long idSortie);
//    List<Sortie> getAllSorties();
//    void deleteSortieById(Long idSortie);
//    Page<Sortie> getAllSortiesByPage(int page, int size);
}

