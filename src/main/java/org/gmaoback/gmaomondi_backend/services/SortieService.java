package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Sortie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortieService {
    Sortie saveSortie(Sortie sortie);
    Sortie updateSortie(Sortie sortie);
    Sortie getSortieById(Long idSortie);
    List<Sortie> getAllSorties();
    void deleteSortieById(Long idSortie);
    Page<Sortie> getAllSortiesByPage(int page, int size);
}

