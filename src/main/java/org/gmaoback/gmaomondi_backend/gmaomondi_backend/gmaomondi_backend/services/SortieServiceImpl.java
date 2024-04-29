package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Sortie;
import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.repositories.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieServiceImpl implements SortieService {
    @Autowired
    SortieRepository sortieRepository;
    @Override
    public Sortie saveSortie(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    @Override
    public Sortie updateSortie(Sortie sortie) {
        if (sortieRepository.existsById(sortie.getIdSortie())) {
            return sortieRepository.save(sortie);
        } else {
            throw new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + sortie.getIdSortie());
        }
    }

    @Override
    public Sortie getSortieById(Long idSortie) {
        return sortieRepository.findById(idSortie)
                .orElseThrow(() -> new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + idSortie));
    }

    @Override
    public List<Sortie> getAllSorties() {
        return sortieRepository.findAll();
    }

    @Override
    public void deleteSortieById(Long idSortie) {
        sortieRepository.deleteById(idSortie);
    }

    @Override
    public Page<Sortie> getAllSortiesByPage(int page, int size) {
        return sortieRepository.findAll(PageRequest.of(page, size));
    }
}