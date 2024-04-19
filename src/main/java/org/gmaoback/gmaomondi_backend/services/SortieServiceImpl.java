package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Sortie;
import org.gmaoback.gmaomondi_backend.repositories.SortieRepository;
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
        return sortieRepository.save(sortie);
    }
    @Override
    public Sortie getSortieById(Long idBC) {
        return sortieRepository.findById(idBC).get();
    }

    @Override
    public List<Sortie> getAllSorties() {
        return sortieRepository.findAll();
    }
    //@Override
    // public List<Sortie> finAllByIdFournisseur(Long idFournisseur) {
    //     return sortieRepository.findAllByIdFournisseur(IdFournisseur);
    // }



    @Override
    public void deleteSortieById(Long idSortie) {
        sortieRepository.deleteById(idSortie);
    }

    @Override
    public Page<Sortie> getAllSortiesByPage(int page, int size) {
        return sortieRepository.findAll(PageRequest.of(page,size));
    }
}
