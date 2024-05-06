package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Sortie;
import org.gmaoback.gmaomondi_backend.dao.repositories.SortieRepository;
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
        try {
            return sortieRepository.save(sortie);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de la sortie : " + e.getMessage());
        }
    }

    @Override
    public Sortie updateSortie(Sortie sortie) {
        try {
            if (sortieRepository.existsById(sortie.getIdSortie())) {
                return sortieRepository.save(sortie);
            } else {
                throw new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + sortie.getIdSortie());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de la sortie : " + e.getMessage());
        }
    }

    @Override
    public Sortie getSortieById(Long idSortie) {
        try {
            return sortieRepository.findById(idSortie)
                    .orElseThrow(() -> new IllegalArgumentException("Sortie non trouvée avec l'identifiant : " + idSortie));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de la sortie par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Sortie> getAllSorties() {
        try {
            return sortieRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de toutes les sorties : " + e.getMessage());
        }
    }

    @Override
    public void deleteSortieById(Long idSortie) {
        try {
            sortieRepository.deleteById(idSortie);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de la sortie par ID : " + e.getMessage());
        }
    }

    @Override
    public Page<Sortie> getAllSortiesByPage(int page, int size) {
        try {
            return sortieRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des sorties par page : " + e.getMessage());
        }
    }
}
