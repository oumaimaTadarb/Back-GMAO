package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Sortie;
import org.gmaoback.gmaomondi_backend.gestionStock.enums.EtatSortie;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.SortieDTO;

import java.util.List;

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

